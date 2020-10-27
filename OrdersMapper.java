package com.hexaware.MLP259.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.hexaware.MLP259.model.Menu;
import com.hexaware.MLP259.model.Customer;
import com.hexaware.MLP259.model.Orders;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class OrdersMapper implements ResultSetMapper<Orders> {
    public  final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
   
    return new Orders(rs.getInt("order_id"),rs.getInt("food_id"),rs.getInt("vendor_id"),rs.getInt("customer_id"),rs.getInt("no_of_items"),rs.getTimestamp("order_date"),rs.getDouble("amt_to_be_paid"),rs.getInt("token_no"),rs.getString("status"),rs.getString("comment"));
    }
}