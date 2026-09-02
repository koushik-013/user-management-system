package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_orders extends JFrame implements ActionListener {

    JTextField  tphone;
    JLabel tempid, tname,tfname, taddress,tsalary,tshop;
    JButton add, back;
    String number;
    String shop_name;

    update_orders(String number) {

        this.number = number;
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update Seller Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel empid = new JLabel("Product ID");
        empid.setBounds(50, 150, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 150, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel name = new JLabel("Name");
        name.setBounds(400, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(600, 150, 150, 30);
        tname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(tname);

        JLabel fname = new JLabel("Price");
        fname.setBounds(50, 200, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JLabel();
        tfname.setBounds(200, 200, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel address = new JLabel("Category");
        address.setBounds(400, 200, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JLabel();
        taddress.setBounds(600, 200, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        JLabel salary = new JLabel("Customer ID");
        salary.setBounds(50, 250, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JLabel();
        tsalary.setBounds(200, 250, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        JLabel phone = new JLabel("Status");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        JLabel shop = new JLabel("Shop Name");
        shop.setBounds(50, 300, 150, 30);
        shop.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(shop);

        tshop = new JLabel();
        tshop.setBounds(200, 300, 150, 30);
        tshop.setBackground(new Color(177, 252, 197));
        add(tshop);

         shop_name = tshop.getText();

        try {
            conn c = new conn();
            String query = "select * from orders where id = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tempid.setText(resultSet.getString("id"));
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("price"));
                taddress.setText(resultSet.getString("category"));
                tsalary.setText(resultSet.getString("customer_id"));
                tphone.setText(resultSet.getString("status"));
                tshop.setText(resultSet.getString("store_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String status = tphone.getText();

            try {
                conn c = new conn();
                String query = "update orders set status = '" + status + "' where id = '" + tempid.getText() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new seller(shop_name);

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new seller(shop_name);
        }
    }

    public static void main(String[] args) {
        new update_orders("");
    }
}