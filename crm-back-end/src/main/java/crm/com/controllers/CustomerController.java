package crm.com.controllers;

import crm.com.dto.customer.CustomerDTO;
import crm.com.entities.customer.Customer;
import crm.com.entities.informationSheet.InformationSheet;
import crm.com.entities.user.AppUser;
import crm.com.sevices.car.ICarService;
import crm.com.sevices.customer.ICustomerService;
import crm.com.sevices.informationSheet.IInformationSheetService;
import crm.com.sevices.user.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICarService carService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IInformationSheetService iInformationSheetService;

    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<?> getAllCustomers(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("update_date").ascending();
        Page<Customer> customers = this.customerService.getPageCustomer(PageRequest.of(page, 5, sort));
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

//    @CrossOrigin()
//    @GetMapping("/list")
//    public ResponseEntity<?> getCustomerList(Pageable pageable) {
//        Page<Customer> customers = this.customerService.getPageCustomer(pageable);
//        if (!customers.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

    @PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> errorList = new LinkedHashMap<>();
            for (FieldError item : errors) {
                String field = item.getField();
                String msg = item.getDefaultMessage();
                errorList.put(field, msg);
            }
            return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
        }
        AppUser user = this.userService.findUserByUserName("tinbd");
        Customer customer = this.modelMapper.map(customerDTO, Customer.class);
        customer.setUser(user);
        customerService.saveCustomer(customer);
        InformationSheet informationSheet = this.iInformationSheetService.createNewFromDTO(customerDTO, customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin()
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = this.customerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<?> checkExistPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Customer> customers = this.customerService.findCustomerByPhoneNumber(phoneNumber);
        if (!customers.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers.get(), HttpStatus.OK);
    }

    @CrossOrigin()
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody @Valid CustomerDTO
            customerDTO, BindingResult bindingResult) {
        System.out.println(customerDTO.toString());
        System.out.println("THIENDUY99");
        if (bindingResult.hasErrors()) {
            System.out.println("HREEEEEEEEEEEEEEEE");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customerEdit = customerService.findCustomerById(id);
        if (customerEdit.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerEdit = modelMapper.map(customerDTO, Customer.class);
        customerService.updateCustomer(customerEdit);
        InformationSheet informationSheet = this.iInformationSheetService.createNewFromDTO(customerDTO, customerEdit);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);

    }

    @DeleteMapping("/deleteCustomerBy")
    public ResponseEntity<?> deleteCustomer(@RequestParam("id") Integer id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin()
    @GetMapping("/check")
    public ResponseEntity<?> getCustomerById() {
        System.out.println(customerService.checkEmail("thienduy0195@gmail.com"));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
