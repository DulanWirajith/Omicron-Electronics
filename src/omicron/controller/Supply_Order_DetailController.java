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
import omicron.dbController.DBConnection;
import omicron.model.Supply_Order_Detail;

/**
 *
 * @author Dulan
 */
public class Supply_Order_DetailController {

    public static boolean intoSupply_Order_DetailTable(ArrayList<Supply_Order_Detail> supply_Order_Details) throws ClassNotFoundException, SQLException {
        for (Supply_Order_Detail supply_Order_Detail : supply_Order_Details) {
            String sql="Insert into supply_order_detail values(?,?,?,?)";
            Connection connection=DBConnection.getDBConnection().getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setObject(1, supply_Order_Detail.getItemCode());
            statement.setObject(2, supply_Order_Detail.getSupply_orderId());
            statement.setObject(3, supply_Order_Detail.getSupply_order_detailRequestQty());
            statement.setObject(4, supply_Order_Detail.getBatchId());
            statement.executeUpdate();
//            if (statement.executeUpdate()<0) {
//                return false;
//            }
        }
        return true;
    }
    
}
