/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omicron.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeArray;
import omicron.dbController.DBConnection;
import omicron.model.Batch;
import omicron.model.Order_Detail;

/**
 *
 * @author Dulan
 */
public class Order_DetailController {

    static boolean intoOrder_DetailTable(ArrayList<Order_Detail> orderDetailList) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Order_Detail values (?,?,?,?,?,?,?)";

        boolean orderAddOrNot = false;

        for (Order_Detail order_Detail : orderDetailList) {
            String batchId = order_Detail.getBatchId();

            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, order_Detail.getItemCode());
            statement.setObject(2, order_Detail.getOrdersId());

            statement.setObject(3, order_Detail.getBatchId());
            statement.setObject(4, order_Detail.getOrder_detailQty());
            statement.setObject(5, order_Detail.getOrder_detailBatchSellingPrice());
            statement.setObject(6, order_Detail.getOrder_detailSellingPrice());
            statement.setObject(7, order_Detail.getOrder_detailReason());

            int check = statement.executeUpdate();
            if (check > 0) {
                orderAddOrNot = true;
            }
        }
        return orderAddOrNot;
    }

    static boolean modifyInOrderDetailTable(Batch batch) throws ClassNotFoundException, SQLException {
        String sql = "Update Order_Detail set batchId=? where batchId='Black' and order_detailBatchSellingPrice=? and itemCode=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, batch.getBatchId());
        statement.setObject(2, batch.getBatchSellingPrice());
        statement.setObject(3, batch.getItemCode());
        int check = statement.executeUpdate();
        return check > 0;
    }

}
