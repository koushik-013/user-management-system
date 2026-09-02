package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class user_home extends JFrame implements ActionListener {

    JButton purchase;
    JButton view;
    JButton log_out;
    String customerID;

    user_home(String customerID) {
        this.customerID = customerID;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user_back.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        JLabel heading = new JLabel("User Home Page");
        heading.setBounds(200, 200, 600, 60);
        heading.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(heading);

        purchase = new JButton("Purchase Product");
        purchase.setBounds(200, 285, 150, 125);
        purchase.setForeground(Color.WHITE);
        purchase.setBackground(Color.RED);
        purchase.addActionListener(this);
        image.add(purchase);

        view = new JButton("Purchase Details");
        view.setBounds(420, 285, 150, 125);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.GREEN);
        view.addActionListener(this);
        image.add(view);

        log_out = new JButton("Log Out");
        log_out.setBounds(315, 450, 150, 40);
        log_out.setForeground(Color.WHITE);
        log_out.setBackground(Color.DARK_GRAY);
        log_out.addActionListener(this);
        image.add(log_out);

        setSize(900, 650);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == purchase) {
            setVisible(false);
            new purchage_product(customerID); // Pass the customerID to purchage_product
        } else if (e.getSource() == view) {
            setVisible(false);
            new purchase_details(customerID);
        } else if (e.getSource() == log_out) {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new user_home("testUser"); // Example usage with a test customerID
    }
}
