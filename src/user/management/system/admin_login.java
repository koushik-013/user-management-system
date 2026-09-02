package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class admin_login extends JFrame implements ActionListener{

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back,add;

    admin_login(){
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

        login = new JButton("LOGIN");
        login.setBounds(150,120,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150,160,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        add = new JButton("ADD an ADMIN");
        add.setBounds(400,200,150,30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);




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

        if(e.getSource() == login){

            try{
                String username= tusername.getText();
                String password= tpassword.getText();

                conn conn = new conn();
                String query= "select * from login where username= '"+username+"' and password= '"+password+"'";
                ResultSet resultSet=conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else{
                    JOptionPane.showMessageDialog(null,"invalid username or password");
                }

            }catch(Exception E){
                E.printStackTrace();

            }

        } else if (e.getSource()==back) {
            setVisible(false);
            new login();

        }else if(e.getSource()==add){
            setVisible(false);
            new add_admin();
        }


    }

    public static void main(String[] args) {
        new admin_login();

    }

}
