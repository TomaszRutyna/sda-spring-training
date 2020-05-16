package pl.sda.sdaspringtraining.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.sdaspringtraining.NotFoundException;
import pl.sda.sdaspringtraining.api.model.Customer;
import pl.sda.sdaspringtraining.api.model.NewCustomer;
import pl.sda.sdaspringtraining.api.model.UpdateCar;
import pl.sda.sdaspringtraining.api.model.UpdateCustomer;
import pl.sda.sdaspringtraining.domain.CustomerEntity;
import pl.sda.sdaspringtraining.domain.CustomerRepository;
import pl.sda.sdaspringtraining.service.mapper.CustomerMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public void createCustomer(NewCustomer newCustomer) {
        customerRepository.save(customerMapper.mapToEntity(newCustomer));
    }

    public void updateCustomer(UpdateCustomer updateCustomer) {
        CustomerEntity customerToUpdate = customerRepository.findById(updateCustomer.getId())
                .orElseThrow(() -> new NotFoundException("Customer with id " + updateCustomer.getId() + " not exist"));
        customerToUpdate.setAddress(updateCustomer.getNewAddress());

        customerRepository.save(customerToUpdate);
    }

    public Optional<Customer> getById(Integer id) {
        return customerRepository.findById(id)
                .map(ent -> customerMapper.mapToApi(ent));
    }

    public List<Customer> getAll() {
        return customerRepository.findAll().stream()
                .map(ent -> customerMapper.mapToApi(ent))
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
