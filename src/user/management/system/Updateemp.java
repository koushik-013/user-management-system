package user.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updateemp extends JFrame implements ActionListener {

    JTextField teducation, tfname, taddress,tphone, tnid, temail, tsalary,tdesignation;
    JLabel tempid;
    JButton add,back;
    String number;
    Updateemp(String number){

        this.number = number;
        getContentPane().setBackground(new Color(163,255,188));



        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,25));
        add(heading);

        JLabel empid = new JLabel("User ID");
        empid.setBounds(50,150,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel();
        tempid.setBounds(200,150,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel name = new JLabel("Password");
        name.setBounds(400,150,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(600,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Phone");
        fname.setBounds(50,200,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(200,200,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel address = new JLabel("Address");
        address.setBounds(400,200,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(600,200,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel salary = new JLabel("Email");
        salary.setBounds(50,250,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(200,250,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);


//
//
        JLabel phone = new JLabel("status");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);
//
//        JLabel email = new JLabel("Email");
//        email.setBounds(50,300,150,30);
//        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
//        add(email);
//
//        temail= new JTextField();
//        temail.setBounds(200,300,150,30);
//        temail.setBackground(new Color(177,252,197));
//        add(temail);
//
//        JLabel education = new JLabel("Higest Education");
//        education.setBounds(400,300,150,30);
//        education.setFont(new Font("SAN_SERIF", Font.BOLD,20));
//        add(education);
//
//        teducation= new JTextField();
//        teducation.setBounds(600,300,150,30);
//        teducation.setBackground(new Color(177,252,197));
//        add(teducation);
//
//        JLabel nid = new JLabel("NID");
//        nid.setBounds(400,350,150,30);
//        nid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
//        add(nid);
//
//        JLabel tnid= new JLabel();
//        tnid.setBounds(600,350,150,30);
//        tnid.setBackground(new Color(177,252,197));
//        add(tnid);
//
//
//
//
//        JLabel designation = new JLabel("Designation");
//        designation.setBounds(50,350,150,30);
//        designation.setFont(new Font("SAN_SERIF", Font.BOLD,20));
//        add(designation);
//
//        tdesignation= new JTextField();
//        tdesignation.setBounds(200,350,150,30);
//        tdesignation.setBackground(new Color(177,252,197));
//        add(tdesignation);

        try {
            conn c = new conn();
            String query = "select * from user where username = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tempid.setText(resultSet.getString("username"));

                tname.setText(resultSet.getString("password"));
                tfname.setText(resultSet.getString("phone"));
                //tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("empid"));
                tphone.setText(resultSet.getString("status"));
//                temail.setText(resultSet.getString("email"));
//                teducation.setText(resultSet.getString("education"));
//                tnid.setText(resultSet.getString("nid"));
//                tdesignation.setText(resultSet.getString("designation"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add){
            String phone = tfname.getText();
            String address = tsalary.getText();
            String email = taddress.getText();
            String status = tphone.getText();
//            String email = temail.getText();
//            String education = teducation.getText();
//            String designation = tdesignation.getText();

            try {
                conn c = new conn();
                String query = "update user set phone = '"+phone+"', address = '"+email+"', empid = '"+address+"', status = '"+status+"' where username = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new view_emp();
        }


    }

    public static void main(String[] args) {
        new Updateemp("");
    }
}
