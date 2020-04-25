package pl.sda.sdaspringtraining.service;

import org.springframework.stereotype.Service;
import pl.sda.sdaspringtraining.api.model.Customer;
import pl.sda.sdaspringtraining.api.model.NewCustomer;
import pl.sda.sdaspringtraining.api.model.UpdateCustomer;
import pl.sda.sdaspringtraining.domain.CustomerEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private static Integer customerId = 0;
    private static List<CustomerEntity> customers = new ArrayList<>();

    public void createCustomer(NewCustomer newCustomer) {
        customers.add(new CustomerEntity(customerId++, newCustomer.getFirstName(), newCustomer.getLastName(),
                newCustomer.getDriverLicense(), newCustomer.getAddress()));
    }

    public void updateCustomer(UpdateCustomer updateCustomer) {
        for (CustomerEntity entity: customers) {
            if (entity.getId() == updateCustomer.getId()) {
                entity.setAddress(updateCustomer.getNewAddress());
            }
        }
    }

    public Optional<Customer> getById(Integer id) {
        return customers.stream().filter(cus -> cus.getId() == id)
                .findFirst()
                .map(ent -> new Customer(ent.getId(), ent.getFirstName(), ent.getLastName(),
                        ent.getDriverLicense(), ent.getAddress()));
    }

    public List<Customer> getAll() {
        return customers.stream()
                .map(ent -> new Customer(ent.getId(), ent.getFirstName(), ent.getLastName(), ent.getDriverLicense(), ent.getAddress()))
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        Iterator<CustomerEntity> customerIterator = customers.iterator();
        while (customerIterator.hasNext()) {
            CustomerEntity next = customerIterator.next();
            if (next.getId() == id) {
                customerIterator.remove();
                return;
            }
        }
    }
}
