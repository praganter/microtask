package dev.batuhanyetgin.msorder.service.impl;

import dev.batuhanyetgin.msbookservice.dto.BookDto;
import dev.batuhanyetgin.mscustomer.dto.CustomerDto;
import dev.batuhanyetgin.mscustomer.entity.CustomerEntity;
import dev.batuhanyetgin.msorder.client.BookServiceClient;
import dev.batuhanyetgin.msorder.client.CustomerServiceClient;
import dev.batuhanyetgin.msorder.client.SecurityServiceClient;
import dev.batuhanyetgin.msorder.dto.CreateOrderDto;
import dev.batuhanyetgin.msorder.dto.CustomerDto;
import dev.batuhanyetgin.msorder.dto.OrderBookDto;
import dev.batuhanyetgin.msorder.dto.ResponseOrderDto;
import dev.batuhanyetgin.msorder.entity.OrderBookEntity;
import dev.batuhanyetgin.msorder.entity.OrderEntity;
import dev.batuhanyetgin.msorder.repository.OrderBookRepository;
import dev.batuhanyetgin.msorder.repository.OrderRepository;
import dev.batuhanyetgin.msorder.service.abstruct.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
    private final SecurityServiceClient securityServiceClient;
    private final CustomerServiceClient customerServiceClient;
    private final BookServiceClient bookServiceClient;
    private final ModelMapper modelMapper;
    @Override
    public ResponseOrderDto createOrder(List<CreateOrderDto> createOrderDtoList, String token) {
        CustomerDto customerDto =getCustomerFromToken(token);
        List<BookDto> bookDtoList = new ArrayList<>();
        OrderEntity orderEntity = new OrderEntity();
        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < createOrderDtoList.size(); i++) {
            OrderBookEntity.builder().
        }

        orderRepository.save(
                OrderEntity.builder().
                        orderDate(LocalDateTime.now()).
                        customer(modelMapper.map(customerDto,CustomerEntity.class)).




                        .build());


        return
    }

    @Override
    public CustomerDto getCustomerFromToken(String token) {
        return  customerServiceClient.getByMail( securityServiceClient.getEmailFromToken(token));
    }

    private BookDto getBookByIsbn(Long isbn){
        return bookServiceClient.getDetails(isbn).getBody();
    }
}
