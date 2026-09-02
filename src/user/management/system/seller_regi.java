package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class seller_regi extends JFrame implements ActionListener {


    JTextField tusername;
    JPasswordField tpassword;
    JTextField taddress;
    JTextField tphone;
    JTextField totp;
    JTextField tuserid;
    JTextField tshop;

    JLabel otp;

    JButton sign_up, login, verify,seller;

    seller_regi(){

        JLabel username = new JLabel("UserID(6 digit)");
        username.setBounds(40, 50, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 50, 150, 30);
        add(tusername);

            JLabel password = new JLabel("Password");
            password.setBounds(40, 100, 100, 30);
            add(password);

            tpassword = new JPasswordField();
            tpassword.setBounds(150, 100, 150, 30);
            add(tpassword);

            JLabel address = new JLabel("Address");
            address.setBounds(40, 150, 100, 30);
            add(address);

            taddress = new JTextField();
            taddress.setBounds(150, 150, 150, 30);
            add(taddress);

            JLabel phone = new JLabel("Phone");
            phone.setBounds(40, 200, 100, 30);
            add(phone);

            tphone = new JTextField();
            tphone.setBounds(150, 200, 150, 30);
            add(tphone);

            JLabel id = new JLabel("Email");
            id.setBounds(40, 250, 100, 30);
            add(id);

            tuserid = new JTextField();
            tuserid.setBounds(150, 250, 150, 30);
            add(tuserid);

        JLabel shop = new JLabel("Shop Name");
        shop.setBounds(40, 300, 100, 30);
        add(shop);

        tshop = new JTextField();
        tshop.setBounds(150, 300, 150, 30);
        add(tshop);

            sign_up = new JButton("SIGN UP");
            sign_up.setBounds(70, 350, 150, 30);
            sign_up.setBackground(Color.black);
            sign_up.setForeground(Color.WHITE);
            sign_up.addActionListener(this);
            add(sign_up);

            login = new JButton("LOGIN");
            login.setBounds(270, 350, 150, 30);
            login.setBackground(Color.black);
            login.setForeground(Color.WHITE);
            login.addActionListener(this);
            add(login);

        seller = new JButton("Back");
        seller.setBounds(425, 500, 150, 30);
        seller.setBackground(Color.black);
        seller.setForeground(Color.WHITE);
        seller.addActionListener(this);
        add(seller);

            otp = new JLabel("OTP");
            otp.setBounds(40, 450, 100, 30);
            add(otp);

            totp = new JTextField();
            totp.setBounds(150, 450, 150, 30);
            add(totp);
            otp.setVisible(false);
            totp.setVisible(false);

            verify = new JButton("VERIFY");
            verify.setBounds(70, 500, 150, 30);
            verify.setBackground(Color.black);
            verify.setForeground(Color.WHITE);
            verify.addActionListener(this);
            add(verify);
            verify.setVisible(false);


            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/regis.jpg"));
            Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 600, 600);
            add(image);

            JLabel heading = new JLabel("Sign UP as A Seller");
            heading.setBounds(100, 0, 400, 40);
            heading.setFont(new Font("Raleway", Font.BOLD, 25));
            image.add(heading);

            setSize(600, 600);
            setLocation(450, 150);
            setLayout(null);
            setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == login) {


            setVisible(false);
            new login();


        } else if (e.getSource() == sign_up) {
            String username = tusername.getText();
            String password = tpassword.getText();
            String phone = tphone.getText();
            String address = taddress.getText();
            String emp_id = tuserid.getText();
            if (username.isEmpty() || password.isEmpty() || phone.isEmpty() || address.isEmpty() ||emp_id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all fields");
            }

            else{
                verify.setVisible(true);
                otp.setVisible(true);
                totp.setVisible(true);
                JOptionPane.showMessageDialog(null, "To authenticate and verify your account, please check your email inbox where you will find a One-Time Password (OTP) sent to you.");

                tusername.setEnabled(false);
                tpassword.setEnabled(false);
                tphone.setEnabled(false);
                taddress.setEnabled(false);
                tuserid.setEnabled(false);
                try {
                    OTPGenerator obj1 = new OTPGenerator();
                    String generatedOTP = obj1.generateOTP(emp_id);
                    Mailer obj = new Mailer();
                    final String from = "koushik0001@std.bdu.ac.bd";
                    final String epassword = "jfjxzuutfuajolui";

                    String to = emp_id;
                    String sub = "User Verification";
                    String msg = "Your user verification Otp is " + generatedOTP;
                    obj.send(from, epassword, to, sub, msg);

                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, E);
                }
            }




        } else if (e.getSource() == verify)
        {

            String email = tuserid.getText();
            String enteredOTP = totp.getText();
            OTPGenerator obj = new OTPGenerator();

            if (obj.validateOTP(email, enteredOTP)) {
                JOptionPane.showMessageDialog(null, "Account Verified");

                String username = tusername.getText();
                String password = tpassword.getText();

                String phone = tphone.getText();
                String address = taddress.getText();
                String emp_id = tuserid.getText();
                String status = "false";
                String shop = tshop.getText();

                try {
                    conn c = new conn();
                    String query = "insert into seller values('" + username + "', '" + password + "', '" + phone + "', '" + address + "','" + emp_id + "','" + status + "','" + shop + "')";
                   c.statement.executeUpdate(query);



                    JOptionPane.showMessageDialog(null, "Account Created successful");
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, "Account not Created Successful. Wait For Admin to Approve You");

                }


            }
            setVisible(false);
            new login();
        } else if (e.getSource()==seller) {
            setVisible(false);
            new seller_regi();

        }

    }

    public static void main(String[] args) {

        new seller_regi();

    }
}
