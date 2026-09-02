package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpeg"));
        Image i2= i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading= new JLabel("User Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);

        JButton add =new JButton("Add User");
        add.setBounds(335,225,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new addemp();

            }
        });
        image.add(add);

        JButton view =new JButton("View User");
        view.setBounds(335,275,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new view_emp();

            }
        });
        image.add(view);

        JButton rem =new JButton("Remove User");
        rem.setBounds(335,325,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

               new remove_emp();
            }
        });
        image.add(rem);

        JButton adds =new JButton("Add Seller");
        adds.setBounds(525,225,150,40);
        adds.setForeground(Color.WHITE);
        adds.setBackground(Color.black);
        adds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new addseller();

            }
        });
        image.add(adds);

        JButton views =new JButton("View Seller");
        views.setBounds(525,275,150,40);
        views.setForeground(Color.WHITE);
        views.setBackground(Color.black);
        views.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new viewseller();

            }
        });
        image.add(views);

        JButton rems =new JButton("Remove Seller");
        rems.setBounds(525,325,150,40);
        rems.setForeground(Color.WHITE);
        rems.setBackground(Color.black);
        rems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                new remove_emp();
            }
        });
        image.add(rems);

        JButton logout =new JButton("Log Out");
        logout.setBounds(450,525,150,40);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.black);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();

            }
        });
        image.add(logout);






        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();

    }
}
