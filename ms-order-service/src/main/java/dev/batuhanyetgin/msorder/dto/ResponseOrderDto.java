package dev.batuhanyetgin.msorder.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ResponseOrderDto {
    private LocalDateTime orderDate;
    private Long totalPrice;
    private List<OrderBookDto> orderBookList;
}
