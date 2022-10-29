package crm.com.sevices.customer;

import crm.com.entities.customer.District;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IDistrictService {
    List<District> getDistrict();
}
