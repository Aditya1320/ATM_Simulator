package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener
{

    JTextField panText, aadharText, phoneNoText;
    JButton next;
    JComboBox religionbox, categorybox, qalificationbox, occupationbox, incomebox;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Releway", Font.BOLD,22));
        additionalDetails.setBounds(250,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Releway", Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String religionval[] = {"Hindu", "Christian", "Muslim", "Sikh", "Islam","Other"};
        religionbox = new JComboBox(religionval);
        religionbox.setBounds(300,145,400,30);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);

        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Releway", Font.BOLD,20));
        category.setBounds(100,200,200,30);
        add(category);

        String categoryval[] = {"General","OBC","SC","ST","Other"};
        categorybox = new JComboBox(categoryval);
        categorybox.setFont(new Font("Releway",Font.BOLD,14));
        categorybox.setBounds(300,205,400,30);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);

        JLabel qualification = new JLabel("Qualification :");
        qualification.setFont(new Font("Releway", Font.BOLD,20));
        qualification.setBounds(100,260,200,30);
        add(qualification);

        String qualificationval[] = {"12TH Pass","Graduate","Post-Graduate","Doctorate","Other"};
        qalificationbox = new JComboBox(qualificationval);
        qalificationbox.setBounds(300,265,400,30);
        qalificationbox.setBackground(Color.WHITE);
        add(qalificationbox);

        JLabel occupation  = new JLabel("Occupation :");
        occupation.setFont(new Font("Releway", Font.BOLD,20));
        occupation.setBounds(100,320,200,30);
        add(occupation);

        String occupationval[] = {"Student","Unemployed","Employee","Bussiness","Retired","Other"};
        occupationbox = new JComboBox(occupationval);
        occupationbox.setBounds(300,325,400,30);
        occupationbox.setBackground(Color.WHITE);
        add(occupationbox);


        JLabel email = new JLabel("Income :");
        email.setFont(new Font("Releway", Font.BOLD,20));
        email.setBounds(100,380,200,30);
        add(email);

        String incomeval[] = {"Null","< 3,00,000","< 6,00,00","< 9,00,000","Above 9,00,000 "};
        incomebox = new JComboBox<>(incomeval);
        incomebox.setFont(new Font("Releway",Font.BOLD,14));
        incomebox.setBounds(300,385,400,30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);

        JLabel pancard = new JLabel("Pan-Card No. :");
        pancard.setFont(new Font("Releway", Font.BOLD,20));
        pancard.setBounds(100,440,200,30);
        add(pancard);

        panText =new JTextField();
        panText.setFont(new Font("Releway",Font.BOLD,14));
        panText.setBounds(300,445,400,30);
        add(panText);

        JLabel aadhar = new JLabel("Aadhar card No. :");
        aadhar.setFont(new Font("Releway", Font.BOLD,20));
        aadhar.setBounds(100,500,200,30);
        add(aadhar);

        aadharText =new JTextField();
        aadharText.setFont(new Font("Releway",Font.BOLD,14));
        aadharText.setBounds(300,505,400,30);
        add(aadharText);

        JLabel city = new JLabel("Phone No. :");
        city.setFont(new Font("Releway", Font.BOLD,20));
        city.setBounds(100,560,200,30);
        add(city);

        phoneNoText =new JTextField();
        phoneNoText.setFont(new Font("Releway",Font.BOLD,14));
        phoneNoText.setBounds(300,565,400,30);
        add(phoneNoText);

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

        String religion = (String) religionbox.getSelectedItem();
        String category = (String) categorybox.getSelectedItem();
        String qualification = (String) qalificationbox.getSelectedItem();
        String occupation = (String) occupationbox.getSelectedItem();
        String income = (String) incomebox.getSelectedItem();
        String pancard = panText.getText();
        String aadharcard = aadharText.getText();
        String phoneNo = phoneNoText.getText();

        try
        {
            if (pancard.equals("") || aadharcard.equals("") || phoneNo.equals("") )
            {
                JOptionPane.showMessageDialog(null,"All Fields Must Be Filled");
            }else {
                DataConn c = new DataConn();
                String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+qualification+"','"+occupation+"','"+income+"','"+pancard+"','"+aadharcard+"','"+phoneNo+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[]arr){
        new SignUpTwo("");

    }
}
