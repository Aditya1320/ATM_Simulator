package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckBalance extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;
    CheckBalance(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(350,422,150,30);
        back.addActionListener(this);
        image.add(back);

        DataConn con = new DataConn();
        int balance = 0;
        try {
            ResultSet rs = con.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");

            while (rs.next()){
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Account Balance is Rs."+balance);
        text.setBounds(180,200,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("calibri", Font.BOLD, 20));
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String[]args){
        new CheckBalance("");
    }
}
