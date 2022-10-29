package crm.com.sevices.car;

import crm.com.entities.car.Car;

import java.util.List;

public interface ICarService {

    List<Car> findAll();
    Car findCarById(Integer id);
    List<Car> findByManufactureId(Integer id);

}
