package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener
{
    JTextField amount;
    JButton deposit,back;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter amount to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(225,160,700,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(150,235,350,25);
        amount.addActionListener(this);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(350,380,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(350,422,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount to Deposit");
            }else {
               try {
                   DataConn con = new DataConn();
                   String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Deposit','"+ number +"')";
                   DataConn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs."+number+" Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinNumber).setVisible(true);
               }catch (Exception e){
                   System.out.println(e);
               }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String []args){
        new Deposit("");
    }
}
