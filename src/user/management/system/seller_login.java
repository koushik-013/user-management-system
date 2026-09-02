package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class seller_login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back, signup;
    String storeName;

    seller_login() {
        JLabel username = new JLabel("SellerID");
        username.setBounds(240, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(350, 20, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(240, 70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(350, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(350, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(350, 180, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        signup = new JButton("Sign Up as SELLER");
        signup.setBounds(190, 300, 150, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seller_login.png"));
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
                String query = "SELECT * FROM seller WHERE username= '" + empid + "' AND password= '" + password + "' AND status = 'true'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    storeName = resultSet.getString("shop_name");
                    setVisible(false);
                    new seller(storeName);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new login();
        } else if (e.getSource() == signup) {
            setVisible(false);
            new seller_regi();
        }
    }

    public static void main(String[] args) {
        new seller_login();
    }
}
