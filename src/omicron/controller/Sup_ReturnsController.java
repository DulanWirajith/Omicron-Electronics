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
import omicron.model.Cust_Returns;
import omicron.model.Sup_Returns;

/**
 *
 * @author Dulan
 */
public class Sup_ReturnsController {

    static boolean intoSupplier_ReturnTable(Cust_Returns returnItem) throws ClassNotFoundException, SQLException {
        String batchId = returnItem.getBatchId();
        String returnDescription;
        if (batchId.equals("Black")) {
            returnDescription = "Black Customer Return";
        } else {
            returnDescription = "From Customer Returns";
        }

        String sql = "Insert into Sup_Returns values(?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, returnItem.getReturnSupplierId());
        statement.setObject(2, returnItem.getBatchId());
        statement.setObject(3, returnItem.getSerial_num());
        statement.setObject(4, returnItem.getItemCode());
        statement.setObject(5, returnItem.getBatchSellingPrice());
        statement.setObject(6, returnItem.getSup_ReturnStatus());
        statement.setObject(7, returnDescription);
        statement.setObject(8, returnItem.getReturnDate());
        int check = statement.executeUpdate();
        return check > 0;
    }

    public static ArrayList<Sup_Returns> getAllReturnsToOneSupplier(String supplierId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from sup_returns where supplierId='" + supplierId + "' and status='NOT OK'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Sup_Returns> allReturnsToOneSupplierId = new ArrayList<>();
        while (resultSet.next()) {
            allReturnsToOneSupplierId.add(new Sup_Returns(supplierId, resultSet.getString("batchId"), resultSet.getString("serial_num"), resultSet.getString("itemCode"), resultSet.getDouble("batchSellingPrice"), resultSet.getString("status"), resultSet.getString("returnDescription"), resultSet.getString("returnDate")));
        }
        return allReturnsToOneSupplierId;
    }

    static boolean modifyInSup_ReturnsTable(Batch batch) throws ClassNotFoundException, SQLException {

        String sql = "Update sup_returns set batchId=? where batchId='Black' and batchSellingPrice=? and itemCode=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getBatchId());
        statement.setObject(2, batch.getBatchSellingPrice());
        statement.setObject(3, batch.getItemCode());
        int check = statement.executeUpdate();
        return check > 0;

    }

    public static boolean modifyStatesInSup_ReturnsTable(ArrayList<Sup_Returns> allSup_ReturnsToConfirm) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            for (Sup_Returns sup_Returns : allSup_ReturnsToConfirm) {

                String sql = "Update sup_returns set status='OK' where batchId=? and batchSellingPrice=? and itemCode=?";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setObject(1, sup_Returns.getBatchId());
                statement.setObject(2, sup_Returns.getBatchSellingPrice());
                statement.setObject(3, sup_Returns.getItemCode());
                int check = statement.executeUpdate();

                if (check > 0) {
                    String returnDesc = sup_Returns.getReturnDescription();
                    if (!returnDesc.equals("Black Customer Return")) {
                        boolean ascendBatch = BatchController.ascendingQtyByOneInBatchTable(sup_Returns.getBatchId());
                        if (ascendBatch) {
                            connection.commit();
                            return true;
                        }
                    }
                }

            }
            return false;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                
            }

            throw exception;
        } finally {
            connection.setAutoCommit(true);
        }

    }

    static boolean intoSup_ReturnsTable(Sup_Returns returns) throws SQLException, ClassNotFoundException {
        String sql = "Insert into Sup_Returns values(?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, returns.getSupplierId());
        statement.setObject(2, returns.getBatchId());
        statement.setObject(3, returns.getSerial_num());
        statement.setObject(4, returns.getItemCode());
        statement.setObject(5, returns.getBatchSellingPrice());
        statement.setObject(6, returns.getStatus());
        statement.setObject(7, returns.getReturnDescription());
        statement.setObject(8, returns.getReturnDate());
        int check = statement.executeUpdate();
        return check > 0;
    }

}
