package crm.com.entities.car;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "manufacture_name")
    private String name;

    @OneToMany(mappedBy = "manufacture")
    @JsonBackReference
    private List<CarLabel> carLabels;

    public Manufacture() {
    }

    public Manufacture(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<CarLabel> getCarLabels() {
        return carLabels;
    }

    public void setCarLabels(List<CarLabel> carLabels) {
        this.carLabels = carLabels;
    }
}
