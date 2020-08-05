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
import omicron.model.GRN;

/**
 *
 * @author Dulan
 */
public class GRNController {

    static boolean intoGRNTable(ArrayList<GRN> allGRNDetails) throws ClassNotFoundException, SQLException {
        boolean allCheck=false;
        for (GRN allGRNDetail : allGRNDetails) {
            String sql="Insert into GRN values (?,?,?,?)";
            Connection connection=DBConnection.getDBConnection().getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setObject(1, allGRNDetail.getBatchId());
            statement.setObject(2, allGRNDetail.getSupply_orderId());
            statement.setObject(3, allGRNDetail.getGrnReceived_Qty());
            statement.setObject(4, allGRNDetail.getGrnTotAmount());
            int check=statement.executeUpdate();
            if (check<=0) {
                return false;
            }
        }
        return true;
    }
    
}
