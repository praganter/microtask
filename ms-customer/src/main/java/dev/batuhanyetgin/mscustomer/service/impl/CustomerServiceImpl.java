package dev.batuhanyetgin.mscustomer.service.impl;

import dev.batuhanyetgin.mscustomer.dto.CreateCustomerDto;
import dev.batuhanyetgin.mscustomer.dto.CustomerDto;
import dev.batuhanyetgin.mscustomer.entity.CustomerEntity;
import dev.batuhanyetgin.mscustomer.repository.CustomerRepository;
import dev.batuhanyetgin.mscustomer.service.abstruct.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public void createCustomer(CreateCustomerDto customerDto) {
      if ( repository.existsByEmail(customerDto.getEmail())){
            log.warn("Email already registered.");
      }else {
          repository.save(modelMapper.map(customerDto, CustomerEntity.class));
          log.info("Customer saved");
      }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return repository.findAll().stream()
                .map(customerEntity -> modelMapper.map(customerEntity, CustomerDto.class))
                .toList();
    }


}
