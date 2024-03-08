package dev.batuhanyetgin.msorder.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderBookDto {
    private Long isbn;
    private String name;
    private int price;
    private int quantity;
}
