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
import javax.swing.JOptionPane;
import omicron.dbController.DBConnection;
import omicron.model.Batch;
import omicron.model.Brand;
import omicron.model.Item;
import omicron.model.Order_Detail;
import omicron.view.OrderManagement;

/**
 *
 * @author Dulan
 */
public class BatchController {

    public static ArrayList<Batch> getAllBatchIdsToItemCode(String itemCode) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Batch where itemCode='" + itemCode + "'";
        Connection connectin = DBConnection.getDBConnection().getConnection();
        Statement statement = connectin.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Batch> allBatchIDs = new ArrayList<>();
        while (resultSet.next()) {
            if (resultSet.getInt("batchQty") > 0) {
                allBatchIDs.add(new Batch(resultSet.getString("batchId"), resultSet.getInt("batchQty")));
            }
        }
        return allBatchIDs;
    }

    public static ArrayList<Batch> getBatchDetailsForOneBatchId(String batchId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Batch where batchId='" + batchId + "'";
        Connection connectin = DBConnection.getDBConnection().getConnection();
        Statement statement = connectin.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Batch> batchDetails = new ArrayList<>();
        if (resultSet.next()) {
            batchDetails.add(new Batch(resultSet.getString("itemCode"), batchId, resultSet.getDouble("batchBuyingPrice"), resultSet.getDouble("batchSellingPrice"), resultSet.getString("batchDescription"), resultSet.getInt("batchQty")));
        }
        return batchDetails;
    }

    static boolean descendingQtyInBatchTable(ArrayList<Order_Detail> orderDetailList) throws ClassNotFoundException, SQLException {
        boolean descQtyOrNot = false;
        for (Order_Detail order_Detail : orderDetailList) {
            String batchId = order_Detail.getBatchId();
            if (!batchId.equals("Black")) {
                String sql = "Update Batch set batchQty=batchQty-? where batchId=?";
                Connection connection = DBConnection.getDBConnection().getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setObject(1, order_Detail.getOrder_detailQty());
                statement.setObject(2, order_Detail.getBatchId());
                int check = statement.executeUpdate();
                if (check > 0) {
                    descQtyOrNot = true;
                }
            }
        }
        return descQtyOrNot;
    }

    public static Batch getLastBatchIdToSelectedItemCode(String itemCode) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Batch where itemCode='" + itemCode + "' order by batchDescription desc";
        Connection connectin = DBConnection.getDBConnection().getConnection();
        Statement statement = connectin.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Batch lastBatch = new Batch(itemCode, resultSet.getString("batchId"), resultSet.getDouble("batchBuyingPrice"), resultSet.getDouble("batchSellingPrice"), resultSet.getString("batchDescription"), resultSet.getInt("batchQty"));
            return lastBatch;
        }
        return null;
    }

    // Normal Operations
    public static boolean intoBatchTable(Batch batch) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Batch values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getItemCode());
        statement.setObject(2, batch.getBatchId());
        statement.setObject(3, batch.getBatchBuyingPrice());
        statement.setObject(4, batch.getBatchSellingPrice());
        statement.setObject(5, batch.getBatchDescription());
        statement.setObject(6, batch.getBatchQty());
        int check = statement.executeUpdate();
        return check > 0;
    }
//

    public static Batch getFromBatchTable(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Batch where batchId='" + batchId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        if (resultset.next()) {
            Batch batch = new Batch(resultset.getString("itemCode"), batchId, resultset.getDouble("batchBuyingPrice"), resultset.getDouble("batchSellingPrice"), resultset.getString("batchDescription"), resultset.getInt("batchQty"));
            return batch;
        }
        return null;
    }
//

    public static boolean modifyinBatchTable(Batch batch) throws ClassNotFoundException, SQLException {
        String sql = "Update Batch set itemCode=?, batchBuyingPrice=? ,batchSellingPrice=?, batchDescription=? ,batchQty=? where batchId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getItemCode());
        statement.setObject(2, batch.getBatchBuyingPrice());
        statement.setObject(3, batch.getBatchSellingPrice());
        statement.setObject(4, batch.getBatchDescription());
        statement.setObject(5, batch.getBatchQty());
        statement.setObject(6, batch.getBatchId());
        int check = statement.executeUpdate();
        return check > 0;
    }
//

    public static boolean removeFromBatchTable(String batchId) throws SQLException, ClassNotFoundException {
        String sql = "Delete from Batch where batchId='" + batchId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        int check = statement.executeUpdate(sql);
        return check > 0;
    }
//

    public static ArrayList<Batch> showFromBatchTable() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Batch";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        ArrayList<Batch> allBatchList = new ArrayList<>();
        while (resultset.next()) {
            allBatchList.add(new Batch(resultset.getString("itemCode"), resultset.getString("batchId"), resultset.getDouble("batchBuyingPrice"), resultset.getDouble("batchSellingPrice"), resultset.getString("batchDescription"), resultset.getInt("batchQty")));

        }
        return allBatchList;
    }

    static boolean descendingQtyByOneInBatchTable(String batchId) throws ClassNotFoundException, SQLException {
        boolean descQtyOrNot = false;
//        if (!batchId.equals("Black")) {
        String sql = "Update Batch set batchQty=batchQty-1 where batchId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batchId);
        int check = statement.executeUpdate();
        if (check > 0) {
            descQtyOrNot = true;
        }
        return descQtyOrNot;
    }
//    }

//    static boolean ascendingQtyInBatchTable(ArrayList<Batch> allBatchDetails) {
//        
//    }
    static boolean batchIsAlreadyInOrNot(String batchId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Batch where batchId='" + batchId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }

    }

    static boolean ascendingQtyInBatchTable(Batch batch, int blackStockQty) throws ClassNotFoundException, SQLException {
        int availableQty = batch.getBatchQty();
        int nowQty = availableQty - blackStockQty;
        String sql = "Update Batch set batchQty=? where batchId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, nowQty);
        statement.setObject(2, batch.getBatchId());
        int check = statement.executeUpdate();
        return check > 0;

    }

    static boolean intoBatchTable(Batch batch, int blackStockQty) throws ClassNotFoundException, SQLException {
        int availableQty = batch.getBatchQty();
        int nowQty = availableQty - blackStockQty;
        String sql = "Insert into Batch values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getItemCode());
        statement.setObject(2, batch.getBatchId());
        statement.setObject(3, batch.getBatchBuyingPrice());
        statement.setObject(4, batch.getBatchSellingPrice());
        statement.setObject(5, batch.getBatchDescription());
        statement.setObject(6, nowQty);
        int check = statement.executeUpdate();
        return check > 0;
    }

    static boolean ascendingQtyByOneInBatchTable(String batchId) throws ClassNotFoundException, SQLException {
        String sql = "Update Batch set batchQty=batchQty+1 where batchId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batchId);
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static ArrayList<Batch> getRe_OrderLevelItems() throws ClassNotFoundException, SQLException {
        String sql = "Select itemCode , itemName ,itemRe_OrderLevel , sum(batchQty) from batch natural join item group by itemCode";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Batch> allItems = new ArrayList<>();

        while (resultSet.next()) {
            int reOrderLevel = resultSet.getInt("itemRe_OrderLevel");
            int availableQty = resultSet.getInt("sum(batchQty)");
            if (reOrderLevel >= availableQty) {
                allItems.add(new Batch(resultSet.getString("itemCode"), resultSet.getString("itemName"), reOrderLevel, availableQty));
            }
        }
        return allItems;
    }

    public static ArrayList<Batch> getAvailableStock() throws ClassNotFoundException, SQLException {
        String sql = "Select itemCode , itemName ,itemRe_OrderLevel , sum(batchQty) from batch natural join item group by itemCode";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Batch> availableItems = new ArrayList<>();

        while (resultSet.next()) {
            int reOrderLevel = resultSet.getInt("itemRe_OrderLevel");
            int availableQty = resultSet.getInt("sum(batchQty)");

            availableItems.add(new Batch(resultSet.getString("itemCode"), resultSet.getString("itemName"), reOrderLevel, availableQty));

        }
        return availableItems;
    }

}
