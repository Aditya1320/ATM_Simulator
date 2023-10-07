package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener
{
    JRadioButton btn1, btn2, btn3, btn4;
    JCheckBox ch1, ch2, ch3, ch4, ch5, ch6;
    JButton submit, cancel;
    String formno;

    SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Releway", Font.BOLD,30));
        accountDetails.setBounds(215,20,600,40);
        add(accountDetails);

        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Releway", Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);

        btn1 = new JRadioButton("Saving Account");
        btn1.setFont(new Font("Releway", Font.BOLD,16));
        btn1.setBackground(Color.white);
        btn1.setBounds(100,180,200,30);
        add(btn1);

        btn2 = new JRadioButton("Current Account");
        btn2.setFont(new Font("Releway", Font.BOLD,16));
        btn2.setBackground(Color.WHITE);
        btn2.setBounds(350,180,250,30);
        add(btn2);

        btn3 = new JRadioButton("Fixed Deposit Account");
        btn3.setFont(new Font("Releway", Font.BOLD,16));
        btn3.setBackground(Color.WHITE);
        btn3.setBounds(100,220,250,30);
        add(btn3);

        btn4 = new JRadioButton("Recurring Deposit Account");
        btn4.setFont(new Font("Releway", Font.BOLD,16));
        btn4.setBackground(Color.WHITE);
        btn4.setBounds(350,220,250,30);
        add(btn4);

        ButtonGroup accountType = new ButtonGroup();
        accountType.add(btn1);
        accountType.add(btn2);
        accountType.add(btn3);
        accountType.add(btn4);

        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Releway", Font.BOLD,20));
        card.setBounds(100,280,200,30);
        add(card);

        JLabel num1 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        num1.setFont(new Font("Releway", Font.BOLD,20));
        num1.setBounds(300,280,300,30);
        add(num1);

        JLabel pin = new JLabel("Pin Number:");
        pin.setFont(new Font("Releway", Font.BOLD,20));
        pin.setBounds(100,340,200,30);
        add(pin);

        JLabel num2 = new JLabel("XXXX");
        num2.setFont(new Font("Releway", Font.BOLD,20));
        num2.setBounds(300,340,300,30);
        add(num2);

        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Releway", Font.BOLD,20));
        service.setBounds(100,400,400,30);
        add(service);

        ch1 = new JCheckBox("ATM Card");
        ch1.setFont(new Font("Releway", Font.BOLD,16));
        ch1.setBackground(Color.WHITE);
        ch1.setBounds(100,450,200,30);
        add(ch1);

        ch2 = new JCheckBox("Internet Banking");
        ch2.setFont(new Font("Releway", Font.BOLD,16));
        ch2.setBackground(Color.WHITE);
        ch2.setBounds(350,450,200,30);
        add(ch2);

        ch3 = new JCheckBox("Passbook");
        ch3.setFont(new Font("Releway", Font.BOLD,16));
        ch3.setBackground(Color.WHITE);
        ch3.setBounds(100,500,200,30);
        add(ch3);

        ch4 = new JCheckBox("Cheque Book");
        ch4.setFont(new Font("Releway", Font.BOLD,16));
        ch4.setBackground(Color.WHITE);
        ch4.setBounds(350,500,200,30);
        add(ch4);

        ch5 = new JCheckBox("SMS Alerts");
        ch5.setFont(new Font("Releway", Font.BOLD,16));
        ch5.setBackground(Color.WHITE);
        ch5.setBounds(100,550,200,30);
        add(ch5);

        ch6 = new JCheckBox("I hereby declare that the above information is true and correct to the best of my knowledge and belief.");
        ch6.setFont(new Font("Releway", Font.BOLD,12));
        ch6.setBackground(Color.WHITE);
        ch6.setBounds(100,620,600,30);
        add(ch6);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Releway", Font.BOLD,16));
        submit.setBounds(250,690,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Releway", Font.BOLD,16));
        cancel.setBounds(400,690,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,850);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String accountType = null;
            if(btn1.isSelected())
            {
                accountType = "Saving Account";

            } else if (btn2.isSelected())
            {
                accountType = "Current Account";

            } else if (btn3.isSelected())
            {
                accountType = "Fixed Deposit Account";

            } else if (btn4.isSelected())
            {
                accountType = "Recurring Deposit Account";

            }
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 9000000000L) + 8087490000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (ch1.isSelected())
            {
                facility = facility + " ATM Card";
            } else if (ch2.isSelected())
            {
                facility = facility + " Internet Banking";
            } else if (ch3.isSelected())
            {
                facility = facility + " Passbook";
            } else if (ch4.isSelected())
            {
                facility = facility + " Cheque Book";
            } else if (ch5.isSelected())
            {
                facility = facility + " SMS Alerts";
            }

            try {
                if (accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }
                else {
                    DataConn c = new DataConn();
                    String query = "insert into signupthree values('"+formno+"', '"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\n Pin: "+pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            } catch (Exception e)
            {
              System.out.println(e);
            }

        }
        else if (ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[]arr){
        new SignUpThree("");

    }
}
