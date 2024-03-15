package dev.batuhanyetgin.msorder.service.impl;

import dev.batuhanyetgin.msorder.client.BookServiceClient;
import dev.batuhanyetgin.msorder.client.CustomerServiceClient;
import dev.batuhanyetgin.msorder.client.SecurityServiceClient;
import dev.batuhanyetgin.msorder.dto.*;
import dev.batuhanyetgin.msorder.entity.OrderBookEntity;
import dev.batuhanyetgin.msorder.entity.OrderEntity;
import dev.batuhanyetgin.msorder.exception.BookNotFoundException;
import dev.batuhanyetgin.msorder.repository.OrderBookRepository;
import dev.batuhanyetgin.msorder.repository.OrderRepository;
import dev.batuhanyetgin.msorder.service.abstruct.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
    private final SecurityServiceClient securityServiceClient;
    private final CustomerServiceClient customerServiceClient;
    private final BookServiceClient bookServiceClient;
    private final ModelMapper modelMapper;


    private void addOrderEntity(String token, Integer totalPrice) {

        OrderEntity orderEntity = OrderEntity.builder()
                .orderDate(LocalDateTime.now())
                .customer_id(getCustomerFromToken(token.substring(7)).getId())
                .totalPrice(totalPrice)
                .build();
        orderRepository.save(orderEntity);
        log.info("Order Entity saved : " + orderEntity);
    }

    @Override
    public ResponseOrderDto createOrder(List<CreateOrderDto> createOrderDtoList, String token) throws BookNotFoundException {
        List<OrderBookEntity> orderBookEntityList = new ArrayList<>();

        OrderEntity newOrder;
        int orderTotalPrice = 0;
        int totalPrice = 0;

        for (CreateOrderDto createOrderDto : createOrderDtoList) {
            if (bookServiceClient.isExists(createOrderDto.getIsbn())) {
                BookDto bookDto = bookServiceClient.getDetails(createOrderDto.getIsbn());
                totalPrice += bookDto.getPrice() * createOrderDto.getQuantity();
                orderTotalPrice += totalPrice;
                orderBookEntityList.add(OrderBookEntity.builder()
                        .isbn(createOrderDto.getIsbn())
                        .name(bookDto.getName())
                        .quantity(createOrderDto.getQuantity())
                        .totalPrice(totalPrice)
                        .build());
                removeFromStock(bookDto, createOrderDto.getQuantity());
            } else {
                throw new BookNotFoundException("Book not found check your list.");
            }
        }
        addOrderEntity(token, orderTotalPrice);

        for (OrderBookEntity orderBookEntity : orderBookEntityList) {
            newOrder = getLatestOrder();
            orderBookEntity.setOrder(newOrder);
            orderBookRepository.save(modelMapper.map(orderBookEntity, OrderBookEntity.class));
            log.info(orderBookEntity + " saved.");
        }


        return ResponseOrderDto.builder()
                .totalPrice(totalPrice)
                .orderBookList(orderBookEntityList.stream()
                        .map(orderBookEntity -> modelMapper.map(orderBookEntity, OrderBookDto.class))
                        .toList())
                .build();

    }

    @Override
    public CustomerDto getCustomerFromToken(String token) {
        return customerServiceClient.getByMail(securityServiceClient.getEmailFromToken(token));
    }

    @Override
    public OrderEntity getLatestOrder() {
        return orderRepository.findFirstByOrderByOrderDateDesc();
    }

    private void removeFromStock(BookDto bookDto, int quantity) {
        bookDto.setStock(bookDto.getStock() - quantity);
        bookServiceClient.removeStock(bookDto);
    }
}
