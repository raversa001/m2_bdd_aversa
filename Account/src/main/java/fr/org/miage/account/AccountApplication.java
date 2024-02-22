package fr.org.miage.account;

import fr.org.miage.account.entities.Account;
import fr.org.miage.account.enums.CurrencyType;
import fr.org.miage.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> {
			Account acc1 = Account
					.builder()
					.dateCreated(LocalDate.now())
					.balance(Math.random() * 34000)
					.currencyType(CurrencyType.EUR)
					.customerId(1L)
					.build();

			accountRepository.save(acc1);
		};
	}
}
