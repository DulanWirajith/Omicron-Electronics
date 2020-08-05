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
import omicron.model.Payment;

/**
 *
 * @author Dulan
 */
public class PaymentController {

    public static ArrayList<Payment> getInvoicePayment(String ordersId) throws ClassNotFoundException, SQLException {
        String sql = "Select * from Payment where ordersId='" + ordersId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Payment> allInvoicePayments = new ArrayList<>();
        while (resultSet.next()) {
            allInvoicePayments.add(new Payment(resultSet.getDouble("paymentAmount")));
        }
        return allInvoicePayments;
    }

    public static boolean intoPaymentTable(Payment payment) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into Payment values (?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, payment.getOrdersId());
            statement.setObject(2, payment.getAccountName());
            statement.setObject(3, payment.getPaymentId());
            statement.setObject(4, payment.getPaymentDate());
            statement.setObject(5, payment.getPaymentAmount());

            int paymentAddOrNot = statement.executeUpdate();
            if (paymentAddOrNot > 0) {
                boolean accountAddOrNot = AccountController.ascendingAccountTot_AmountInAccountTable(payment.getAccount());
                if (accountAddOrNot) {
                    connection.commit();
                    return true;
//                } else {
//                    connection.rollback();
                }
//            } else {
//                connection.rollback();
            }
            return false;
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
        }

    }

}
