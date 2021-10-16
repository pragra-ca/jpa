package co.pragra.learning.pragraec.dao;

import co.pragra.learning.pragraec.entities.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Data
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class CustomerRepo {

    @PersistenceContext
    private final EntityManager manager;

    public Customer create(Customer customer) {
        manager.persist(customer);
        return customer;
    }
    public Customer update(Customer customer){
        return manager.merge(customer);
    }
    public Customer findOne(Long id){
       return manager.find(Customer.class, id);
    }
    public List<Customer> findAll(){
        return manager.find(List.class, null);
    }
}
