package com.hexaware.MLP259.factory;

import com.hexaware.MLP259.persistence.MenuDAO;
import com.hexaware.MLP259.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP259.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {}
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
  /**
   * get the menu item details
   * @return the menu Object
   */
  public static Menu showItem(int foodId) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    Menu menu = dao.findById(foodId);
    return menu;
  }
  /**
   * delete the menu item details
   */
  public static int deleteItem(int foodId){
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
   int result= dao.deleteById(foodId);
   return result;
  }
  /**
   * create the menu item details
   */
  public static int createItem(int foodId,String foodName,int foodQty,double foodPrice) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result = dao.createMenuItem(foodId,foodName,foodQty,foodPrice);
    return result;
  }
  /**
   * update the menu item details
   */
   public static void updateMenuItem(Menu menu){
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    dao.update(menu);
   }

   public static void updateQuantity(int foodId,int foodQty)
  {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    dao.updateQty(foodId,foodQty);
  }
  
}