package dev.batuhanyetgin.mscustomer.service.abstruct;

import dev.batuhanyetgin.mscustomer.dto.CustomerDto;
import dev.batuhanyetgin.mscustomer.dto.RegisterDto;
import dev.batuhanyetgin.mscustomer.exception.UserNotFoundException;

import java.util.List;

public interface CustomerService {

    void createCustomer(RegisterDto customerDto);

    List<CustomerDto> getAllCustomer();

    boolean isCustomerExist(String email);

    CustomerDto getByEmail(String email) throws UserNotFoundException;
}
