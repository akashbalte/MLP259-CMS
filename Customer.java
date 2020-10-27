package com.hexaware.MLP259.model;
import java.util.Objects;
public class Customer
{
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private long customerMobile;
    private String customerPassword;
    private String walletType;
    private double walletAmount;

    public Customer(int CustomerId,String CustomerName,String CustomerEmail,String CustomerAddress,
    long CustomerMobile,String CustomerPassword,String WalletType,double WalletAmount) 
    {
        this.customerId = CustomerId;
        this.customerName = CustomerName;
        this.customerEmail = CustomerEmail;
        this.customerAddress = CustomerAddress;
        this.customerMobile = CustomerMobile;
        this.customerPassword = CustomerPassword;
        this.walletType = WalletType;
        this.walletAmount = WalletAmount;
    }
    public Customer(int CustomerId,String CustomerName,String CustomerEmail,String CustomerAddress,
    long CustomerMobile,String CustomerPassword) 
    {
        this.customerId = CustomerId;
        this.customerName = CustomerName;
        this.customerEmail = CustomerEmail;
        this.customerAddress = CustomerAddress;
        this.customerMobile = CustomerMobile;
        this.customerPassword = CustomerPassword;
    }
    public Customer(String WalletType, double WalletAmount)
    {
        this.walletType = WalletType;
        this.walletAmount = WalletAmount;
    }

    //getter adn setter methods
    public int getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId(int CustomerId) 
    {
        this.customerId = CustomerId;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerName(String CustomerName) 
    {
        this.customerName = CustomerName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }
    public void setCustomerEmail(String CustomerEmail) 
    {
        this.customerEmail = CustomerEmail;
    }
    public String getCustomerAddress()
    {
        return customerAddress;
    }
    public void setCustomerAddress(String CustomerAddress) 
    {
        this.customerAddress = CustomerAddress;
    }
    public long getCustomerMobile()
    {
        return customerMobile;
    }
    public void setCustomerMobile(long CustomerMobile) 
    {
        this.customerMobile = CustomerMobile;
    }
    public String getCustomerPassword()
    {
        return customerPassword;
    }
    public void setCustomerPassword(String CustomerPassword) 
    {
        this.customerPassword = CustomerPassword;
    }
    public String getWalletType()
    {
        return walletType;
    }
    public void setWalletType(String WalletType) 
    {
        this.walletType = WalletType;
    }
    public double getWalletAmount()
    {
        return walletAmount;
    }
    public void setWalletAmount(double WalletAmount) 
    {
        this.walletAmount = WalletAmount;
    }
    
}