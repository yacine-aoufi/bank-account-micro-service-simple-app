package net.yassine.customerservice;

import com.thoughtworks.xstream.mapper.Mapper;
import net.yassine.customerservice.entities.Customer;
import net.yassine.customerservice.repositories.CustomerRepo;
import org.apache.http.util.Args;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    public CommandLineRunner run (CustomerRepo customerRepo){

        return args -> {
            Customer customer=Customer.builder()
                    .FirstName("yacine")
                    .LastName("aoufi")
                    .Email("email@gmsil.com")
                    .build();
            customerRepo.save(customer);

            Customer customer1=Customer.builder()
                    .FirstName("saamir")
                    .LastName("aoufi")
                    .Email("samir@gmsil.com")
                    .build();
            customerRepo.save(customer1);

        };

    }

}
