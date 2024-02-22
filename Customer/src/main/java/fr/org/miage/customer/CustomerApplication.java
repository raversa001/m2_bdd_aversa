package fr.org.miage.customer;

import fr.org.miage.customer.entities.Customer;
import fr.org.miage.customer.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer yanisInstance = Customer
                    .builder()
                    .firstName("Yannis")
                    .lastName("Allouche")
                    .email("yannis.allouche@etu.unice.fr")
                    .build();

            customerRepository.save(yanisInstance);

            Customer loicInstance = Customer
                    .builder()
                    .firstName("Loic")
                    .lastName("Amann")
                    .email("loic.amann@etu.unice.fr")
                    .build();

            customerRepository.save(loicInstance);
        };
    }
}
