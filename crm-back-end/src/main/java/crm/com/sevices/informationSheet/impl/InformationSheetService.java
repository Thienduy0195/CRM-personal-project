package crm.com.sevices.informationSheet.impl;

import crm.com.dto.customer.CustomerDTO;
import crm.com.entities.customer.Customer;
import crm.com.entities.informationSheet.InformationSheet;
import crm.com.repositores.IInformationSheetRepository;
import crm.com.sevices.informationSheet.IInformationSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationSheetService implements IInformationSheetService {

    @Autowired
    private IInformationSheetRepository informationSheetRepository;

    @Override
    public InformationSheet createNewFromDTO(CustomerDTO customerDTO, Customer customer) {
        InformationSheet informationSheet =
                new InformationSheet(null, customerDTO.getUpdateDate(),
                        customerDTO.getCar().getCarLabel().getManufacture().getName(),
                        customerDTO.getCar().getName(),
                        customerDTO.getCarColor(),
                        customerDTO.getYearOfManufacture(),
                        customerDTO.getContent(),
                        customerDTO.getCustomerStatus(),
                        0,
                        customer);
        this.informationSheetRepository.save(informationSheet);
        return informationSheet;
    }

    @Override
    public void delete(Integer id) {

    }
}
