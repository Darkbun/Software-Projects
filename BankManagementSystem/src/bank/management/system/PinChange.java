package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(250,300,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New pin");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        pintext.setBounds(165,340,180,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raieway", Font.BOLD, 25));
        pin.setBounds(330,340,180,25);
        image.add(pin);


        JLabel repintext = new JLabel("Re-enter new pin");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        repintext.setBounds(165,370,180,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raieway", Font.BOLD, 25));
        repin.setBounds(330,370,180,25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public  static void main(String a[]){
        new PinChange("").setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter new pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter the new pin");
                    return;
                }

                Con con = new Con(); // pin is in three places, signupthree, login and bank. So we have to write three queries
                String query1 = "update bank set pin = '"+npin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+npin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+npin+"' where pin = '"+pinnumber+"'";

                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }
}

