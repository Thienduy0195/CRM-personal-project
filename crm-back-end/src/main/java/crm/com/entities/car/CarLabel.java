package crm.com.entities.car;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class CarLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "car_label_name")
    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Manufacture manufacture;

    @OneToMany(mappedBy = "carLabel")
    @JsonBackReference
    private List<Car> cars;

    public CarLabel() {
    }

    public CarLabel(Integer id, String name, Manufacture manufacture) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
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

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
