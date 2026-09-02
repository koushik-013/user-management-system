package user.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addseller extends JFrame implements ActionListener {

    Random ran = new Random();
    int number= ran.nextInt(999999);
    JTextField tname, tfname, taddress,tphone, tnid, temail, tsalary,tdesignation,tshop,tstatus;
    JLabel tempid;

    JDateChooser tdob;
    JComboBox Boxeducation;

    JButton add,back;

    addseller(){

        getContentPane().setBackground(new Color(163,255,188));



        JLabel heading= new JLabel("Add Seller Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel empid = new JLabel("User ID");
        empid.setBounds(50,150,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel(""+number);
        tempid.setBounds(200,150,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel name = new JLabel("Password");
        name.setBounds(400,150,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(name);

        tname = new JTextField();
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



        JLabel salary = new JLabel("Address");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Email");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel status = new JLabel("Shop Name");
        status.setBounds(400,250,150,30);
        status.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(status);

        tstatus = new JTextField();
        tstatus.setBounds(600,250,150,30);
        tstatus.setBackground(new Color(177,252,197));
        add(tstatus);

        JLabel shop = new JLabel("Shop Name");
        shop.setBounds(50,300,150,30);
        shop.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(shop);

        tshop= new JTextField();
        tshop.setBounds(200,300,150,30);
        tshop.setBackground(new Color(177,252,197));
        add(tshop);




        add = new JButton("ADD");
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
        setLocation(300,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add){
            String userid = tempid.getText();
            String password = tname.getText();
            // String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String phone = tfname.getText();
            String address = tsalary.getText();

            String email = taddress.getText();
            String status = tstatus.getText();
            String shop= tshop.getText();
//            String nid = tnid.getText();
//            String phone = tphone.getText();
//            String email = temail.getText();
//            String education = (String) Boxeducation.getSelectedItem();
//            String designation = tdesignation.getText();
//            String empID = tempid.getText();

            try{
                conn c = new conn();
                String query = "insert into seller values('"+userid+"', '"+password+"', '"+phone+"', '"+address+"', '"+email+"', '"+status+"', '"+shop+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
            new Main_class();
        }


    }

    public static void main(String[] args) {
        new addseller();
    }
}
