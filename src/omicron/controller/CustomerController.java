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
import omicron.dbController.DBConnection;
import omicron.model.Customer;

/**
 *
 * @author Dulan
 */
public class CustomerController {

    public static boolean intoCustomerTable(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Customer values(?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, customer.getCustomerId());
        statement.setObject(2, customer.getCustomerName());
        statement.setObject(3, customer.getCustomerNic());
        statement.setObject(4, customer.getCustomerAddress());
        statement.setObject(5, customer.getCustomerTel_Num());
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static Customer getFromCustomerTable(String customerId) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Customer where customerId='" + customerId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            Customer customer = new Customer(customerId, resultset.getString("customerName"), resultset.getString("customerNic"), resultset.getString("customerAddress"), resultset.getInt("customerTel_Num"));
            return customer;
        }
        return null;
    }

    public static boolean modifyinCustomerTable(Customer customer) throws ClassNotFoundException, SQLException {
        String sql = "Update Customer set customerName=?, customerNic=?, customerAddress=?,customerTel_Num=? where customerId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, customer.getCustomerName());
        statement.setObject(2, customer.getCustomerNic());
        statement.setObject(3, customer.getCustomerAddress());
        statement.setObject(4, customer.getCustomerTel_Num());
        statement.setObject(5, customer.getCustomerId());

        int check = statement.executeUpdate();
        return check > 0;
    }

    public static boolean removeFromCustomerTable(String customerId) throws SQLException, ClassNotFoundException {
        String sql = "Delete from Customer where customerId='" + customerId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        int check = statement.executeUpdate(sql);
        return check > 0;
    }

    public static ArrayList<Customer> showFromCustomerTable() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Customer";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Customer> allCustomerList = new ArrayList<>();
        while (resultSet.next()) {
            allCustomerList.add(new Customer(resultSet.getString("customerId"), resultSet.getString("customerName"), resultSet.getString("customerNic"), resultSet.getString("customerAddress"), resultSet.getInt("customerTel_Num")));

        }
        return allCustomerList;
    }

    public static ArrayList<Customer> getAllCustomerDetails() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Customer";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Customer> allCustomerDetails = new ArrayList<>();

        while (resultSet.next()) {
            allCustomerDetails.add(new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
        }

        return allCustomerDetails;
    }

    public static Customer getAllDetailsToCustomerNic(String customerNic) throws ClassNotFoundException, SQLException {
        String sql="Select * from Customer where customerNic='"+customerNic+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            Customer allDetailsAboutCustomer=new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
            return allDetailsAboutCustomer;
        }
        return null;
        
    }

}
