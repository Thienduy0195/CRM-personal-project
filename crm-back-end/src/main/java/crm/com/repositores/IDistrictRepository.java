package crm.com.repositores;

import crm.com.entities.customer.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistrictRepository extends JpaRepository<District, Integer> {
}
