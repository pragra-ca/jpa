package co.pragra.learning.pragraec;

import co.pragra.learning.pragraec.dao.CustRepo;
import co.pragra.learning.pragraec.dao.CustomerRepo;
import co.pragra.learning.pragraec.entities.Customer;
import co.pragra.learning.pragraec.entities.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class PragraEcApplication {

    public static void main(String[] args) {
       ApplicationContext context=  SpringApplication.run(PragraEcApplication.class, args);
        CustRepo repo = context.getBean(CustRepo.class);

        log.info("Customer with id -> {} ", repo.findById(100L));
        repo.save(Customer.builder().id(1000L)
                .status(Status.NEW)
                .createDate(new Date())
                .updateDate(new Date())
                .firstName("Nikhil")
                .lastName("Jadav").build());
        log.info("All Customer -> [{}] ", repo.findAll());
    }

}
