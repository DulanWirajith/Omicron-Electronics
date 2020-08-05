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
import omicron.model.Batch;
import omicron.model.BlackStock;

/**
 *
 * @author Dulan
 */
public class BlackStockController {

    public static boolean intoBlackStockTable(BlackStock blackStock) throws ClassNotFoundException, SQLException {
        String sql = "Insert into BlackStock values(?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, blackStock.getItemCode());
        statement.setObject(2, blackStock.getUnitPrice());
        statement.setObject(3, blackStock.getDiscountPrice());
        statement.setObject(4, blackStock.getQty());
        statement.setObject(5, blackStock.getStatus());
        statement.setObject(6, blackStock.getConfirm());
        statement.setObject(7, blackStock.getTableUnitPrice());
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static ArrayList<String> getAllItemsToOneItemCode(String itemCode) throws ClassNotFoundException, SQLException {
        String sql = "select tableUnitPrice in BlackStock where itemCode=" + itemCode + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> allTableUnitPrices = new ArrayList<>();
        while (resultSet.next()) {
            allTableUnitPrices.add(resultSet.getString("tableUnitPrice"));
        }
        return allTableUnitPrices;
    }

    public static boolean modifyQty(String itemCode, double tableUniPri, int newQty) throws ClassNotFoundException, SQLException {
        String sql = "Update BlackStock set qty=qty+? where itemCode=? and tableUnitPrice=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, newQty);
        statement.setObject(2, itemCode);
        statement.setObject(3, tableUniPri);
        int check = statement.executeUpdate();
        return check > 0;
    }

    static boolean modifyInBlackStockTable(ArrayList<BlackStock> blackStockList) throws ClassNotFoundException, SQLException {
        for (BlackStock blackStock : blackStockList) {
            double tableUnitPrice = blackStock.getTableUnitPrice();
            String itemCode = blackStock.getItemCode();

            String sql = "Update BlackStock set confirm='Confirmed' where itemCode=? and tableUnitPrice=?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, itemCode);
            statement.setObject(2, tableUnitPrice);
            int check = statement.executeUpdate();
        }
        return true;
    }

    static boolean intoBlackStockTableFromReturns(String itemCode, double unitPrice) throws ClassNotFoundException, SQLException {
        String sql = "Insert into BlackStock values(?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, itemCode);
        statement.setObject(2, unitPrice);
        statement.setObject(3, "0.00");
        statement.setObject(4, "1");
        statement.setObject(5, "NO");
        statement.setObject(6, "Confirmed Cust_Return");
        statement.setObject(7, "0.00");
        int check = statement.executeUpdate();
        return check > 0;
    }

    static ArrayList<BlackStock> getAllBlackStockRecordsToOneBatchId(Batch batch) throws ClassNotFoundException, SQLException {
        String sql = "Select * from BlackStock where itemCode=? and unitPrice=? and confirm='Confirmed' and status='NO'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getItemCode());
        statement.setObject(2, batch.getBatchSellingPrice());
        ResultSet resultSet = statement.executeQuery();
        ArrayList<BlackStock> allBlackStockRecords = new ArrayList<>();

        while (resultSet.next()) {
            allBlackStockRecords.add(new BlackStock(resultSet.getString("itemCode"), resultSet.getDouble("unitPrice"), resultSet.getDouble("discountPrice"), resultSet.getInt("qty"), resultSet.getString("status"), resultSet.getString("confirm"), resultSet.getDouble("tableUnitPrice")));
        }

        return allBlackStockRecords;
    }

    static boolean statusUpdateToYES(Batch batch) throws ClassNotFoundException, SQLException {
        String sql="Update BlackStock set status='YES' where itemCode=? and unitPrice=? and confirm='Confirmed' and status='NO'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getItemCode());
        statement.setObject(2, batch.getBatchSellingPrice());
        int check=statement.executeUpdate();
        return check>0;
    }

}
