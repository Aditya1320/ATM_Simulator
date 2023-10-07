package bank.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpOne extends JFrame implements ActionListener
{
    long random;
    JTextField nameText, fnameText, emailText, addressText, cityText, stateText,pinCodeText;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;


    SignUpOne() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO." +random);
        formNo.setFont(new Font("Releway", Font.BOLD,30));
        formNo.setBounds(160,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Releway", Font.BOLD,22));
        personalDetails.setBounds(250,80,400,30);
        add(personalDetails);

        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Releway", Font.BOLD,20));
        Name.setBounds(100,140,100,30);
        add(Name);

        nameText =new JTextField();
        nameText.setFont(new Font("Releway",Font.BOLD,14));
        nameText.setBounds(300,145,400,30);
        add(nameText);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Releway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameText =new JTextField();
        fnameText.setFont(new Font("Releway",Font.BOLD,14));
        fnameText.setBounds(300,195,400,30);
        add(fnameText);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Releway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser= new JDateChooser();
        dateChooser.setBounds(300,245,200,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Releway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,295,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400 , 295,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(500 , 295,70,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("Email Id:");
        email.setFont(new Font("Releway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailText =new JTextField();
        emailText.setFont(new Font("Releway",Font.BOLD,14));
        emailText.setBounds(300,345,400,30);
        add(emailText);

        JLabel maritial = new JLabel("Maritial Status:");
        maritial.setFont(new Font("Releway", Font.BOLD,20));
        maritial.setBounds(100,390,200,30);
        add(maritial);

        married = new JRadioButton("Married");
        married.setBounds(300,395,70,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,395,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritialGroup = new ButtonGroup();
        maritialGroup.add(married);
        maritialGroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Releway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressText =new JTextField();
        addressText.setFont(new Font("Releway",Font.BOLD,14));
        addressText.setBounds(300,445,400,30);
        add(addressText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Releway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityText =new JTextField();
        cityText.setFont(new Font("Releway",Font.BOLD,14));
        cityText.setBounds(300,495,400,30);
        add(cityText);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Releway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

         stateText =new JTextField();
        stateText.setFont(new Font("Releway",Font.BOLD,14));
        stateText.setBounds(300,545,400,30);
        add(stateText);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Releway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinCodeText =new JTextField();
        pinCodeText.setFont(new Font("Releway",Font.BOLD,14));
        pinCodeText.setBounds(300,595,400,30);
        add(pinCodeText);

        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Releway", Font.BOLD,14));
        next.setBounds(350,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,850);
        setLocation(350,10);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected())
        {
            gender = "Male";
        }
        else if (female.isSelected()) {
            gender = "Female";
            
        } else if (other.isSelected()) {
            gender = "Other";
        }
        String email = emailText.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if (unmarried.isSelected())
        {
            marital = "Unmarried";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinCodeText.getText();

        try
        {
            if (name.equals("") || fname.equals("") || dob.equals("") || gender==null || email.equals("") || marital==null || address.equals("") || city.equals("") || state.equals("") || pin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"All Fields Must Be Filled");
            }else {
                DataConn c = new DataConn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[]arr){
        new SignUpOne();

    }
}
