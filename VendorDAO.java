package com.hexaware.MLP259.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP259.model.Vendor;

 

/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();

 

   /**
   * Find a Vendor by ID.
   * @param id Vendor ID.
   * @return A Vendor.
   */
  @SqlQuery("Select * from mlp259.vendor where vendor_id = :id")
  @Mapper(VendorMapper.class)
  Vendor findById(@Bind("id") int vendorId);

 

    /**
   * Delete a VendorDetail by ID.
   * @param id Vendor ID.
   * @return A Vendor.
   */
  @SqlUpdate("delete from mlp259.vendor where vendor_id = :vid")
  @Mapper(MenuMapper.class)
  int deleteById(@Bind("vid") int vendorId);

  /**
   * create a Vendor Item.
   * @param id Vendor ID.
   * @param name Vendor NAME.
   * @param email Vendor EMAIL.
   * @param mobile Vendor MOBILE.
   * @param address Vendor ADDRESS.
   * @param password Vendor PASSWORD.
   * @return A Vendor.
   */
  @SqlUpdate("insert into mlp259.vendor(vendor_id, vendor_name, vendor_email, vendor_mobile, vendor_address, password) values (:id, :name, :email, :mobile, :address, :password)")
    @Mapper(VendorMapper.class)
  int createVendor(@Bind("id") int id, @Bind("name") String name, @Bind("email") String email, @Bind("phoneno") long mobile, @Bind("address") String address, @Bind("password") String password);

 
  /**
   * update a Vendor Details
   * @param id Vendor ID.
   */
  @SqlUpdate("update Vendor set vendor_name=:vendor.vendorName,vendor_email=:vendor.vendorEmail,vendor_mobile=:vendor.vendorMobile,vendor_address=:vendor.VendorAddress,password=:vendor.Password, where vendor_id=:menu.vendorId")
   void updateVendor(@BindBean("vendor") Vendor vendor);
}
