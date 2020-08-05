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
import omicron.model.Damage;
import omicron.model.Item;
import omicron.model.Sup_Returns;

/**
 *
 * @author Dulan
 */
public class DamageController {

    public static boolean intoDamageTable(Damage damage) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into Damage values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, damage.getBatchId());
            statement.setObject(2, damage.getDamageId());
            statement.setObject(3, damage.getSerial_num());
            statement.setObject(4, damage.getDamageDate());
            statement.setObject(5, damage.getDamageTotAmount());
            int check = statement.executeUpdate();
            if (check > 0) {
                Item item = ItemController.getFromItemTable(damage.getItemCode());
                String supplierId = item.getSupplierId();
                String batchId = damage.getBatchId();
                String serial_num = damage.getSerial_num();
                String itemCode = damage.getItemCode();

                Batch batch = BatchController.getFromBatchTable(batchId);
                double batchSellingPrice = batch.getBatchSellingPrice();
                String status = "NO";
                String desc = "From Damages";
                String returnDate = damage.getDamageDate();

                Sup_Returns returns = new Sup_Returns(supplierId, batchId, serial_num, itemCode, batchSellingPrice, status, desc, returnDate);
                boolean isAdded = Sup_ReturnsController.intoSup_ReturnsTable(returns);
                if (isAdded) {
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

    public static boolean intoDamageTablefromPhysicalDamages(Damage damage) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "Insert into Damage values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, damage.getBatchId());
            statement.setObject(2, damage.getDamageId());
            statement.setObject(3, damage.getSerial_num());
            statement.setObject(4, damage.getDamageDate());
            statement.setObject(5, damage.getDamageTotAmount());
            int check = statement.executeUpdate();
            if (check > 0) {
                boolean descFromAccount = AccountController.decendingTot_AmountInAccountTable("Income Account", damage.getDamageTotAmount());
                if (descFromAccount) {
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

    public static ArrayList<Damage> getFromDamageTableToInternalDamage() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Damage";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Damage> allDamages = new ArrayList<>();

        while (resultSet.next()) {
            if (resultSet.getDouble("damageTotAmount") == 0) {
                allDamages.add(new Damage(resultSet.getString("batchId"), resultSet.getString("damageId"), resultSet.getString("serial_num"), resultSet.getString("damageDate"), resultSet.getDouble("damageTotAmount")));
            }
        }
        return allDamages;
    }

    public static ArrayList<Damage> getFromDamageTableToPhysicalDamage() throws ClassNotFoundException, SQLException {
        String sql = "Select * from Damage";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Damage> allDamages = new ArrayList<>();

        while (resultSet.next()) {
            if (resultSet.getDouble("damageTotAmount") != 0) {
                allDamages.add(new Damage(resultSet.getString("batchId"), resultSet.getString("damageId"), resultSet.getString("serial_num"), resultSet.getString("damageDate"), resultSet.getDouble("damageTotAmount")));
            }
        }
        return allDamages;
    }

}
