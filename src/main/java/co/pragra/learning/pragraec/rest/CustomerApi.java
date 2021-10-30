package co.pragra.learning.pragraec.rest;


import co.pragra.learning.pragraec.dto.CustomerDTO;
import co.pragra.learning.pragraec.dto.ErrorResponse;
import co.pragra.learning.pragraec.entities.Customer;
import co.pragra.learning.pragraec.entities.Status;
import co.pragra.learning.pragraec.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService service;
    @PostMapping
    public ResponseEntity<?> add(@RequestHeader("add") boolean add, @RequestBody CustomerDTO customerDTO){
        if(add){
            return ResponseEntity.accepted().body(service.addCustomer(customerDTO));
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                .body(customerDTO);

    }

    @PutMapping
    public CustomerDTO update(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
         service.deleteCustomer(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomer(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-idea",  String.valueOf(service.getAllCustomerByStatus(Status.NEW).size()));
        headers.add("Author",  "Subhham");

        if(service.getAllCustomerByStatus(Status.NEW).size()==0){
            ErrorResponse response = ErrorResponse.builder().errCode("NOTFOUND-400")
                    .errDesc("No Customer with Status.Approved").dateTime(Instant.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(response);
        }
        return new ResponseEntity<>(service.getAllCustomerByStatus(Status.NEW), headers, HttpStatus.OK);
    }
}
