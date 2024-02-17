package net.yassine.customerservice.web;

import net.yassine.customerservice.entities.Customer;
import net.yassine.customerservice.repositories.CustomerRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController

@RequestMapping("Customers")
public class CustomerController {

    private CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/all")
    public List<Customer> AllCustomers(){

        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Customer GetCustomer(@PathVariable Long id){

        return customerRepo.findById(id).orElse(null);
    }










}
