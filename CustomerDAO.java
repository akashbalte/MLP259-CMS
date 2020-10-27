package com.hexaware.MLP259.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP259.model.Customer;

 

/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Customer")
    @Mapper(CustomerMapper.class)
    List<Customer> show();

   /**
   * Find a Menu by ID.
   * @param id Menu ID.
   * @return A Menu.
   */
  @SqlQuery("Select * from mlp259.customer where customer_id = :id")
  @Mapper(CustomerMapper.class)
  Customer findById(@Bind("id") int customerId);
    /**
   * Delete a Menu by ID.
   * @param id Menu ID.
   * @return A Menu.
   */
  @SqlUpdate("delete from mlp259.customer where customer_id = :cid")
  @Mapper(CustomerMapper.class)
  int deleteCustomer(@Bind("cid") int customerId);

  /**
   * create a Menu Item.
   * @param id Menu ID.
   * @param name Menu NAME.
   * @param qty Menu QUANTITY.
   * @param price Menu PRICE.
   * @return A Menu.
   */
  @SqlUpdate("insert into mlp259.customer(customer_id,customer_name,customer_email,customer_address,customer_mobileno,customer_password,wallet_type,wallet_amt) values (:id, :name, :email, :address, :mobile, :password, :wallet, :amt)")
    @Mapper(MenuMapper.class)
  int addCustomer(@Bind("id") int customerId, @Bind("name") String customerName, @Bind("email") String customerEmail, @Bind("address") String customerAddress, @Bind("mobile") long customerMobile, @Bind("password") String customerPassword, @Bind("wallet") String walletType, @Bind("amt") double walletAmount);

  /**
   * update a Menu Item
   * @param id Menu ID.
   */
  @SqlUpdate("update Customer set customer_name=:customer.customerName,customer_email=:customer.customerEmail,customer_address=:customer.customerAddress,customer_mobileno=:customer.customerMobile,customer_password=:customer.customerPassword,wallet_type=:customer.walletType,wallet_amt=:customer.walletAmount where customer_id=:customer.customerId")
   void updateCustomer(@BindBean("customer") Customer customer);

   @SqlQuery("Select * from mlp259.customer where customer_id = :id")
  @Mapper(CustomerMapper.class)
  Customer viewProfile(@Bind("id") int customerId);

  @SqlUpdate("update Customer set customer_name=:customer.customerName,customer_email=:customer.customerEmail,customer_address=:customer.customerAddress,customer_mobileno=:customer.customerMobile,customer_password=:customer.customerPassword where customer_id=:customer.customerId")
   void editCustomer(@BindBean("customer") Customer customer);

   @SqlQuery("Select * from mlp259.customer where customer_id = :id")
  @Mapper(CustomerMapper.class)
  Customer viewWallet(@Bind("id") int customerId);

  
}
