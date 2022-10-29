package crm.com.controllers;

import crm.com.entities.customer.Customer;
import crm.com.entities.customer.District;
import crm.com.sevices.customer.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IDistrictService districtService;

    @CrossOrigin()
    @GetMapping("/district-list")
    public ResponseEntity<?> getDistrictList(Pageable pageable) {
        List<District> districtList = this.districtService.getDistrict();
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }
}
