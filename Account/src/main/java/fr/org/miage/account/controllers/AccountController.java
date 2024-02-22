package fr.org.miage.account.controllers;

import fr.org.miage.account.entities.Account;
import fr.org.miage.account.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElse(null);
    }
}
