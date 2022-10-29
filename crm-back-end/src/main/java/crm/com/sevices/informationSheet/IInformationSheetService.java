package crm.com.sevices.informationSheet;

import crm.com.dto.customer.CustomerDTO;
import crm.com.entities.customer.Customer;
import crm.com.entities.informationSheet.InformationSheet;

public interface IInformationSheetService {
    InformationSheet createNewFromDTO(CustomerDTO customerDTO, Customer customer);
    void delete(Integer id);
}
