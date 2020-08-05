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
import omicron.model.Supply_Order;
import omicron.model.Supply_Order_Detail;

/**
 *
 * @author Dulan
 */
public class Supply_OrderController {

    public static boolean intoSupply_OrderTable(Supply_Order orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into supply_order values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, orderDetails.getSupplierId());
            statement.setObject(2, orderDetails.getSupply_orderId());
            statement.setObject(3, orderDetails.getSupply_orderRequestDate());
            statement.setObject(4, orderDetails.getSupply_orderTotAmount());
            statement.setObject(5, orderDetails.getSupply_orderWillReceiveDate());
            int check = statement.executeUpdate();
            if (check > 0) {
                boolean addOrNot = Supply_Order_DetailController.intoSupply_Order_DetailTable(orderDetails.getSupply_Order_Details());
                if (addOrNot) {
                    connection.commit();
                    return true;
                }
            }

        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException e) {

            }
            throw exception;
        } finally {
            connection.setAutoCommit(true);

        }
        return true;

    }

    public static Supply_Order getSupplyOrderDetailsToOneId(String orderId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Supply_Order natural join Supply_Order_Detail where supply_orderId='" + orderId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Supply_Order_Detail> allSupply_Order_Details = new ArrayList<>();
        String supplierId = null;
        double supply_orderTotAmount = 0;
        while (resultSet.next()) {
            String itemCode = resultSet.getString("itemCode");
            int supply_order_detailRequestQty = resultSet.getInt("supply_order_detailRequestQty");
            String batchId = resultSet.getString("batchId");

            allSupply_Order_Details.add(new Supply_Order_Detail(itemCode, orderId, supply_order_detailRequestQty, batchId));

            supplierId = resultSet.getString("supplierId");
            supply_orderTotAmount=resultSet.getDouble("supply_orderTotAmount");
        }

        Supply_Order allOrderDetails = new Supply_Order(supplierId, orderId, supply_orderTotAmount, allSupply_Order_Details);

        if (supplierId == null) {
            return null;
        }
        return allOrderDetails;
    }

    public static boolean updateSupply_OrderTableAndintoGRNTableAndBatchTable(Supply_Order allSupply_Order) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Update Supply_Order set supply_orderTotAmount=?, supply_orderWillReceiveDate=? where supply_orderId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, allSupply_Order.getSupply_orderTotAmount());
            statement.setObject(2, allSupply_Order.getSupply_orderWillReceiveDate());
            statement.setObject(3, allSupply_Order.getSupply_orderId());
            int check = statement.executeUpdate();
            if (check > 0) {
                boolean grnAddOrNot = GRNController.intoGRNTable(allSupply_Order.getAllGRNDetails());
                if (grnAddOrNot) {
                    ArrayList<Batch> allBatchListInTheGRN = allSupply_Order.getAllBatchDetails();
                    boolean confirmBatch = false;
                    for (Batch batch : allBatchListInTheGRN) {
                        boolean batchAlreadyInOrNot = BatchController.batchIsAlreadyInOrNot(batch.getBatchId());
                        boolean updateOrNot = false;
                        boolean addOrNot = false;
                        ArrayList<BlackStock> allBlackStockRecordsIoOneBatchId = BlackStockController.getAllBlackStockRecordsToOneBatchId(batch);
                        int blackStockQty = 0;
//                        blackStock Qty eka ganna
                        boolean statusUpdateToYes = false;
                        if (allBlackStockRecordsIoOneBatchId != null) {

                            for (BlackStock blackStock : allBlackStockRecordsIoOneBatchId) {
                                int qty = blackStock.getQty();
                                blackStockQty += qty;
                            }
//                        Status eka wenas karanna    
                            statusUpdateToYes = BlackStockController.statusUpdateToYES(batch);

                        }

                        if (batchAlreadyInOrNot) {
                            updateOrNot = BatchController.ascendingQtyInBatchTable(batch, blackStockQty);

                        } else {
                            addOrNot = BatchController.intoBatchTable(batch, blackStockQty);
                        }

                        boolean checkInCust_ReturnsTable=Cust_ReturnsController.check(batch);
                        
                        if (statusUpdateToYes && addOrNot || updateOrNot && statusUpdateToYes) {
                            //confirmBatch = true;
                            boolean changeOrderDetailBatch = Order_DetailController.modifyInOrderDetailTable(batch);
                            boolean changeSup_ReturnsBatch = Sup_ReturnsController.modifyInSup_ReturnsTable(batch);
                            boolean changeCust_ReturnsBatch = Cust_ReturnsController.modifyInCust_ReturnsTable(batch);
                            
                            if (changeOrderDetailBatch) {
                                confirmBatch = true;
                            } else {
                                break;
                            }
                            
//                            meka wenna oonama nee...
                        }else if(addOrNot && checkInCust_ReturnsTable || updateOrNot && checkInCust_ReturnsTable){
                            boolean changeSup_ReturnsBatch = Sup_ReturnsController.modifyInSup_ReturnsTable(batch);
                            boolean changeCust_ReturnsBatch = Cust_ReturnsController.modifyInCust_ReturnsTable(batch);

                            if (changeCust_ReturnsBatch && changeSup_ReturnsBatch) {
                                confirmBatch = true;
                            } else {
                                break;
                            }
                        }else if(addOrNot || updateOrNot){
                            confirmBatch = true;
                        }

                    }
                    if (confirmBatch) {
                        connection.commit();
                        return true;
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

}
