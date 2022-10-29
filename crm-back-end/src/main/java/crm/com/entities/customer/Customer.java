package crm.com.entities.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import crm.com.entities.car.Car;
import crm.com.entities.informationSheet.InformationSheet;
import crm.com.entities.user.AppUser;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "first_phone_number")
    private String firstPhoneNumber;

    @Column(name = "second_phone_number")
    private String secondPhoneNumber;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "sales_method")
    private String salesMethod;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "information_source")
    private String informationSource;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "delete_status", columnDefinition = "int")
    @ColumnDefault("0")
    private Integer deleteStatus;

    @Column(name = "customer_status")
    private String customerStatus;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private District district;

    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "user_name")
    private AppUser user;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<InformationSheet> informationSheets;

    public Customer() {
    }

    public Customer(Integer id, String name, String gender, String address, String firstPhoneNumber, String secondPhoneNumber, String dateOfBirth, String email, String occupation, String salesMethod, String paymentMethod, String informationSource, String createDate, String updateDate, Integer deleteStatus, String customerStatus, Car car, District district, AppUser user) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.firstPhoneNumber = firstPhoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.occupation = occupation;
        this.salesMethod = salesMethod;
        this.paymentMethod = paymentMethod;
        this.informationSource = informationSource;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteStatus = deleteStatus;
        this.customerStatus = customerStatus;
        this.car = car;
        this.district = district;
        this.user = user;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstPhoneNumber() {
        return firstPhoneNumber;
    }

    public void setFirstPhoneNumber(String firstPhoneNumber) {
        this.firstPhoneNumber = firstPhoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSalesMethod() {
        return salesMethod;
    }

    public void setSalesMethod(String salesMethod) {
        this.salesMethod = salesMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getInformationSource() {
        return informationSource;
    }

    public void setInformationSource(String informationSource) {
        this.informationSource = informationSource;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public List<InformationSheet> getInformationSheets() {
        return informationSheets;
    }

    public void setInformationSheets(List<InformationSheet> informationSheets) {
        this.informationSheets = informationSheets;
    }
}