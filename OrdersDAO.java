package com.hexaware.MLP259.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;
//import java.util.Date;
import java.sql.Timestamp;
import com.hexaware.MLP259.model.Menu;
import com.hexaware.MLP259.model.Bill;
import com.hexaware.MLP259.model.Customer;
import com.hexaware.MLP259.model.Orders;

public interface OrdersDAO{

    @SqlUpdate("insert into mlp259.orders(order_id,food_id,vendor_id,customer_id,no_of_items,order_date,amt_to_be_paid,token_no,status,comment) values(:oid, :ofid, :ovid, :ocid, :onfi, :odt, :oamt, :otoken, :ostatus, :ocomment)")
    @Mapper(MenuMapper.class)
    int createOrderItem(@Bind("oid")int orderId,@Bind("ofid")int foodId,@Bind("ovid")int vendorId,@Bind("ocid")int customerId,@Bind("onfi")int noOfItems,@Bind("odt") Timestamp orderDate,@Bind("oamt")double amtToBePaid,@Bind("otoken")int tokenNumber,@Bind("ostatus")String status,@Bind("ocomment")String comment);

    @SqlQuery("Select * from mlp259.orders where customer_id = :id")
    @Mapper(OrdersMapper.class)
    Orders viewHistory(@Bind("id") int customerId);

    @SqlQuery("SELECT c.customer_id,c.wallet_type,c.wallet_amt,m.food_id,m.food_qty,m.food_price FROM mlp259.orders o,customer c,menu m WHERE o.customer_id=c.customer_id  AND o.FOOD_ID=m.FOOD_ID")
    @Mapper(BillMapper.class)
    List<Bill>  showOrders();

   /* @SqlUpdate("update customer set wallet_amt=:walletAmount where customer_id=:id")
  void updateWallet(int customerId,double walletAmount);*/

  @SqlQuery("SELECT c.customer_id,c.wallet_type,c.wallet_amt,m.food_id,m.food_qty,m.food_name,m.food_price FROM mlp259.orders o,customer c,menu m WHERE o.customer_id=c.customer_id  AND o.FOOD_ID=m.FOOD_ID")
    @Mapper(BillMapper.class)
    List<Bill>  showCarts();

    @SqlUpdate("update customer set wallet_amt=:walletAmount where customer_id=:customerId")
  void updateWalletAmt(@Bind("walletAmount") double walletAmount,@Bind("customerId") int customerId);

  @SqlQuery("Select * from Orders")
  @Mapper(OrdersMapper.class)
  List<Orders> show();

}