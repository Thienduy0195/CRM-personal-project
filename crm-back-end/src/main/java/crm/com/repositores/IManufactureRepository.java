package crm.com.repositores;

import crm.com.entities.car.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IManufactureRepository extends JpaRepository<Manufacture, Integer> {
}
