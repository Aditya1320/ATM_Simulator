package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin, rpin;
    JButton confirm,back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your PIN");
        text.setBounds(250,130,180,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel newPin = new JLabel("New PIN:");
        newPin.setBounds(130,190,180,25);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System", Font.BOLD, 16));
        image.add(newPin);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(290,190,210,25);
        image.add(pin);

        JLabel rePin = new JLabel("Re-Enter New PIN:");
        rePin.setBounds(130,230,180,25);
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System", Font.BOLD, 16));
        image.add(rePin);

        rpin = new JPasswordField();
        rpin.setFont(new Font("Raleway",Font.BOLD,16));
        rpin.setBounds(290,230,210,25);
        image.add(rpin);

        confirm = new JButton("Confirm");
        confirm.setBounds(350,380,150,30);
        confirm.addActionListener(this);
        image.add(confirm);

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
        if(ae.getSource() == confirm){
            try{
                String npin = pin.getText();
                String repin = rpin.getText();

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
                    return;
                }
                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }

                DataConn con = new DataConn();
                String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pinNumber = '"+repin+"' where pinNumber = '"+pinNumber+"'";
                String query3 = "update signupthree set pinNumber = '"+repin+"' where pinNumber = '"+pinNumber+"'";

                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                setVisible(false);
                new Transactions(pinNumber);

            }catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new PinChange("");
    }
}
