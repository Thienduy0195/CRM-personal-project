package crm.com.sevices.car.impl;

import crm.com.entities.car.Manufacture;
import crm.com.repositores.IManufactureRepository;
import crm.com.sevices.car.IManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufactureService implements IManufactureService {
    @Autowired
    private IManufactureRepository manufactureRepository;
    @Override
    public List<Manufacture> getManufactureList() {
        return this.manufactureRepository.findAll();
    }
}
