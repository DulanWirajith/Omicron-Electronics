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
import omicron.model.Brand;
import omicron.model.Item;

/**
 *
 * @author Dulan
 */
public class ItemController {

    public static boolean intoItemTable(Item item) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Item values(?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, item.getBrandId());
        statement.setObject(2, item.getItemCode());
        statement.setObject(3, item.getItemName());
        statement.setObject(4, item.getSupplierId());
        statement.setObject(5, item.getItemRe_OrderLevel());
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static Item getFromItemTable(String itemCode) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Item where itemCode='" + itemCode + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            Item item = new Item(resultset.getString("brandId"), itemCode, resultset.getString("itemName"), resultset.getString("supplierId"),resultset.getInt("itemRe_OrderLevel"));
            return item;
        }
        return null;
    }

    public static boolean modifyinItemTable(Item item) throws ClassNotFoundException, SQLException {
        String sql = "Update Item set brandId=?,itemName=?,supplierId=?,itemRe_OrderLevel=? where itemCode=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, item.getBrandId());
        statement.setObject(2, item.getItemName());
        statement.setObject(3, item.getSupplierId());
        statement.setObject(4, item.getItemRe_OrderLevel());
        statement.setObject(5, item.getItemCode());

        int check = statement.executeUpdate();
        return check > 0;
    }

    public static boolean removeFromItemTable(String itemCode) throws SQLException, ClassNotFoundException {
        String sql = "Delete from Item where itemCode='" + itemCode + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        int check = statement.executeUpdate(sql);
        return check > 0;
    }

    public static ArrayList<Item> showFromItemTable() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Item";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        ArrayList<Item> allItemList = new ArrayList<>();
        while (resultset.next()) {
            allItemList.add(new Item(resultset.getString("brandId"), resultset.getString("itemCode"), resultset.getString("itemName"), resultset.getString("supplierId"),resultset.getInt("itemRe_OrderLevel")));

        }
        return allItemList;
    }

    public static ArrayList<Item> getItemListToBrandId(String brandId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Item where brandId='" + brandId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        ArrayList<Item> allItemList = new ArrayList<>();
        while (resultset.next()) {
            allItemList.add(new Item(resultset.getString("itemName"), resultset.getString("itemCode")));

        }
        return allItemList;
    }

    public static String getItemCodeToItemName(String itemName) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Item where itemName='" + itemName + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            return resultset.getString("itemCode");
        }
        return null;
    }

    public static ArrayList<Item> getItemIdsToOneSupplier(String supplierId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Item where supplierId='" + supplierId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
       
        ArrayList<Item> itemIdsToOneSupplier=new ArrayList<>();
        while (resultset.next()) {            
            itemIdsToOneSupplier.add(new Item(resultset.getString("itemName"), resultset.getString("itemCode")));
        }
        
        return itemIdsToOneSupplier;
}

}
