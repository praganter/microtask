package dev.batuhanyetgin.mscustomer.service.abstruct;

import dev.batuhanyetgin.mscustomer.dto.CreateCustomerDto;
import dev.batuhanyetgin.mscustomer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    void createCustomer(CreateCustomerDto customerDto);

    List<CustomerDto> getAllCustomer();
}
