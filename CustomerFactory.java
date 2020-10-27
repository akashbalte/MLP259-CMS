package com.hexaware.MLP259.factory;

 

import com.hexaware.MLP259.persistence.CustomerDAO;
import com.hexaware.MLP259.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP259.model.Customer;
/**
 * CustomerFactory class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {}
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Customer[] viewAllCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }
  /**
   * get the menu item details
   * @return the menu Object
   */
    public static Customer viewCustomer(int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.findById(customerId);
    return customer;
  }
  /**
   * delete the menu item details
   */
  public static int deleteCustomer(int customerId){
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
   int result= dao.deleteCustomer(customerId);
   return result;
  }
  /**
   * create the menu item details
   */
  public static int addCustomer(int id,String name,String email,String address,long mobileno,String password,String wallet,double amt) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result = dao.addCustomer(id,name,email,address,mobileno,password,wallet,amt);
    return result;
  }
  /**
   * update the menu item details
   */
   public static void updateCustomer(Customer customer){
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    dao.updateCustomer(customer);
   }
   public static Customer viewProfile(int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.viewProfile(customerId);
    return customer;
  }
  public static void editCustomer(Customer customer){
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    dao.editCustomer(customer);
   }
   public static Customer viewWallet(int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.viewWallet(customerId);
    return customer;
  }
  

}