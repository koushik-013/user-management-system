package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class add_admin extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back,add;

    add_admin(){


        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        add = new JButton("ADD ");
        add.setBounds(150,130,150,30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);






        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
        Image i2= i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,400);
        add(image);


        setSize(600,400);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){
            String username = tusername.getText();
            String password = tpassword.getText();

            try{
                conn c= new conn();
                String query = "insert into login values('" + username + "', '" + password + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Admin Added successful");
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong");
            }
            setVisible(false);
            new admin_login();
        } else if (e.getSource()==back) {
            setVisible(false);
            new admin_login();

        }


    }

    public static void main(String[] args) {

        new add_admin();

    }
}
