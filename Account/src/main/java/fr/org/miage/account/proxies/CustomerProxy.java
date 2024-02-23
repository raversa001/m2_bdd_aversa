package fr.org.miage.account.proxies;

import fr.org.miage.account.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer", url = "http://localhost:8091/")
public interface CustomerProxy {
    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customer", fallbackMethod = "getDefaultCustomer")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customer", fallbackMethod = "getAllCustomers")
    public List<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        return new Customer(id, "Not available", "Not available", "Not available");
    }

    default List<Customer> getAllCustomers(Exception exception) {
        return List.of();
    }
}
