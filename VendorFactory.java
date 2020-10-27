package com.hexaware.MLP259.factory;

 

import com.hexaware.MLP259.persistence.VendorDAO;
import com.hexaware.MLP259.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP259.model.Vendor;
/**
 * VendorFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Vendor[] showMenu() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
   * get the vendor details
   * @return the vendor Object
   */
  public static Vendor showItem(int vendorId) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    Vendor vendor = dao.findById(vendorId);
    return vendor;
  }
  /**
   * delete the vendor details
   */
  public static int deleteVendor(int vendorId){
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
   int result= dao.deleteById(vendorId);
   return result;
  }
  /**
   * create the vendor details
   */
  public static int createVendor(int vendorId,String vendorName,String vendorEmail,long VendorMobile,String VendorAddress, String Password) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    int result = dao.createVendor(vendorId,vendorName,vendorEmail,VendorMobile,VendorAddress,Password);
    return result;
  }
  /**
   * update the vendor details
   */
   public static void updateVendor(Vendor vendor){
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    dao.updateVendor(vendor);
   }
}