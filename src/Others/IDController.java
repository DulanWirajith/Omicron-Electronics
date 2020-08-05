/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import omicron.dbController.DBConnection;

/**
 *
 * @author Dulan
 */
public class IDController {
    
    public static String getLastID(String tableName, String colName) throws ClassNotFoundException, SQLException {
        String sql = "select " + colName + " from " + tableName + " order by 1 desc limit 1";
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement statement = connection.createStatement();   
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next()) {
            return  resultSet.getString(1);
        }
        return null;  
    }

}
