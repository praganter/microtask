package dev.batuhanyetgin.msorder.service.abstruct;

import dev.batuhanyetgin.mscustomer.dto.CustomerDto;
import dev.batuhanyetgin.msorder.dto.CreateOrderDto;
import dev.batuhanyetgin.msorder.dto.ResponseOrderDto;

import java.util.List;

public interface OrderService {

    ResponseOrderDto createOrder(List<CreateOrderDto> createOrderDtoList, String token);


    CustomerDto getCustomerFromToken(String token);

}
