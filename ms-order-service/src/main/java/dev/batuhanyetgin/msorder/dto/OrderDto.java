package dev.batuhanyetgin.msorder.dto;

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

    private Integer totalPrice;

    private Long customer_id;

    private List<OrderBookEntity> orderBookList;
}
