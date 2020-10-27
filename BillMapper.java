package com.hexaware.MLP259.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.MLP259.model.Bill;
import com.hexaware.MLP259.model.Customer;
import com.hexaware.MLP259.model.Menu;
import com.hexaware.MLP259.model.Orders;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
public class BillMapper implements ResultSetMapper<Bill> {
    
     
  public final Bill map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Order
       */
     
    return new Bill(rs.getInt("customer_id"),rs.getInt("food_id"),rs.getString("food_name"),rs.getString("wallet_type"),rs.getDouble("wallet_amt"),rs.getInt("food_qty"),rs.getDouble("food_price"));
  }
}