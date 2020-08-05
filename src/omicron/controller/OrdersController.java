/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omicron.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import omicron.dbController.DBConnection;
import omicron.model.Order_Detail;
import omicron.model.Orders;

/**
 *
 * @author Dulan
 */
public class OrdersController {

    public static boolean intoOrdersTable(Orders orders) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into Orders values(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, orders.getCustomerId());
            statement.setObject(2, orders.getCustomerName());
            statement.setObject(3, orders.getOrdersId());
            statement.setObject(4, orders.getOrdersDate());
            statement.setObject(5, orders.getOrdersTot_Amount());
            int ordersAddOrNot = statement.executeUpdate();

            if (ordersAddOrNot > 0) {
                boolean order_detailAddOrNot = Order_DetailController.intoOrder_DetailTable(orders.getOrderDetailList());

                if (order_detailAddOrNot) {
                    boolean confirmOrNot = BlackStockController.modifyInBlackStockTable(orders.getBlackStockList());
                    if (confirmOrNot) {
                        boolean itemDescOrNot = BatchController.descendingQtyInBatchTable(orders.getOrderDetailList());
                        if (itemDescOrNot) {
                            connection.commit();
                            return true;
                        }

//                    } else {
//                        connection.rollback();
                    }
//                } else {
//                    connection.rollback();
                }
//            } else {
//                connection.rollback();
            }

            return false;

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException except) {

            }

            throw ex;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static Orders getAllOrderAndOrder_DetailDetails(String ordersId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from orders natural join order_detail where ordersId='" + ordersId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Order_Detail> orderDetailList = new ArrayList<>();
        String customerId = null;
        String customerName = null;
        String ordersDate = null;
        double ordersTot_Amount = 0;

        while (resultSet.next()) {
            customerId = resultSet.getString("customerId");
            customerName = resultSet.getString("customerName");
            ordersDate = resultSet.getString("ordersDate");
            ordersTot_Amount = resultSet.getDouble("ordersTot_Amount");

            orderDetailList.add(new Order_Detail(resultSet.getString("itemCode"), ordersId, resultSet.getString("batchId"), resultSet.getInt("order_detailQty"),resultSet.getDouble("order_detailBatchSellingPrice"), resultSet.getDouble("order_detailSellingPrice"), resultSet.getString("order_detailReason")));

        }

        Orders allOrderDetails = new Orders(customerId, customerName, ordersId, ordersDate, ordersTot_Amount, orderDetailList);

        if (customerName == null) {
            return null;
        }
        return allOrderDetails;
    }

    public static double getDailyIncome(String date) throws ClassNotFoundException, SQLException {
        String sql="Select sum(ordersTot_Amount) from orders where ordersDate='"+date+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getDouble("sum(ordersTot_Amount)");
        }else{
            return 0;
        }
    }

    public static double getMonthlyIncome(String firstDate, String secondDate) throws ClassNotFoundException, SQLException {
        String sql="Select sum(ordersTot_Amount) from orders where ordersDate between '"+firstDate+"' and '"+secondDate+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getDouble("sum(ordersTot_Amount)");
        }else{
            return 0;
        }
    }


    public static ArrayList<Orders> getBestSellingItemList(String firstDate, String secondDate) throws ClassNotFoundException, SQLException {
        String sql="select itemCode , itemName ,  sum(order_detailQty) from order_detail natural join orders natural join item where ordersDate between '"+firstDate+"' and '"+secondDate+"' group by itemCode order by sum(order_detailQty) desc;";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        ArrayList<Orders> itemList=new ArrayList<>();
        
        while (resultSet.next()) {            
            itemList.add(new Orders(resultSet.getString("itemCode"), resultSet.getString("itemName"), resultSet.getInt("sum(order_detailQty)")));
        }
        return itemList;
    }

}
