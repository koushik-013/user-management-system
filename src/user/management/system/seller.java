package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class seller extends JFrame implements ActionListener {
    String storeName;

    seller(String storeName) {
        this.storeName = storeName;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seller_back.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel heading = new JLabel("Seller Home");
        heading.setBounds(150, 50, 400, 60);
        heading.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(heading);

        JButton add = new JButton("Add Product");
        add.setBounds(80, 150, 150, 150);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.red);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new add_product(storeName);
            }
        });
        image.add(add);

        JButton view = new JButton("View Products");
        view.setBounds(300, 150, 150, 150);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.green);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new view_product(storeName);
            }
        });
        image.add(view);

        JButton view_product = new JButton("View Orders");
        view_product.setBounds(80, 325, 150, 150);
        view_product.setForeground(Color.WHITE);
        view_product.setBackground(Color.gray);
        view_product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new view_orders(storeName);
            }
        });
        image.add(view_product);

        JButton refund = new JButton("Returns");
        refund.setBounds(300, 325, 150, 150);
        refund.setForeground(Color.WHITE);
        refund.setBackground(Color.blue);
        refund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new returms(storeName);
            }
        });
        image.add(refund);

        JButton log_out = new JButton("Log Out");
        log_out.setBounds(200, 550, 150, 40);
        log_out.setForeground(Color.WHITE);
        log_out.setBackground(Color.darkGray);
        log_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();
            }
        });
        image.add(log_out);

        setSize(900, 700);
        setLocation(290, 90);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new seller("");
    }
}
