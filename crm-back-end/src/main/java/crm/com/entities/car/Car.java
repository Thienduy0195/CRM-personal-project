package crm.com.entities.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import crm.com.entities.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "amount")
    private String amount;

    @Column(name = "year_of_manufacture")
    private String yearOfManufacture;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private CarLabel carLabel;

    @OneToMany(mappedBy = "car")
    @JsonBackReference
    private List<Customer> customers;

    public Car() {
    }

    public Car(Integer id, String name,
               String price, String amount,
               String yearOfManufacture,
               CarLabel carLabel) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.yearOfManufacture = yearOfManufacture;
        this.carLabel = carLabel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public CarLabel getCarLabel() {
        return carLabel;
    }

    public void setCarLabel(CarLabel carLabel) {
        this.carLabel = carLabel;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
