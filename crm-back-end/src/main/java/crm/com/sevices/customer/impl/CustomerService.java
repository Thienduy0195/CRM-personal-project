package crm.com.sevices.customer.impl;

import crm.com.entities.customer.Customer;
import crm.com.repositores.ICustomerRepository;
import crm.com.sevices.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getPageCustomer(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public List<Customer> getList(Pageable pageable) {
        return null;
    }


    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
        System.out.println("OKE");
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customerRepository.update(
                customer.getName(),
                customer.getGender(),
                customer.getAddress(),
                customer.getFirstPhoneNumber(),
                customer.getSecondPhoneNumber(),
                customer.getDateOfBirth(),
                customer.getEmail(),
                customer.getOccupation(),
                customer.getSalesMethod(),
                customer.getPaymentMethod(),
                customer.getInformationSource(),
                customer.getCreateDate(),
                customer.getUpdateDate(),
                customer.getCar().getId(),
                customer.getDistrict().getId(),
                customer.getId());
    }


    @Override
    public void deleteCustomerById(Integer id) {
        this.customerRepository.deleteCustomerById(id);
    }

    @Override
    public Optional<Customer> findCustomerByPhoneNumber(String phoneNumber) {
        return this.customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }


    @Override
    public boolean checkEmail(String email) {
        List<String> emailList = this.customerRepository.getEmailList();
        return emailList.contains(email);
    }


}
