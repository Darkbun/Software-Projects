package bank.management.system;


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import  java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JTextField pan, adhaar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, catergory, income, occupation, education;
    String formno;

    SignupTwo(String formno){

        this.formno = formno;
        setLayout(null);
        setTitle("New account application form - page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details " );
        additionalDetails.setFont(new Font("Raieway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raieway", Font.BOLD, 18));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Christan", "Sikh", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raieway", Font.BOLD, 18));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        catergory = new JComboBox(valCategory);
        catergory.setBounds(300, 190, 400, 30);
        catergory.setBackground(Color.WHITE);
        add(catergory);


        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raieway", Font.BOLD, 18));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raieway", Font.BOLD, 18));
        gender.setBounds(100,290,150,30);
        add(gender);
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raieway", Font.BOLD, 18));
        email.setBounds(100,315,200,30);
        add(email);

        String educationValues[] = {"Non-Graduate", "Graduate", "Post Graduate", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 300, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);



        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raieway", Font.BOLD, 18));
        marital.setBounds(100,365,200,30);
        add(marital);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 365, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raieway", Font.BOLD, 18));
        address.setBounds(100,425,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raieway", Font.BOLD, 14));
        pan.setBounds(300, 425, 400, 30);
        add(pan);


        JLabel city = new JLabel("Adhaar Number:");
        city.setFont(new Font("Raieway", Font.BOLD, 18));
        city.setBounds(100,480,200,30);
        add(city);

        adhaar = new JTextField();
        adhaar.setFont(new Font("Raieway", Font.BOLD, 14));
        adhaar.setBounds(300, 480, 400, 30);
        add(adhaar);


        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raieway", Font.BOLD, 18));
        state.setBounds(100,535,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 535, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 535, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);

        JLabel pincode = new JLabel("Exsisting Account:");
        pincode.setFont(new Font("Raieway", Font.BOLD, 18));
        pincode.setBounds(100,590,210,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup exAccGroup = new ButtonGroup();
        exAccGroup.add(eyes);
        exAccGroup.add(eno);



        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raieway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public static void main(String args[]) {
        new SignupTwo("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; //"+anything(long) = string
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) catergory.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String socuupation = (String) occupation.getSelectedItem();
        String sseniorcitizen = null;
        if(syes.isSelected()){
            sseniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            sseniorcitizen = "No";
        }

        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String sadhaar = adhaar.getText();


        try {
            Con c = new Con();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+socuupation+"', '"+span+"', '"+sadhaar+"', '"+sseniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
