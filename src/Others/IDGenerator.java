/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author Dulan
 */
public class IDGenerator {
    
    public static String getNewID(String tableName, String colName, String prifix) throws ClassNotFoundException, SQLException {
        String lastId = IDController.getLastID(tableName, colName);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prifix)[1]);
           // System.out.println(id);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(5);
            numberFormat.setGroupingUsed(false);
            String newID = numberFormat.format(id);
            return prifix + newID;
        } else {
            return prifix + "001";
        }

    }
}
