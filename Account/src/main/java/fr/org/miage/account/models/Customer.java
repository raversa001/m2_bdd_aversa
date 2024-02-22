package fr.org.miage.account.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
