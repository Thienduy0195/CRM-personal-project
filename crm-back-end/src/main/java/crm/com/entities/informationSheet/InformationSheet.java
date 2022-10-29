package crm.com.entities.informationSheet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import crm.com.entities.customer.Customer;

import javax.persistence.*;

@Entity
public class InformationSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "manufacture_name")
    private String manufactureName;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "year_of_manufacture")
    private String yearOfManufacture;

    @Column(name = "content", columnDefinition = "longtext")
    private String content;

    @Column(name = "customer_status")
    private String customerStatus;

    @Column(name = "active_status")
    private Integer activeStatus;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    public InformationSheet() {
    }

    public InformationSheet(Integer id, String createDate,
                            String manufactureName,
                            String carName, String carColor,
                            String yearOfManufacture,
                            String content, String customerStatus,
                            Integer activeStatus, Customer customer) {
        this.id = id;
        this.createDate = createDate;
        this.manufactureName = manufactureName;
        this.carName = carName;
        this.carColor = carColor;
        this.yearOfManufacture = yearOfManufacture;
        this.content = content;
        this.customerStatus = customerStatus;
        this.activeStatus = activeStatus;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
