package crm.com.repositores;

import crm.com.entities.car.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICarRepository extends JpaRepository<Car, Integer> {

    /**
     * Create by: DuyNT
     * Query: findAll car by manufactureId
     */
    @Query(value = "select * from car as c" +
            "join car_label as cl on c.car_label_id = cl.id where cl.id in (select cl.id from car_label as cl" +
            "join manufacture as m on cl.manufacture_id = m.id where m.id = 1)"
            , nativeQuery = true)
    Page<Car> findAll(@Param("name") String name, Pageable pageable);

}
