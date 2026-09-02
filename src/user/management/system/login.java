package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back, admin, signup, seller;

    login() {

        JLabel username = new JLabel("UserID");
        username.setBounds(40, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("EXIT");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        admin = new JButton("LOGIN as ADMIN");
        admin.setBounds(370, 300, 150, 30);
        admin.setBackground(Color.black);
        admin.setForeground(Color.WHITE);
        admin.addActionListener(this);
        add(admin);

        seller = new JButton("LOGIN as SELLER");
        seller.setBounds(370, 250, 150, 30);
        seller.setBackground(Color.black);
        seller.setForeground(Color.WHITE);
        seller.addActionListener(this);
        add(seller);

        signup = new JButton("Sign Up");
        signup.setBounds(90, 300, 150, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpeg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        imagee.setBounds(350, 10, 600, 400);
        add(imagee);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 400);
        add(image);

        setSize(600, 400);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            try {
                String empid = tusername.getText();
                String password = new String(tpassword.getPassword());

                conn conn = new conn();
                String query = "select * from user where username= '" + empid + "' and password= '" + password + "' and status ='true'";

                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {

                    setVisible(false);
                    new user_home(empid); // Pass the username to user_home
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(0);

        } else if (e.getSource() == admin) {
            setVisible(false);
            new admin_login();

        } else if (e.getSource() == signup) {
            setVisible(false);
            new registration();
        } else if (e.getSource() == seller) {
            setVisible(false);
            new seller_login();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
