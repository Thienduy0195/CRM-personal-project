package crm.com.sevices.customer.impl;

import crm.com.entities.customer.District;
import crm.com.repositores.IDistrictRepository;
import crm.com.sevices.customer.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService implements IDistrictService {
    @Autowired
    private IDistrictRepository districtRepository;

    @Override
    public List<District> getDistrict() {
        return this.districtRepository.findAll();
    }
}
