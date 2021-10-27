package co.pragra.learning.pragraec.controller;

import co.pragra.learning.pragraec.entities.Customer;
import co.pragra.learning.pragraec.entities.Status;
import co.pragra.learning.pragraec.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController {
    private final CustomerService service;

    @GetMapping("/")
    public String getHome(Model model){

        model.addAttribute("greeting", "Welcome to our spring class");
        model.addAttribute("customer", service.getAllCustomerByStatus(Status.NEW));
        return "index";
    }

    @PostMapping("/add")
    public String createCustomer(@ModelAttribute Customer customer, Model model){
        model.addAttribute("customer", customer);
        service.createCustomer(customer);
        return "thankyou";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute Customer customer, Model model){
        model.addAttribute("customer", customer);
        return "create";
    }

}
