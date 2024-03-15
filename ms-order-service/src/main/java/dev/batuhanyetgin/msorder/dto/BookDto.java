package dev.batuhanyetgin.msorder.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long isbn;
    private String name;
    private int stock;
    private int price;
}
