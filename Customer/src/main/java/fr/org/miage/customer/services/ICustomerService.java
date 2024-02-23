package fr.org.miage.customer.services;

import fr.org.miage.customer.dtos.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();
    CustomerDTO findById(Long id);
}
