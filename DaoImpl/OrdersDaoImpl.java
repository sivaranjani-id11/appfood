package com.food.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.food.DAO.OrdersDAO;
import com.food.Model.Orders;
import com.food.Util.DBconnection;

public class OrdersDaoImpl implements OrdersDAO {
    private static final String INSERTQUERY = "INSERT INTO orders(Userid, Restaurantid, Totalamount, Status, Paymentmode) VALUES(?, ?, ?, ?, ?)";
    private static final String FETCHALL = "SELECT * FROM orders";
    private static final String FETCHONE = "SELECT * FROM orders WHERE Orderid=?";
    private static final String UPDATE = "UPDATE orders SET Status=? WHERE Orderid=?";
    private static final String DELETE = "DELETE FROM orders WHERE Orderid=?";
    static Connection con;

    static {
        con = DBconnection.connect();
    }

    private PreparedStatement pstmt;
    private ResultSet resultSet;

    @Override
    public int insert(Orders o) {
        try {
            pstmt = con.prepareStatement(INSERTQUERY, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, o.getUserid());
            pstmt.setInt(2, o.getRestaurantid());
            pstmt.setFloat(3, o.getTotalamount());
            pstmt.setString(4, o.getStatus());
            pstmt.setString(5, o.getPaymentmode());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Return the generated Order ID
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Orders> fetchAll() {
        ArrayList<Orders> ordersList = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCHALL);
            while (resultSet.next()) {
                ordersList.add(new Orders(
                    resultSet.getInt("Userid"),
                    resultSet.getInt("Restaurantid"),
                    resultSet.getFloat("Totalamount"),
                    resultSet.getString("Status"),
                    resultSet.getString("Paymentmode")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public Orders fetchOne(int orderid) {
        try {
            pstmt = con.prepareStatement(FETCHONE);
            pstmt.setInt(1, orderid);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return new Orders(
                    resultSet.getInt("Userid"),
                    resultSet.getInt("Restaurantid"),
                    resultSet.getFloat("Totalamount"),
                    resultSet.getString("Status"),
                    resultSet.getString("Paymentmode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int orderid, String status) {
        try {
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setString(1, status);
            pstmt.setInt(2, orderid);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int orderid) {
        try {
            pstmt = con.prepareStatement(DELETE);
            pstmt.setInt(1, orderid);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}



