package dev.batuhanyetgin.msorder.dto;

import dev.batuhanyetgin.mscustomer.entity.CustomerEntity;
import dev.batuhanyetgin.msorder.entity.OrderBookEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long id;

    private LocalDateTime orderDate;

    private Long totalPrice;

    private CustomerEntity customer;

    private List<OrderBookEntity> orderBookList;
}
