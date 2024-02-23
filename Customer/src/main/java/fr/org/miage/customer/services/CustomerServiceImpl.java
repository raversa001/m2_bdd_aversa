package fr.org.miage.customer.services;

import fr.org.miage.customer.dtos.CustomerDTO;
import fr.org.miage.customer.entities.Customer;
import fr.org.miage.customer.mappers.CustomerMapper;
import fr.org.miage.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService{
    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer != null)
            return customerMapper.toDTO(customer);

        return null;
    }

    public List<CustomerDTO> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
