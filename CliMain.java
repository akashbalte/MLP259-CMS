package com.hexaware.MLP259.util;
import java.util.Scanner;
import java.sql.Timestamp;
import com.hexaware.MLP259.factory.MenuFactory;
import com.hexaware.MLP259.model.Menu;
import com.hexaware.MLP259.factory.CustomerFactory;
import com.hexaware.MLP259.model.Customer;
import com.hexaware.MLP259.factory.OrdersFactory;
import com.hexaware.MLP259.model.Orders;
import com.hexaware.MLP259.model.Bill;


/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CliMain 
{
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-------------------------");
    System.out.println("1. Vendor                ");
    System.out.println("2. Customer              ");
    System.out.println("3. Exit                  ");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          vendorMainMenu();
          break;
        case 2:
           customerMainMenu();
          break;
        case 3:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose in between 1 and 3");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */

private void vendorMainMenu() {
  System.out.println("Vendor Main Menu         ");
  System.out.println("-----------------------  ");
  System.out.println("1. Menu Items            ");
  System.out.println("2. Orders                ");
  System.out.println("3. Customer              ");
  System.out.println("4. Back                  ");
  vendorMenuDetails();
}
  private void vendorMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int vendorOption = option.nextInt();
      switch (vendorOption) {
        case 1:
          menuItems();
          break;
        case 2:
        orders();
          break;
        case 3:
         customers();
          break;
        case 4: 
          mainMenu();
        default:
          System.out.println("Choose in between 1 and 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    vendorMainMenu();
  }
  private void menuItems() {
    System.out.println("    Menu Items           ");
    System.out.println("-------------------------");
    System.out.println("1. Show Menu             ");
    System.out.println("2. Get Menu Item Details ");
    System.out.println("3. Delete Menu Item      ");
    System.out.println("4. Create Menu Item      ");
    System.out.println("5. Update Menu Item      ");
    System.out.println("6. Back                  ");
    menuItemDetails();
  }
  
  private void menuItemDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuItemOption = option.nextInt();
      switch (menuItemOption) {
        case 1:
          showMenu();
          break;
        case 2:
           System.out.println("Enter Search Food Id?");
           showItem(option.nextInt());
          break; 
        case 3:
           System.out.println("Enter Deleting Food Id?");
           deleteMenuItem(option.nextInt());
           break;  
        case 4:
            System.out.println("Enter Food Id?");
            int id = option.nextInt();    
            System.out.println("Enter Food Name ?");
            String name = option.next();
            System.out.println("Enter Food qty ?");
            int qty = option.nextInt();
            System.out.println("Enter Food Price ?");
            double price = option.nextDouble();
            createMenuItem(id,name,qty,price);
            break;
        case 5:
             System.out.println("Enter Food Id?");
             int fid = option.nextInt();    
             System.out.println("Enter Food Name ?");
             String fname = option.next();
             System.out.println("Enter Food qty ?");
             int fqty = option.nextInt();
             System.out.println("Enter Food Price ?");
             double fprice = option.nextDouble();
             Menu menu = new Menu(fid,fname,fqty,fprice);
             updateMenuItem(menu);
             break;
        case 6:
          vendorMainMenu();
        default:
          System.out.println("Choose in between 1 and 6");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    menuItems();
  }
  private void orders() {
    System.out.println("         Orders                 ");
    System.out.println("--------------------------------");
    System.out.println("1. Accept or Decline Order      ");
    System.out.println("2. View Order                   ");
    System.out.println("3. Back                         ");
    vendorOrderDetails();
  }
  private void vendorOrderDetails() {
    try {
      System.out.println("Enter your choice:");
      int orderOption = option.nextInt();
      switch (orderOption) {
        case 1:
           acceptOrder();
            break;
        case 2:
          viewOrders();
          //System.out.println("View orders is in maintenance");
          break;
        case 3: 
          vendorMainMenu();
        default:
          System.out.println("Choose in between 1 and 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    orders();
  }

  public void acceptOrder(){
    System.out.println("Enter Your Customer Id");
    int cid =option.nextInt();
    System.out.println("Enter Food Id ?");
    int fid = option.nextInt();
    System.out.println("Enter Food Qty");
    int qty = option.nextInt();
    System.out.println("Enter the food name");
    String fname = option.next();
    Bill[] billItems = OrdersFactory.showCarts();
    double amount=0;
    for(Bill b:billItems)
  {
   amount = qty*b.getFoodPrice();
   System.out.println("Price = "+b.getFoodPrice());
   System.out.println("Food Quantity "+b.getFoodQty());
   if(b.getCustomerId()==cid && b.getWalletAmount()>=amount && b.getFoodQty()>=qty)
  {        
           System.out.println("-----------------------------------------");
           System.out.println("              Bill                       ");
           System.out.println("-----------------------------------------");
           System.out.println("     Food Id            :"+fid            );
           System.out.println("     Food Name          :"+fname          );   
           System.out.println("     Food Qty           :"+qty            );
           System.out.println("     Food Price         :"+b.getFoodPrice());
           System.out.println("-----------------------------------------");
           System.out.println("     Total Amount       :"+amount         );
           System.out.println("-----------------------------------------");
           int updateQty = b.getFoodQty()-qty;
           System.out.println("Updated Qty "+updateQty);
           //b.setFoodQty(b.getFoodQty()-qty);
           //System.out.println("Update Quantity "+b.getFoodQty());
           //b.setWalletAmount(b.getWalletAmount()-amount);
           //System.out.println("Update Wallet Amount : "+b.getWalletAmount());
           double walletAmt = b.getWalletAmount()-amount;
           System.out.println("wallet Amount "+walletAmt);
           OrdersFactory.updateWalletAmt(walletAmt,cid);
           MenuFactory.updateQuantity(fid,updateQty);
           break;
          
   }else{
       System.out.println("Your Order was declined...... Please check your wallet amount or Quantity......");
    }
    }
    System.out.println("Thank you. Visit Once again....");
  }
  public void viewOrders()
  {
      Orders[] orders = OrdersFactory.viewOrders();
      System.out.println("Order Id"+"\t"+"Food Id"+"\t"+"Vendor Id"+"\t"+"Customer Id"+"\t"+"Items No"+"\t"+"Order Date"+"\t\t\t"+
      "Remaining Amt"+"\t\t"+"Token No"+"\t"+"Status"+"\t\t"+"Comment");
      for (Orders o : orders) {
          System.out.println(o.getOrderId()+"\t\t"+o.getFoodId()+"\t\t"+o.getVendorId()+"\t"+o.getCustomerId()+"\t\t"+o.getNoOfItems()+"\t\t"+
          o.getOrderDate()+"\t\t"+o.getAmount()+"\t\t\t"+o.getTokenNo()+"\t\t"+o.getStatus()+"\t\t"+o.getComment());
        }
  }

  private void customers() {
    System.out.println("      Customers        ");
    System.out.println("-----------------------");
    System.out.println("1. Add Customer        ");
    System.out.println("2. View Customer       ");
    System.out.println("3. View all Customer   ");
    System.out.println("4. Update Customer     ");
    System.out.println("5. Delete Customer     ");
    System.out.println("6. Back                ");
    customerDetails();
  }
  
  private void customerDetails() {
    try {
      System.out.println("Enter your choice:");
      int customerOption = option.nextInt();
      switch (customerOption) {
        case 1:
          System.out.println("Enter Customer Id?");
          int id = option.nextInt();    
          System.out.println("Enter Customer Name ?");
          String name = option.next();
          System.out.println("Enter customer email ?");
          String email = option.next();
          System.out.println("Enter customer address?");
          String address = option.next();
          System.out.println("Enter customer mobile no?");
          long mobile_no = option.nextLong();
          System.out.println("Enter customer password?");
          String password = option.next();
          System.out.println("Enter customer wallet_type?");
          String wallet_type = option.next();
          System.out.println("Enter customer wallet_amt?");
          double wallet_amt = option.nextDouble();
          addCustomer(id,name,email,address,mobile_no,password,wallet_type,wallet_amt);
          break;
        case 2:
          System.out.println("Enter Search customer Id?");
          viewCustomer(option.nextInt()); 
          break; 
        case 3:
           viewAllCustomer();
           break;
        case 4:
          System.out.println("Enter Customer Id?");
          int cid = option.nextInt();    
          System.out.println("Enter Customer Name ?");
          String cname = option.next();
          System.out.println("Enter customer email ?");
          String cemail = option.next();
          System.out.println("Enter customer address?");
          String caddress = option.next();
          System.out.println("Enter customer mobile no?");
          long cmobile_no = option.nextLong();
          System.out.println("Enter customer password?");
          String cpassword = option.next();
          System.out.println("Enter customer wallet_type?");
          String cwallet_type = option.next();
          System.out.println("Enter customer wallet_amt?");
          double cwallet_amt = option.nextDouble();
          Customer customer=new Customer(cid,cname,cemail,caddress,cmobile_no,cpassword,cwallet_type,cwallet_amt);
          updateCustomer(customer);
          break; 
        case 5:
          System.out.println("Enter Deleting Food Id?");
          deleteCustomer(option.nextInt());
          break;
        case 6:
          vendorMainMenu();
        default:
          System.out.println("Choose in between 1 and 6");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    customers();
  }

  private void showMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("Menu_Id"+"\t\t"+"Food_Name"+"\t\t"+"QUANTITY"+"\t\t"+"PRICE");
    for (Menu m : menu) {
      System.out.println(m.getFoodId()+"\t\t"+m.getFoodName()+"\t\t\t"+m.getQuantity()+"\t\t\t"+m.getFoodPrice());
    }
  }

  public void showItem(int foodId) {
    Menu menu = MenuFactory.showItem(foodId);
    System.out.println("Menu_Id"+"\t\t"+"Food_Name"+"\t\t"+"QUANTITY"+"\t\t"+"PRICE");
    System.out.println(menu.getFoodId()+"\t\t"+menu.getFoodName()+"\t\t\t"+menu.getQuantity()+"\t\t\t"+menu.getFoodPrice());
   
  }
  public void deleteMenuItem(int foodId){
   int result= MenuFactory.deleteItem(foodId);
   if(result!=0){
    System.out.println("Successfully Menu Item deleted");
  }else{
    System.out.println("Notable to Delete Menu Item.Please try again...");
    }
  }
public void createMenuItem(int foodId,String foodName,int foodQty,double foodPrice){
  int result = MenuFactory.createItem(foodId, foodName, foodQty, foodPrice);
  if(result!=0){
    System.out.println("Successfully Menu Item created");
  }else{
    System.out.println("Notable to create menu item");
  }
}
public void updateMenuItem(Menu menu){
  MenuFactory.updateMenuItem(menu);
  System.out.println("Successfully update menu item");
}
private void addCustomer(int id,String name,String email,String address,long mobileno,String password,String wallet,double amt)
    {
        int result = CustomerFactory.addCustomer(id,name,email,address,mobileno,password,wallet,amt);
        if(result!=0){
        System.out.println("Successfully Created Customer Details");
        }else{
        System.out.println("Notable to create customer details");
        }
    }
    private void viewCustomer(int customerId)
    {
        Customer customer = CustomerFactory.viewCustomer(customerId);
        System.out.println("Id"+"\t\t"+"Name"+"\t\t"+"Email"+"\t\t\t\t"+"Address"+"\t\t\t"+"Mobileno"+"\t\t"+"Password"
        +"\t\t"+"WalletType"+"\t\t"+"Amount");
        System.out.println(customer.getCustomerId()+"\t\t"+customer.getCustomerName()+"\t\t"+customer.getCustomerEmail()+"\t\t\t"
        +customer.getCustomerAddress()+"\t\t"+customer.getCustomerMobile()+"\t\t"+customer.getCustomerPassword()+"\t\t\t"+customer.getWalletType()
        +"\t\t"+customer.getWalletAmount());
    }
  private void viewAllCustomer() {
    Customer[] customer = CustomerFactory.viewAllCustomer();
    System.out.println("Id"+"\t\t"+"Name"+"\t\t"+"Email"+"\t\t\t\t"+"Address"+"\t\t\t"+"Mobileno"+"\t\t"+"Password"
    +"\t\t"+"WalletType"+"\t\t"+"Amount");
    for (Customer c : customer) {
        System.out.println(c.getCustomerId()+"\t\t"+c.getCustomerName()+"\t\t"+c.getCustomerEmail()+"\t\t\t"
        +c.getCustomerAddress()+"\t\t"+c.getCustomerMobile()+"\t\t"+c.getCustomerPassword()+"\t\t\t"+c.getWalletType()+"\t\t"+c.getWalletAmount());
        }
    }
    public void updateCustomer(Customer customer)
    {
        CustomerFactory.updateCustomer(customer);
        System.out.println("Successfully update customer data");
    }
    public void deleteCustomer(int customerId)
    {
        int result= CustomerFactory.deleteCustomer(customerId);
        if(result!=0){
        System.out.println("Successfully Customer deleted");
        }else{
        System.out.println("Notable to Delete Customer.Please try again...");
        }
    }
/*--------------------------------------CUSTOMER MAIN MENU------------------------------------------*/

public void customerMainMenu() {
  System.out.println("-------------------------");
  System.out.println("    Customer Main Menu   ");
  System.out.println("-------------------------");
  System.out.println("1. Profile               ");
  System.out.println("2. Menu Items            ");
  System.out.println("3. Orders                ");
  System.out.println("4. Back                  ");
  System.out.println("-------------------------");
  customerMainMenuDetails();
}
public void customerMainMenuDetails() {
  try {
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
        profileMenu();
        break;
      case 2:
        customerMenuItems();
        break; 
      case 3:
        orderMenu();
        break;
      case 4:
       mainMenu();
      default:
        System.out.println("Choose either 1 or 6");
    }
  } catch (Exception e) {
    e.printStackTrace();
    System.out.println("enter a valid value");
  }
  option.nextLine();
  customerMainMenu();
}
public void profileMenu(){
  System.out.println("-----------------------------");
  System.out.println("    Customer Profile  Menu   ");
  System.out.println("-----------------------------");
  System.out.println("1. View Profile              ");
  System.out.println("2. Edit Profile              ");
  System.out.println("3. Wallet                    ");
  System.out.println("4. Back                      ");
  System.out.println("-----------------------------");
  profileMenuDetails();
}
public void profileMenuDetails()
{
  try {
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    switch (menuOption) {
      case 1:
          System.out.println("Enter Search customer Id?");
          viewProfile(option.nextInt()); 
          break;
      case 2:
          System.out.println("Enter Customer Id?");
          int cid = option.nextInt();    
          System.out.println("Enter Customer Name ?");
          String cname = option.next();
          System.out.println("Enter customer email ?");
          String cemail = option.next();
          System.out.println("Enter customer address?");
          String caddress = option.next();
          System.out.println("Enter customer mobile no?");
          long cmobile_no = option.nextLong();
          System.out.println("Enter customer password?");
          String cpassword = option.next();
          Customer customer=new Customer(cid,cname,cemail,caddress,cmobile_no,cpassword);
          editCustomer(customer);
          break; 
      case 3:
          System.out.println("Enter Customer Id?");
          viewWallet(option.nextInt()); 
          break;
      case 4:
          customerMainMenu();
      default:
        System.out.println("Choose in between 1 and 4");
    }
  } catch (Exception e) {
    e.printStackTrace();
    System.out.println("enter a valid value");
  }
  option.nextLine();
  profileMenu();
}
    private void viewProfile(int customerId)
    {
        Customer customer = CustomerFactory.viewProfile(customerId);
        System.out.println("Id"+"\t\t"+"Name"+"\t\t"+"Email"+"\t\t\t"+"Address"+"\t\t\t"+"Mobileno"+"\t\t"+"Password");
        System.out.println(customer.getCustomerId()+"\t\t"+customer.getCustomerName()+"\t\t"+customer.getCustomerEmail()+"\t\t"
        +customer.getCustomerAddress()+"\t\t"+customer.getCustomerMobile()+"\t\t"+customer.getCustomerPassword());
    }
    public void editCustomer(Customer customer)
    {
        CustomerFactory.editCustomer(customer);
        System.out.println("Customer data edited successfully");
    }
    private void viewWallet(int customerId)
    {
        Customer customer = CustomerFactory.viewWallet(customerId);
        System.out.println("Customer_Id"+"\t"+"Wallet_Type"+"\t\t"+"Wallet_Amount");
        System.out.println(customer.getCustomerId()+"\t\t"+customer.getWalletType()+"\t\t"+customer.getWalletAmount());
    }


    public void customerMenuItems(){
      System.out.println("-----------------------------");
      System.out.println("    Customer Menu Items      ");
      System.out.println("-----------------------------");
      System.out.println("1. View Food Items           ");
      System.out.println("2. View All Food Items       ");
      System.out.println("3. Back                      ");
      System.out.println("-----------------------------");
      customermenuItemsDetails();
    }
    public void customermenuItemsDetails(){
      try {
        System.out.println("Enter your choice:");
        int menuOption = option.nextInt();
        switch (menuOption) {
          case 1:
            System.out.println("Enter Search Food Id?");
            showItem(option.nextInt());
            break;
          case 2:
            showMenu();
            break;
          case 3:
           customerMainMenu();
          default:
            System.out.println("Choose in between 1 and 3");
        }
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("enter a valid value");
      }
      option.nextLine();
      customerMenuItems();
    }
    public void orderMenu(){
      System.out.println("-----------------------------");
      System.out.println("    Customer Orders Menu     ");
      System.out.println("-----------------------------");
      System.out.println("1. History                   ");
      System.out.println("2. Place Order               ");
      System.out.println("3. Back                      ");
      System.out.println("-----------------------------");
      ordersDetails();
    }
  public void ordersDetails(){
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          System.out.println("Enter Customer Id");
          viewHistory(option.nextInt());
          break;
        case 2:
          System.out.println("Enter order id");
          int orid=option.nextInt();
          System.out.println("Enter food id");
          int orfid=option.nextInt();
          System.out.println("Enter vendor id");
          int orvid=option.nextInt();
          System.out.println("Enter customer id");
          int orcid=option.nextInt();
         System.out.println("Enter no of items");
          int nitems=option.nextInt();
          //System.out.println("Enter order date time");
          //Date ordt=option.next();
          java.util.Date today=new java.util.Date();
          Timestamp orderdate=new Timestamp(today.getTime());
          //java.sql.Date orderdate=new java.sql.Date(orderdate.getTime());
          System.out.println("Enter amount to be paid");
          double amtpaid=option.nextDouble();
          System.out.println("Enter token number");
          int otoken=option.nextInt();
          System.out.println("Enter status");
          String ostatus=option.next();
          System.out.println("Enter comment");
          String ocomment=option.next();
          createOrderItem(orid,orfid,orvid,orcid,nitems,orderdate,amtpaid,otoken,ostatus,ocomment);
          break; 
        case 3:
         customerMainMenu();
        default:
          System.out.println("Choose either 1 or 3");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    orderMenu();
  }

  public void viewHistory(int customerId)
  {
    Orders orders = OrdersFactory.viewHistory(customerId);
    System.out.println("Order Id"+"\t"+"Food Id"+"\t"+"Vendor Id"+"\t"+"Customer Id"+"\t"+"Items No"+"\t"+"Order Date"+"\t\t\t"+
      "Remaining Amt"+"\t\t"+"Token No"+"\t"+"Status"+"\t\t"+"Comment");
    System.out.println(orders.getOrderId()+"\t\t"+orders.getFoodId()+"\t\t"+orders.getVendorId()+"\t"+orders.getCustomerId()+"\t\t"+orders.getNoOfItems()+
    "\t\t"+orders.getOrderDate()+"\t\t"+orders.getAmount()+"\t\t\t"+orders.getTokenNo()+"\t\t"+orders.getStatus()+"\t\t"+orders.getComment());

  }

  public void createOrderItem(int orderId,int foodId,int vendorId,int customerId,int noOfItems,Timestamp orderDateTime,double amountToBePaid,int tokenNumber,String status,String comment)
  {
      int orderresult = OrdersFactory.createOrder(orderId,foodId,vendorId,customerId,noOfItems,orderDateTime,amountToBePaid,tokenNumber,status,comment);
      if(orderresult!=0){
        System.out.println("Successfully order created");
        }
      else{
        System.out.println("Notable to create menu item");
      }
   }


/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
