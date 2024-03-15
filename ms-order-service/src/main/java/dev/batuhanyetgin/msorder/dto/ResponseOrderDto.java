package dev.batuhanyetgin.msorder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponseOrderDto {
    private Integer totalPrice;
    private List<OrderBookDto> orderBookList;
}
