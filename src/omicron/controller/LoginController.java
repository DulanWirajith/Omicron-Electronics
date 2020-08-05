/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omicron.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import omicron.dbController.DBConnection;
import omicron.model.Login;

/**
 *
 * @author Dulan
 */
public class LoginController {

    public static Login loginToSystem(String user, String password) throws ClassNotFoundException, SQLException {
        String sql="Select * from Login where userName='"+user+"' and password='"+password+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        if (resultSet.next()) {
            Login login= new Login(resultSet.getString("loginId"), resultSet.getString("userName"), resultSet.getString("password"));
            return login;
        }else{
            return null;
        }
    }
    
}
