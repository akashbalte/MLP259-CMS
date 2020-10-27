package com.hexaware.MLP259.model;
import java.util.Objects;
import java.sql.Timestamp;
public class Orders
{
    private int orderId;
    private int foodId;
    private int vendorId;
    private int customerId;
    private int noOfItems;
    private Timestamp orderDate;
    private double amount;
    private int tokenNo;
    private String status;
    private String comment;

    public Orders(int OrderId,int FoodId,int VendorId,int CustomerId, int NoOfItems,Timestamp OrderDate,
    double Amount,int TokenNo,String Status,String Comment) 
    {
        this.orderId = OrderId;
        this.foodId = FoodId;
        this.vendorId = VendorId;
        this.customerId = CustomerId;
        this.noOfItems = NoOfItems;
        this.orderDate = OrderDate;
        this.amount = Amount;
        this.tokenNo = TokenNo;
        this.status = Status;
        this.comment = Comment;
    }

    //getter and setter methods
    public int getOrderId()
    {
        return orderId;
    }
    public void setOrderId(int OrderId) 
    {
        this.orderId = OrderId;
    }
    public int getFoodId()
    {
        return foodId;
    }
    public void setFoodId(int FoodId) 
    {
        this.foodId = FoodId;
    }
    public int getVendorId()
    {
        return vendorId;
    }
    public void setVendorId(int VendorId) 
    {
        this.vendorId = VendorId;
    }
    public int getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(int CustomerId) 
    {
        this.customerId = CustomerId;
    }
    public int getNoOfItems()
    {
        return noOfItems;
    }
    public void setNoOfItems(int NoOfItems) 
    {
        this.noOfItems = NoOfItems;
    }
    public Timestamp getOrderDate()
    {
        return orderDate;
    }
    public void setOrderDate(Timestamp OrderDate) 
    {
        this.orderDate = OrderDate;
    }
    public double getAmount()
    {
        return amount;
    }
    public void setAmount(double Amount) 
    {
        this.amount = Amount;
    }
    public int getTokenNo()
    {
        return tokenNo;
    }
    public void setTokenNo(int TokenNo) 
    {
        this.tokenNo = TokenNo;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String Status) 
    {
        this.status = Status;
    }
    public String getComment()
    {
        return comment;
    }
    public void setComment(String Comment) 
    {
        this.comment = Comment;
    }
    
}