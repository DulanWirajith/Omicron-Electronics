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
import omicron.model.Sup_Payment;

/**
 *
 * @author Dulan
 */
public class Sup_PaymentController {

    public static ArrayList<Sup_Payment> getPaymentsDetailsToOneSOID(String supply_orderId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Sup_Payment where supply_orderId='" + supply_orderId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Sup_Payment> allPaymentDetails = new ArrayList<>();

        while (resultSet.next()) {
            allPaymentDetails.add(new Sup_Payment(supply_orderId, resultSet.getString("sup_paymentId"), resultSet.getString("sup_paymentDate"), resultSet.getString("sup_paymentMethod"), resultSet.getString("sup_paymentCheckDate"), resultSet.getString("sup_paymentCheckNumber"), resultSet.getDouble("sup_paymentAmount")));
        }

        return allPaymentDetails;

    }

    public static boolean intoSup_PaymentTable(Sup_Payment payment) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into Sup_Payment values(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, payment.getSupply_orderId());
            statement.setObject(2, payment.getSup_paymentId());
            statement.setObject(3, payment.getSup_paymentDate());
            statement.setObject(4, payment.getSup_paymentMethod());
            statement.setObject(5, payment.getSup_paymentCheckDate());
            statement.setObject(6, payment.getSup_paymentCheckNumber());
            statement.setObject(7, payment.getSup_paymentAmount());
            int check = statement.executeUpdate();
            if (check > 0) {
                String account = payment.getAccount();
                double paymentAmount = payment.getSup_paymentAmount();
                boolean accountAddOrNot = AccountController.decendingTot_AmountInAccountTable(account, paymentAmount);
                if (accountAddOrNot) {
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
