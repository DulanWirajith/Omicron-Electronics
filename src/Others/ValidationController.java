/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dulan
 */
public class ValidationController {

    public static void validateNic(JTextField nicTxt) {
        String nic = nicTxt.getText().replaceAll("[\\D&&[^vV]]", "");
        nic = nic.toUpperCase();
        int index = nic.indexOf("V");
        if (index != 9 && index != -1) {
            JOptionPane.showMessageDialog(null, "Invalid Nic");
            if (nic.length() > 9) {
                nic = "";
            } else {
                nic = nic.substring(0, nic.length() - 1);
            }
        }
        if (nic.length() > 10) {
            nic = nic.substring(0, 10);
        }
        if (nic.length() == 9) {
            nic = nic + "V";
        }
        nicTxt.setText(nic);
    }

    public static void checkNic(JTextField nicText, JTextArea request) {
        if (!(nicText.getText().trim().matches("^[0-9]{9}[vVxX]$"))) {
            JOptionPane.showMessageDialog(null, "Invalid NIC ");
        } else {
            request.requestFocus();
        }

    }

    public static boolean checkNic(JTextField nicText) {
        if (!(nicText.getText().trim().matches("^[0-9]{9}[vVxX]$"))) {
            JOptionPane.showMessageDialog(null, "Invalid NIC ");
            return false;
        } else {
            return true;
        }

    }

    public static void checkNicNumberCount(JTextField nicText) {
        String nic = nicText.getText();

        if (nic.length() == 9) {
            nic = nic + "V";
        }
        nicText.setText(nic);
    }

    public static boolean validateTel(JTextField telText) {
        String tel = telText.getText();
        tel = tel.replaceAll("[\\D]", "");
        if (tel.length() > 10) {
            tel = tel.substring(0, 10);
            telText.setText(tel);
            return true;
        }
        telText.setText(tel);
        return false;
    }

    /**
     * Validation text to accept letters only
     */
    public static void name(JTextField textField) {
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[A-Za-z// ]*$")) {
            textField.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
            textField.setCaretPosition(caretPosition - 1);
        }
    }

    /**
     * Validation text to accept numbers only
     */
    public static void numberOnly(JTextField textField) {
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[\\d]*")) {
            textField.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
            textField.setCaretPosition(caretPosition - 1);
        }
    }

    /**
     * Validation text to accept old NIC
     */
    public static void vailidateQty(JTextField qtyText) {
        String qty = qtyText.getText();
        qty = qty.replaceAll("[\\D]", "");
        if (qty.length() > 5) {
            qty = qty.substring(0, 5);
        }
        qtyText.setText(qty);
    }

    /**
     * Validation text to accept Email
     */
    public static void validationEmail(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("^[(a-zA-Z-0-9-\\\\_\\\\+\\\\.)]+@[(a-z-A-z)]+\\\\.[(a-zA-z)]{2,3}$");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    /**
     * Validation text to accept a mobile number
     *
     * @param textField
     * @param evt
     */
    public static void phoneNumber(JTextField textField, KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
        }
        String txt = textField.getText();
        int caretPosition = textField.getCaretPosition();
        if (!txt.matches("^[0-9]{0,10}$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textField.setText(txt);
            textField.setCaretPosition(caretPosition - 1);
        }

    }

    /**
     * Validation text to accept a price
     */
    public static boolean priceText(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("^[1-9]\\d{0,7}(?:\\.\\d{2})?$");
            if (res) {
//                textField.setText(text.substring(0, text.length() - 1));
                
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error in your inserted Price..\nPrice format must be xxxx.xx");
                return false;
            }
        } else {
            return false;
        }

    }

//    public static void priceText(JTextField textField) {
//        String text = textField.getText();
//        if (!text.isEmpty()) {
//            boolean res = text.matches("[0-9]+([.][0-9]{1,2})?");
//            if (!res) {
//                textField.setText(text.substring(0, text.length() - 1));
//            }
//        }
//    }
    public static void vailidatePrice(JTextField priceText) {
        String price = priceText.getText();
        price = price.replaceAll("[\\D]", "");
        if (price.length() > 5) {
            price = price.substring(0, 5);
        }
        priceText.setText(price);
    }

    public static void vailidateDiscount(JTextField discountText) {
        String discount = discountText.getText();
        discount = discount.replaceAll("[\\D]", "");
        if (discount.length() > 2) {
            discount = discount.substring(0, 2);
        }
        discountText.setText(discount);
    }

    public static void vailidateTotal(JTextField totalText) {
        String total = totalText.getText();
        total = total.replaceAll("[\\D]", "");
        if (total.length() > 7) {
            total = total.substring(0, 7);
        }
        totalText.setText(total);
    }

    public static void validateAmount(JTextField amountText) {
        String amount = amountText.getText();
        amount = amount.replaceAll("[\\D]", "");
        if (amount.length() > 8) {
            amount = amount.substring(0, 8);
        }
        amountText.setText(amount);
    }

    public static void validateChequeNoumber(JTextField chequeNoumberText) {
        String chequeNoumber = chequeNoumberText.getText();
        chequeNoumber = chequeNoumber.replaceAll("[\\D]", "");
        if (chequeNoumber.length() > 14) {
            chequeNoumber = chequeNoumber.substring(0, 14);
        }
        chequeNoumberText.setText(chequeNoumber);
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

//    
//    public static boolean isValidEmail(String enteredEmail){
//        String EMAIL_REGIX = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
//        Pattern pattern = Pattern.compile(EMAIL_REGIX);
//        Matcher matcher = pattern.matcher(enteredEmail);
//        return ((!enteredEmail.isEmpty()) && (enteredEmail!=null) && (matcher.matches()));
//    }
    public static void NumbersAndDotOnly(KeyEvent evt) {
        char c = evt.getKeyChar();
//        if (!(Character.isDigit(c) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
//            evt.consume();
//        }
        if (!(Character.isDigit(c) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();

        }
    }
}
