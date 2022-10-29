package crm.com.controllers;

import crm.com.entities.car.Car;
import crm.com.entities.car.Manufacture;
import crm.com.sevices.car.ICarService;
import crm.com.sevices.car.IManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;
    @Autowired
    private IManufactureService manufactureService;

    /**
     * Get manufacture list to choose when create or update customer
     * @return
     */
    @CrossOrigin()
    @GetMapping("/list")
    public ResponseEntity<List<Car>> getCarList() {
        List<Car> cars = this.carService.findAll();
        if (cars.isEmpty()) {
            return new ResponseEntity<>(cars, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @CrossOrigin()
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCustomerList(@PathVariable Integer id) {
        Car car = this.carService.findCarById(id);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }


    /**
     * Get manufacture list to choose when create or update customer
     * @return
     */
    @CrossOrigin()
    @GetMapping("/manufacture-list")
    public ResponseEntity<List<Manufacture>> getManufactureList() {
        List<Manufacture> manufactures = this.manufactureService.getManufactureList();
        if (manufactures.isEmpty()) {
            return new ResponseEntity<>(manufactures, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(manufactures, HttpStatus.OK);
    }

    @CrossOrigin()
    @GetMapping("/manufacture/{id}")
    public ResponseEntity<List<Car>> getCarListByManufactureId(@PathVariable Integer id) {
        List<Car> carList = this.carService.findByManufactureId(id);
        if (carList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }
}
