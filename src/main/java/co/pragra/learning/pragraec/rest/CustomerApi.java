package co.pragra.learning.pragraec.rest;

import co.pragra.learning.pragraec.entities.Customer;
import co.pragra.learning.pragraec.entities.Status;
import co.pragra.learning.pragraec.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService service;

    @GetMapping("/customer")
    public List<Customer> getAll(){
        return service.getAllCustomerByStatus(Status.NEW);
    }
}
