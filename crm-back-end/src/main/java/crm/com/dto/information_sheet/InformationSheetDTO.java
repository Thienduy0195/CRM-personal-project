package crm.com.dto.information_sheet;

import crm.com.entities.car.Car;
import crm.com.entities.customer.Customer;

public class InformationSheetDTO {

    private Integer id;
    private String createDate;
    private Car car;
    private String carColor;
    private String yearOfManufacture;
    private String content;
    private String customerStatus;
    private Customer customer;

    public InformationSheetDTO() {
    }

    public InformationSheetDTO(Integer id, String createDate, Car car,
                               String carColor, String yearOfManufacture,
                               String content, String customerStatus,
                               Customer customer) {
        this.id = id;
        this.createDate = createDate;
        this.car = car;
        this.carColor = carColor;
        this.yearOfManufacture = yearOfManufacture;
        this.content = content;
        this.customerStatus = customerStatus;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
