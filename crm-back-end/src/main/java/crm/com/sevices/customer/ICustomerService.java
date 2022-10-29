package crm.com.sevices.customer;

import crm.com.entities.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> getPageCustomer(Pageable pageable);

    List<Customer> getList(Pageable pageable);

    void saveCustomer(Customer customer);

    Customer findCustomerById(Integer id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);

    boolean checkEmail(String email);
}
