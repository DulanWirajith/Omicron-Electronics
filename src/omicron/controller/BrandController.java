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

/**
 *
 * @author Dulan
 */
public class BrandController {

    public static boolean intoBrandTable(Brand brand) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Brand values(?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, brand.getBrandId());
        statement.setObject(2, brand.getBrandName());
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static Brand getFromBrandTable(String brandId) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Brand where brandId='" + brandId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            Brand brand = new Brand(brandId, resultset.getString("brandName"));
            return brand;
        }
        return null;
    }

    public static boolean modifyinBrandTable(Brand brand) throws ClassNotFoundException, SQLException {
        String sql = "Update Brand set brandName=? where brandId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, brand.getBrandName());
        statement.setObject(2, brand.getBrandId());

        int check = statement.executeUpdate();
        return check > 0;
    }

    public static boolean removeFromBrandTable(String brandId) throws SQLException, ClassNotFoundException {
        String sql = "Delete from Brand where brandId='" + brandId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        int check = statement.executeUpdate(sql);
        return check > 0;
    }

    public static ArrayList<Brand> showFromBrandTable() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Brand";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Brand> allBrandList = new ArrayList<>();
        while (resultSet.next()) {
            allBrandList.add(new Brand(resultSet.getString("brandId"), resultSet.getString("brandName")));

        }
        return allBrandList;
    }

    public static String getBrandNameToShowAllItems(String brandId) throws SQLException, ClassNotFoundException {
        String sql = "select * from Brand where brandId = '" + brandId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getString("brandName");
        }
        return null;
    }

    public static ArrayList<Brand> loadBrandNames() throws SQLException, ClassNotFoundException {
        String sql = "select * from Brand";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Brand> allBrands = new ArrayList<>();
        while (resultSet.next()) {
            allBrands.add(new Brand(resultSet.getString("brandId"), resultSet.getString("brandName")));
        }
        return allBrands;
    }

    public static String getBrandIdToSelectedBrand(String brandName) throws ClassNotFoundException, SQLException {
        String sql = "select * from Brand where brandName = '" + brandName + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getString("brandId");
        }
        return null;
    }

    public static String getBrandId(String brandName) throws ClassNotFoundException, SQLException {
        String sql="Select * from Brand where brandName='"+brandName+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next()) {
            String brandId=resultSet.getString("brandId");
            return brandId;
        }
        return null;
    }
}
