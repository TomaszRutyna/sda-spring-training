package pl.sda.sdaspringtraining.service.mapper;

import pl.sda.sdaspringtraining.api.model.Customer;
import pl.sda.sdaspringtraining.api.model.NewCustomer;
import pl.sda.sdaspringtraining.domain.CustomerEntity;

public class CustomerMapper {

    public CustomerEntity mapToEntity(NewCustomer newCustomer) {
        return new CustomerEntity(null, newCustomer.getFirstName(), newCustomer.getLastName(),
                newCustomer.getDriverLicense(), newCustomer.getAddress());
    }

    public Customer mapToApi(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getId(), customerEntity.getFirstName(), customerEntity.getLastName(),
                customerEntity.getDriverLicense(), customerEntity.getAddress());
    }
}
