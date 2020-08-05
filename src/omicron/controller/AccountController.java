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
import omicron.model.Account;

/**
 *
 * @author Dulan
 */
public class AccountController {

    public static ArrayList<Account> loadAllAccounts() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Account";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Account> allAccounts = new ArrayList<>();
        while (resultSet.next()) {
            allAccounts.add(new Account(resultSet.getString("accountName")));
        }
        return allAccounts;
    }

    static boolean ascendingAccountTot_AmountInAccountTable(Account account) throws ClassNotFoundException, SQLException {
        String sql = "Update Account set accountTotal_Amount=accountTotal_Amount+? where accountName=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, account.getAccountTotal_Amount());
        statement.setObject(2, account.getAccountName());
        int addOrNot = statement.executeUpdate();
        return addOrNot > 0;
    }

    static boolean decendingTot_AmountInAccountTable(String account, double paymentAmount) throws ClassNotFoundException, SQLException {
        String sql = "Update Account set accountTotal_Amount=accountTotal_Amount-? where accountName=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, paymentAmount);
        statement.setObject(2, account);
        int addOrNot = statement.executeUpdate();
        return addOrNot > 0;
    }

    public static double getTotAmount(String account) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Account where accountName='" + account + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getDouble("accountTotal_Amount");
        } else {
            return 0;
        }
    }

    public static boolean transcationConfirming(String transcationFrom, String transcationTo, double amount) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Update Account set accountTotal_Amount=accountTotal_Amount-? where accountName=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, amount);
            statement.setObject(2, transcationFrom);
            int check = statement.executeUpdate();
            if (check > 0) {
                String sqlNext = "Update Account set accountTotal_Amount=accountTotal_Amount+? where accountName=?";
                PreparedStatement statementNext = connection.prepareStatement(sqlNext);
                statementNext.setObject(1, amount);
                statementNext.setObject(2, transcationTo);
                int checkNext = statementNext.executeUpdate();
                if (checkNext>0) {
                    connection.commit();
                    return true;
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
