package fr.org.miage.account.controllers;

import fr.org.miage.account.entities.Account;
import fr.org.miage.account.models.Customer;
import fr.org.miage.account.proxies.CustomerProxy;
import fr.org.miage.account.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    AccountRepository accountRepository;
    CustomerProxy customerProxy;

    public AccountController(AccountRepository accountRepository, CustomerProxy customerProxy) {
        this.accountRepository = accountRepository;
        this.customerProxy = customerProxy;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();

        accountList.forEach(account -> {
            Customer customer = customerProxy.getCustomerById(account.getCustomerId());
            account.setCustomer(customer);
        });

        return accountList;
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElse(null);
    }
}
