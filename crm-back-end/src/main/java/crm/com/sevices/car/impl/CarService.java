package crm.com.sevices.car.impl;

import crm.com.entities.car.Car;
import crm.com.repositores.ICarRepository;
import crm.com.sevices.car.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findCarById(Integer id) {
        return this.carRepository.findById(id).get();
    }

    @Override
    public List<Car> findByManufactureId(Integer id) {
        List<Car> allCar = this.carRepository.findAll();
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < allCar.size(); i++) {
            if (allCar.get(i).getCarLabel().getManufacture().getId() == id) {
                cars.add(allCar.get(i));
            }
        }
        return cars;
    }


}
