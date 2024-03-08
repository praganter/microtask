package dev.batuhanyetgin.msorder.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDto {
    @NotNull(message = "Check your isbn")
    private Long isbn;

    @Min(value = 1, message = "Lowest value is 1")
    private Integer quantity;
}
