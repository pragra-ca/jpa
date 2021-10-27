package co.pragra.learning.pragraec.controller;

import co.pragra.learning.pragraec.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/customer/{id}")
    public String getCustomerByName(@PathVariable("id") Long id, Model model){
        service.findById(id).ifPresent(s->model.addAttribute("cust",s));
        return "customer";
    }

    @GetMapping("/customer")
    public String getByFirstAndLastName(
            @RequestParam(value = "firstName", required = false)String firstName,
            @RequestParam(value = "lastName", required = false)String lastName, Model model){
        model.addAttribute("customer",service.getAllCustomerByFirstNameAndLastName(firstName,lastName));
        return "index";
    }
}
