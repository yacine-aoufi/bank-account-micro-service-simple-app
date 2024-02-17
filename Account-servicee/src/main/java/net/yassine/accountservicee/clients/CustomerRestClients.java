package net.yassine.accountservicee.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.Setter;
import net.yassine.accountservicee.modal.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClients {

    @GetMapping("/Customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "GetDeafault")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/Customers/all")
    @CircuitBreaker(name = "customerService",fallbackMethod = "GetDeafaultall")
    List<Customer> allCustomers();



    default Customer GetDeafault(Long id,Exception ex){
        Customer customer=new Customer(id,"defaultname","defaultlastname","deafaultemail");
        return  customer;
    }

    default List<Customer> GetDeafaultall(Exception exp){
        return  List.of();
    }

}
