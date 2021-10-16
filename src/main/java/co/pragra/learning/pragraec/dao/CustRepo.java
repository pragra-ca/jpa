package co.pragra.learning.pragraec.dao;

import co.pragra.learning.pragraec.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustRepo extends JpaRepository<Customer,Long> {

}
