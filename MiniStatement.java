package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pinNUmber;
    MiniStatement(String pinNumber){
        this.pinNUmber = pinNumber;
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,300);
        add(mini);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try {
            DataConn con = new DataConn();
            ResultSet rs = con.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4) + "xxxxxxxx" + rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            DataConn con = new DataConn();
            int bal = 0;
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                {
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Account Balance is Rs." + bal);
        }catch (Exception e)
        {
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[]args){
        new MiniStatement("");
    }
}
