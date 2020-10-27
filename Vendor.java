package com.hexaware.MLP259.model;
import java.util.Objects;
public class Vendor
{
    private int vendorId;
    private String vendorName;
    private String vendorEmail;
    private long vendorMobile;
    private String vendorAddress;
    private String password;

    public Vendor(int VendorId,String VendorName,String VendorEmail,long VendorMobile,String VendorAddress,String Password) 
    {
        this.vendorId = VendorId;
        this.vendorName = VendorName;
        this.vendorEmail = VendorEmail;
        this.vendorMobile = VendorMobile;
        this.vendorAddress = VendorAddress;
        this.password = Password;
    }

    //getter and setter methods
    public int getVendorId()
    {
        return vendorId;
    }
    public void setVendorId(int VendorId) 
    {
        this.vendorId = VendorId;
    }
    public String getVendorName()
    {
        return vendorName;
    }
    public void setVendorName(String VendorName) 
    {
        this.vendorName = VendorName;
    }
    public String getVendorEmail()
    {
        return vendorEmail;
    }
    public void setVendorEmail(String VendorEmail) 
    {
        this.vendorEmail = VendorEmail;
    }
    public long getVendorMobile()
    {
        return vendorMobile;
    }
    public void setVendorMobile(long VendorMobile) 
    {
        this.vendorMobile = VendorMobile;
    }
    public String getVendorAddress()
    {
        return vendorAddress;
    }
    public void setVendorAddress(String VendorAddress) 
    {
        this.vendorAddress = VendorAddress;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String Password) 
    {
        this.password = Password;
    }
    
}