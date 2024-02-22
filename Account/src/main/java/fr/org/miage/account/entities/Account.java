package fr.org.miage.account.entities;

import fr.org.miage.account.enums.CurrencyType;
import fr.org.miage.account.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double balance;
    private LocalDate dateCreated;
    private CurrencyType currencyType;
    private Long customerId;
    @Transient
    private Customer customer;
}
