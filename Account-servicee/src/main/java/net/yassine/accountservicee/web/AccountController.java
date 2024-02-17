package net.yassine.accountservicee.web;

import net.yassine.accountservicee.clients.CustomerRestClients;
import net.yassine.accountservicee.entities.Account;
import net.yassine.accountservicee.modal.Customer;
import net.yassine.accountservicee.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountController {
    private AccountRepository accountRepository;

    private CustomerRestClients customerRestClients;


    public AccountController(AccountRepository accountRepository, CustomerRestClients customerRestClients) {
        this.accountRepository = accountRepository;
        this.customerRestClients = customerRestClients;
    }

    @GetMapping("/all")
    public List<Account> AllAccounts(){
        List<Account> allaccount=accountRepository.findAll();
        allaccount.forEach(account -> {
            account.setCustomer(customerRestClients.findCustomerById(account.getOwener()));
        });
        return allaccount;


    }

    @GetMapping("/{idaccount}")
    public Account getAccounts(@PathVariable String idaccount){
        Account compte=accountRepository.findById(idaccount).get();
        Customer customer=customerRestClients.findCustomerById(compte.getOwener());
        compte.setCustomer(customer);
        return compte;
    }



}
