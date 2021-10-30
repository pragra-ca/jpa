package co.pragra.learning.pragraec.service;

import co.pragra.learning.pragraec.dto.CustomerDTO;
import co.pragra.learning.pragraec.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomerEntity(CustomerDTO customerDTO){
        return Customer.builder()
                .id(customerDTO.getId())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .status(customerDTO.getStatus())
                .build();
    }

    public CustomerDTO toCustomerDTO(Customer customer){
        return CustomerDTO
                .builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .status(customer.getStatus())
                .build();
    }
}
