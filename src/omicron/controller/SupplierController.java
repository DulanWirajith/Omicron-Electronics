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
import omicron.model.Supplier;

/**
 *
 * @author Dulan
 */
public class SupplierController {
    public static boolean intoSupplierTable(Supplier supplier) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Supplier values(?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, supplier.getSupplierId());
        statement.setObject(2, supplier.getSupplierName());
        statement.setObject(3, supplier.getSupplierNic());
        
        statement.setObject(4, supplier.getSupplierAddress());
        statement.setObject(5, supplier.getSupplierTel_Num());
        statement.setObject(6, supplier.getSupplierEmail());
        statement.setObject(7, supplier.getSupplierFax());
        
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static Supplier getFromSupplierTable(String supplierId) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Supplier where supplierId='" + supplierId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            Supplier supplier = new Supplier(supplierId, resultset.getString("supplierName"), resultset.getString("supplierNic"), resultset.getString("supplierAddress"),resultset.getInt("supplierTel_Num"),resultset.getString("supplierEmail"),resultset.getString("supplierFax"));
            return supplier;
        }
        return null;
    }

    public static boolean modifyinSupplierTable(Supplier supplier) throws ClassNotFoundException, SQLException {
        String sql="Update Supplier set supplierName=?, supplierNic=?,supplierAddress=?,supplierTel_Num=?,supplierEmail=?,supplierFax=? where supplierId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, supplier.getSupplierName());
        statement.setObject(2, supplier.getSupplierNic());
       
        statement.setObject(3, supplier.getSupplierAddress());
        statement.setObject(4, supplier.getSupplierTel_Num());
        statement.setObject(5, supplier.getSupplierEmail());
        statement.setObject(6, supplier.getSupplierFax());
        
        statement.setObject(7, supplier.getSupplierId());
        
        int check=statement.executeUpdate();
        return check>0;
    }

    public static boolean removeFromSupplierTable(String supplierId) throws SQLException, ClassNotFoundException {
        String sql="Delete from Supplier where supplierId='"+supplierId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        int check=statement.executeUpdate(sql);
        return check>0;
    }

    public static ArrayList<Supplier> showFromSupplierTable() throws ClassNotFoundException, SQLException {
        String sql="Select * from Supplier";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultset=statement.executeQuery(sql);
        
        ArrayList<Supplier> allSupplierList=new ArrayList<>();
        while (resultset.next()) {
            allSupplierList.add(new Supplier(resultset.getString("supplierId"),resultset.getString("supplierName"), resultset.getString("supplierNic"), resultset.getString("supplierAddress"),resultset.getInt("supplierTel_Num"),resultset.getString("supplierEmail"),resultset.getString("supplierFax")));
            
        }
        return allSupplierList;
    }

    public static ArrayList<Supplier> getAllSupplierDetails() throws ClassNotFoundException, SQLException {
        String sql="Select * from Supplier";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultset=statement.executeQuery(sql);
        
        ArrayList<Supplier> allSupplierDetails=new ArrayList<>();
        while (resultset.next()) {            
            allSupplierDetails.add(new Supplier(resultset.getString("supplierId"),resultset.getString("supplierName"), resultset.getString("supplierNic"), resultset.getString("supplierAddress"),resultset.getInt("supplierTel_Num"),resultset.getString("supplierEmail"),resultset.getString("supplierFax")));
            
        }
        return allSupplierDetails;
    }

    public static ArrayList<Supplier> getSupplierIdsToCombo() throws ClassNotFoundException, SQLException {
        String sql="Select * from Supplier";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        ArrayList<Supplier> allSuppliers=new ArrayList<>();
        while (resultSet.next()) {            
            allSuppliers.add(new Supplier(resultSet.getString("supplierId")));
        }
        return allSuppliers;
    }

    public static Supplier getSupplierDetailsToNic(String supplierNic) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Supplier where supplierNic='" + supplierNic + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            Supplier supplier = new Supplier(resultset.getString("supplierId"), resultset.getString("supplierName"), resultset.getString("supplierNic"), resultset.getString("supplierAddress"),resultset.getInt("supplierTel_Num"),resultset.getString("supplierEmail"),resultset.getString("supplierFax"));
            return supplier;
        }
        return null;
    }

    
}
