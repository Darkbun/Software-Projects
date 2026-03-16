package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {

        this.pinnumber = pinnumber;
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Inside Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400,300,20);
        add(balance);

        try {
            Con con = new Con();
            ResultSet rs = con.s.executeQuery("select * from login where pin = '"+pinnumber+"'");

            while (rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));

            }


        } catch (Exception e){
            System.out.println(e);
        }

        try{
            Con con = new Con();
            int balance1 = 0;
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    balance1 += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance1 -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your current account balance is Rs "+ balance1);

        } catch(Exception e1) {
            System.out.println(e1);
        }

        mini.setBounds(20,140,400,200);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String a[]) {
        new MiniStatement("");
    }

}
