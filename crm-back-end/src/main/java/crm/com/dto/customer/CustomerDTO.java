package crm.com.dto.customer;

import crm.com.entities.car.Car;
import crm.com.entities.customer.District;
import crm.com.entities.user.AppUser;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

public class CustomerDTO {
    private Integer id;
    @Pattern(regexp = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêêềễìíứừựớờợòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s?]+$",
            message = "Sai định dạng.")
    private String name;
    private String gender;
    private String address;
    @Valid
    private String firstPhoneNumber;
    @Valid
    private String secondPhoneNumber;
    private String dateOfBirth;
    private String email;
    private String occupation;
    private String salesMethod;
    private String paymentMethod;
    private String informationSource;
    private String createDate;
    private String updateDate;
    private Integer deleteStatus = 0;
    private String customerStatus;
    private Car car;
    private District district;
    private AppUser user;
    private String carColor;
    private String yearOfManufacture;
    private String content;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, String gender, String address,
                       String firstPhoneNumber, String secondPhoneNumber,
                       String dateOfBirth, String email, String occupation,
                       String salesMethod, String paymentMethod,
                       String informationSource, String createDate,
                       String updateDate, Integer deleteStatus,
                       String customerStatus, Car car,
                       District district, AppUser user,
                       String carColor,
                       String yearOfManufacture,
                       String content) {
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
        this.carColor = carColor;
        this.yearOfManufacture = yearOfManufacture;
        this.content = content;
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
}
