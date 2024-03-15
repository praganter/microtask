package dev.batuhanyetgin.msorder.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDto {
    @NotNull(message = "Check your isbn")
    private Long isbn;

    @Min(value = 1, message = "Lowest value is 1")
    private Integer quantity;
}
