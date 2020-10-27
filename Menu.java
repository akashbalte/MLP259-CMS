package com.hexaware.MLP259.model;
import java.util.Objects;

 

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  private String foodName;
  private int quantity;
  private double foodPrice;
  /**
   * Default Constructor.
   */
  public Menu() {
  }


  public Menu(final int argfoodId) {
      this.foodId = argfoodId;
  }
/**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId,final String argFoodName,int argQuantity,double argFoodPrice) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.quantity = argQuantity;
    this.foodPrice = argFoodPrice;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }

 

  public final String getFoodName(){
    return foodName;
  }

 

  public void setFoodName(String argFoodName) {
    this.foodName = argFoodName;
  }

 

  public void setQuantity(int argQuantity) {
    this.quantity = argQuantity;
  }

 

  public int getQuantity() {
    return quantity;
  }

 

  public double getFoodPrice() {
    return foodPrice;
  }

 

  public void setFoodPrice(double argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }
}