package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton amt1, amt2, amt3, amt4, amt5, amt6, back;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(225,150,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("calibri", Font.BOLD, 16));
        image.add(text);

        amt1 = new JButton("Rs.100");
        amt1.setBounds(150,290,150,30);
        amt1.addActionListener(this);
        image.add(amt1);

        amt2 = new JButton("Rs.500");
        amt2.setBounds(350,290,150,30);
        amt2.addActionListener(this);
        image.add(amt2);

        amt3 = new JButton("Rs.1000");
        amt3.setBounds(150,335,150,30);
        amt3.addActionListener(this);
        image.add(amt3);

        amt4 = new JButton("Rs.2000");
        amt4.setBounds(350,335,150,30);
        amt4.addActionListener(this);
        image.add(amt4);

        amt5 = new JButton("Rs.5000");
        amt5.setBounds(150,380,150,30);
        amt5.addActionListener(this);
        image.add(amt5);

        amt6 = new JButton("Rs.10000");
        amt6.setBounds(350,380,150,30);
        amt6.addActionListener(this);
        image.add(amt6);

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
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            DataConn con = new DataConn();
            try {
                ResultSet rs = con.s.executeQuery("Select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while (rs.next()){
                 if(rs.getString("type").equals("Deposit"))
                 {
                     balance+=Integer.parseInt(rs.getString("amount"));
                 }else {
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }
                }
                if(ae.getSource()!= back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'withdrawal','"+ amount +"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[])
    {

        new FastCash("");
    }
}
