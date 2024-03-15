package dev.batuhanyetgin.msorder.service.abstruct;

import dev.batuhanyetgin.msorder.dto.CreateOrderDto;
import dev.batuhanyetgin.msorder.dto.CustomerDto;
import dev.batuhanyetgin.msorder.dto.ResponseOrderDto;
import dev.batuhanyetgin.msorder.entity.OrderEntity;
import dev.batuhanyetgin.msorder.exception.BookNotFoundException;

import java.util.List;

public interface OrderService {

    ResponseOrderDto createOrder(List<CreateOrderDto> createOrderDtoList, String token) throws BookNotFoundException;


    CustomerDto getCustomerFromToken(String token);

    OrderEntity getLatestOrder();

}
