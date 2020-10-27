package com.hexaware.MLP259.model;
import com.hexaware.MLP259.model.Customer;
import com.hexaware.MLP259.model.Orders;
import com.hexaware.MLP259.model.Menu;
import java.util.Objects;

public class Bill
{
 private int customerId;
 private int foodId;
 private String foodName;
 private String walletType;
 private double walletAmount;
 private int foodQty;
 private double foodPrice;

 public Bill(int CustomerId,int foodId,String foodName, String walletType,double walletAmount,
    int foodQty,double foodPrice) 
    {
        this.customerId = CustomerId;
        this.foodId = foodId;
        this.foodName=foodName;
        this.walletType = walletType;
        this.walletAmount = walletAmount;
        this.foodQty = foodQty;
        this.foodPrice = foodPrice;
        
    }
    public int getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(int CustomerId) 
    {
        this.customerId = CustomerId;
    }
    public int getFoodId()
    {
        return foodId;
    }
    public void setFoodName(String FoodName) 
    {
        this.foodName = FoodName;
    }
    public String getFoodName()
    {
        return foodName;
    }
    public void setFoodId(int FoodId) 
    {
        this.foodId = FoodId;
    }
    public String  getWalletType()
    {
        return walletType;
    }
    public void setWalletType(String walletType) 
    {
        this.walletType = walletType;
    }
    public double getWalletAmount()
    {
        return walletAmount;
    }
    public void setWalletAmount(double walletAmount) 
    {
        this.walletAmount = walletAmount;
    }
    public int getFoodQty()
    {
        return foodQty;
    }
    public void setFoodQty(int FoodQty) 
    {
        this.foodQty = foodQty;
    }
    public double getFoodPrice()
    {
        return foodPrice;
    }
    public void setFoodPrice(double FoodPrice) 
    {
        this.foodPrice = foodPrice;
    }
}
