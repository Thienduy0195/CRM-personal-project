package crm.com.repositores;

import crm.com.entities.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    /**
     * Created by: DuyNT
     * Created Date: 10/08/2022
     */
    @Query(value = "select * from customer where delete_status=0", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    @Modifying
    @Query(value = " UPDATE customer SET customer_name=:name, " +
            "gender=:gender, " +
            "address=:address," +
            "first_phone_number=:firstPhoneNumber, " +
            "second_phone_number=:secondPhoneNumber, " +
            "date_of_birth=:dateOfBirth, " +
            "email=:email, " +
            " occupation=:occupation, " +
            "sales_method=:salesMethod, " +
            "payment_method=:paymentMethod, " +
            "information_source=:informationSource" +
            ", create_date=:createDate," +
            "update_date=:updateDate," +
            "customer_status=:customerStatus," +
            "car_id=:carId," +
            "district_id=:districtId" +
            " WHERE id=:customerId", nativeQuery = true)
    void update(@Param("name") String name,
                @Param("gender") String gender,
                @Param("address") String address,
                @Param("firstPhoneNumber") String firstPhoneNumber,
                @Param("secondPhoneNumber") String secondPhoneNumber,
                @Param("dateOfBirth") String dateOfBirth,
                @Param("email") String email,
                @Param("occupation") String occupation,
                @Param("salesMethod") String salesMethod,
                @Param("paymentMethod") String paymentMethod,
                @Param("informationSource") String informationSource,
                @Param("createDate") String createDate,
                @Param("updateDate") String updateDate,
                @Param("carId") Integer carId,
                @Param("districtId") Integer districtId,
                @Param("customerId") Integer customerId);


    /**
     * Created by: DUYNT
     * Date Created: 19/10/2022
     */
    @Modifying
    @Query(value = "update customer set delete_status = 1 where id = :id ", nativeQuery = true)
    void deleteCustomerById(@Param("id") Integer id);

    /**
     * Created by: DuyNT
     * Created Date: 10/08/2022
     */
    @Query(value = "select * from customer where first_phone_number=:phoneNumber or second_phone_number=:phoneNumber", nativeQuery = true)
    Optional<Customer> findCustomerByPhoneNumber(@Param("phoneNumber") String phoneNumber);


    /**
     * Created by: DuyNT
     * Created Date: 10/08/2022
     */
    @Query(value = "select email from customer", nativeQuery = true)
    List<String> getEmailList();
}
