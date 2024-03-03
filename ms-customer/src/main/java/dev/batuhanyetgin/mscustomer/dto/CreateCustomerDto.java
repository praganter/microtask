package dev.batuhanyetgin.mscustomer.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerDto {
    private String name;
    private String email;
    private String password;
}
