package net.yassine.accountservicee;

import net.yassine.accountservicee.clients.CustomerRestClients;
import net.yassine.accountservicee.entities.Account;
import net.yassine.accountservicee.entities.AccountType;
import net.yassine.accountservicee.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceeApplication.class, args);
    }

@Bean
    public CommandLineRunner run(AccountRepository accountRepository, CustomerRestClients restClients){

        return args -> {

            restClients.allCustomers().forEach(c->{

                Account compte=Account.builder()
                        .acountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .Sold(Math.random()*9000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .owener(Long.valueOf(c.getId()))
                        .build();
                Account compte1=Account.builder()
                        .acountId(UUID.randomUUID().toString())
                        .currency("SAD")
                        .Sold(Math.random())
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .owener(Long.valueOf(c.getId()))
                        .build();


                accountRepository.save(compte);
                accountRepository.save(compte1);


                    }



            );






        };


    }




}
