package co.pragra.learning.pragraec.service;

import co.pragra.learning.pragraec.dao.CustRepo;
import co.pragra.learning.pragraec.dto.CustomerDTO;
import co.pragra.learning.pragraec.entities.Customer;
import co.pragra.learning.pragraec.entities.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustRepo repo;
    private final CustomerMapper mapper;

    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        return mapper.toCustomerDTO(repo.save(mapper.toCustomerEntity(customerDTO)));
    }

    public CustomerDTO updateCustomer(Customer customer){
        return mapper.toCustomerDTO(repo.save(customer));
    }

    public void deleteCustomer(long id){
         repo.deleteById(id);
    }

    public List<Customer> getAllCustomerByStatus(Status status){
        return repo.getAllByStatus(status);
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return repo.findById(id);
    }

    public List<Customer> getAllCustomerByFirstNameAndLastName(String firstName, String lastName) {
        if(firstName == null && lastName == null) {
            return repo.findAll();
        }
        if(firstName==null && lastName!=null) {
            return repo.findAllByLastName(lastName);
        }
        if(firstName!=null && lastName==null) {
            return repo.findAllByFirstName(firstName);
        }
        return repo.findAllByFirstNameAndLastName(firstName, lastName);
    }
}
