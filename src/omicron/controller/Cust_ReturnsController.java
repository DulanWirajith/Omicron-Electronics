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
import java.util.ArrayList;
import omicron.dbController.DBConnection;
import omicron.model.Batch;
import omicron.model.Cust_Returns;

/**
 *
 * @author Dulan
 */
public class Cust_ReturnsController {

    public static boolean insertIntoCustomer_ReturnsTable(ArrayList<Cust_Returns> returnItems) throws ClassNotFoundException, SQLException {

        boolean dataOk = false;
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        boolean all = false;
        try {

            for (Cust_Returns returnItem : returnItems) {

//            
                String sql = "Insert into cust_returns values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setObject(1, returnItem.getOrdersId());
                statement.setObject(2, returnItem.getReturnId());
                statement.setObject(3, returnItem.getSerial_num());
                statement.setObject(4, returnItem.getBatchId());
                statement.setObject(5, returnItem.getItemCode());
                statement.setObject(6, returnItem.getBatchSellingPrice());
                statement.setObject(7, returnItem.getReturnSupplierId());
                statement.setObject(8, returnItem.getReturnReason());
                statement.setObject(9, returnItem.getReturnDate());
                int check = statement.executeUpdate();

                if (check > 0) {
                    
                    boolean addOrNot = Sup_ReturnsController.intoSupplier_ReturnTable(returnItem);
                    if (addOrNot) {
                        boolean updateOrNot = false;
                        if (!returnItem.getBatchId().equals("Black")) {
                            updateOrNot = BatchController.descendingQtyByOneInBatchTable(returnItem.getBatchId());
                        } else {
                            updateOrNot = BlackStockController.intoBlackStockTableFromReturns(returnItem.getItemCode(), returnItem.getBatchSellingPrice());
                        }

                        if (updateOrNot && addOrNot && check > 0) {
                            all = true;
//                           
                        }

                    }
                }

            }
            if (all) {
                connection.commit();
                dataOk = true;
            }

        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {

            }
            throw exception;
        } finally {
            connection.setAutoCommit(true);
        }

        return dataOk;
    }

    static boolean modifyInCust_ReturnsTable(Batch batch) throws ClassNotFoundException, SQLException {
        String sql = "Update cust_returns set batchId=? where batchId='Black' and  batchSellingPrice=? and itemCode=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getBatchId());
        statement.setObject(2, batch.getBatchSellingPrice());
        statement.setObject(3, batch.getItemCode());
        int check = statement.executeUpdate();
        return check > 0;
    }

    static boolean check(Batch batch) throws ClassNotFoundException, SQLException {
        String sql = "Select * from cust_returns where batchId='Black' and  batchSellingPrice=? and itemCode=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getBatchSellingPrice());
        statement.setObject(2, batch.getItemCode());
        ResultSet resultSet=statement.executeQuery();
        return resultSet.next();
        //return resultSet.nrxt();
    }
}
