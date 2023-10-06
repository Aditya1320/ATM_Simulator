package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JButton signIn, signUp, reset;
    JTextField cardText;
    JPasswordField pinText;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(140, 110,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(110,20,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(220, 50, 400 , 40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(150, 140, 200 , 40);
        cardNo.setFont(new Font("Osward",Font.BOLD,28));
        add(cardNo);

         cardText = new JTextField();
        cardText.setBounds(300,145,230,30);
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        add(cardText);

        JLabel pin = new JLabel("Pin:");
        pin.setBounds(150, 200, 200 , 40);
        pin.setFont(new Font("Osward",Font.BOLD,28));
        add(pin);

         pinText = new JPasswordField();
        pinText.setBounds(300,205,230,30);
        pinText.setFont(new Font("Arial",Font.BOLD,14));
        add(pinText);

         signIn = new JButton("SIGN IN");
        signIn.setBounds(300,300,100,30);
        add(signIn);
        signIn.addActionListener(this);

         reset = new JButton("Reset");
        reset.setBounds(430,300,100,30);
        add(reset);
        reset.addActionListener(this);

         signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,230,30);
        add(signUp);
        signUp.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reset){
            cardText.setText("");
            pinText.setText("");

        } else if (e.getSource() == signIn) {
            DataConn con = new DataConn();
            String cardNumber = cardText.getText();
            String pinNumber = pinText.getText();
            String query = "Select * From login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
            try {
                ResultSet rs = DataConn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }

        } else if (e.getSource() == signUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }


    }
    public static void main(String arr[])
    {
        new Login();
    }


}
