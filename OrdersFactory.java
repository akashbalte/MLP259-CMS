package com.hexaware.MLP259.factory;

import com.hexaware.MLP259.persistence.MenuDAO;
import com.hexaware.MLP259.persistence.DbConnection;
import com.hexaware.MLP259.persistence.CustomerDAO;
import com.hexaware.MLP259.persistence.OrdersDAO;
import java.util.List;
import java.sql.Timestamp;
import com.hexaware.MLP259.model.Orders;
import com.hexaware.MLP259.model.Bill;

public class OrdersFactory {
    
   /* protected OrdersFactory(){

    }*/
    private static OrdersDAO dao(){
        DbConnection db=new DbConnection();
        return db.getConnect().onDemand(OrdersDAO.class);
    }
    public static int createOrder(int orderId,int foodId,int vendorId,int customerId,int noOfItems,Timestamp orderDateTime,double amountToBePaid,int tokenNumber,String status,String comment) {
    DbConnection db = new DbConnection();
    OrdersDAO dao = db.getConnect().onDemand(OrdersDAO.class);
    int orderresult = dao.createOrderItem(orderId,foodId,vendorId,customerId,noOfItems,orderDateTime,amountToBePaid,tokenNumber,status,comment);
    return orderresult;
  }
  public static Orders viewHistory(int customerId) {
    DbConnection db = new DbConnection();
    OrdersDAO dao = db.getConnect().onDemand(OrdersDAO.class);
    Orders orders = dao.viewHistory(customerId);
    return orders;
  }
  public static Bill[] showCarts() {
    List<Bill> bills= dao().showCarts();
    return bills.toArray(new Bill[bills.size()]);
  }

  public static void updateWalletAmt(double walletAmount,int customerId)
  {
    DbConnection db = new DbConnection();
    OrdersDAO dao = db.getConnect().onDemand(OrdersDAO.class);
    dao.updateWalletAmt(walletAmount,customerId);
  }
  public static Orders[] viewOrders() {
    List<Orders> orders = dao().show();
    return orders.toArray(new Orders[orders.size()]);
  }

}