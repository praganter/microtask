package dev.batuhanyetgin.msbookservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long isbn;
    private String name;
    private String stock;
    private int price;
}
