package user.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class add_product extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, tfname, tprice;
    JLabel tempid;
    JComboBox<String> category;
    JButton add, back;
    String storeName;

    add_product(String storeName) {
        this.storeName = storeName;

        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Products");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel empid = new JLabel("Product ID");
        empid.setBounds(50, 150, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 150, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel name = new JLabel("Product Name");
        name.setBounds(400, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(600, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        JLabel fname = new JLabel("Price");
        fname.setBounds(50, 200, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tprice = new JTextField();
        tprice.setBounds(200, 200, 150, 30);
        tprice.setBackground(new Color(177, 252, 197));
        add(tprice);

        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(400, 200, 150, 30);
        categoryLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(categoryLabel);

        String items[] = {"none", "Phone", "Tab", "TV", "Computer", "Headphone"};
        category = new JComboBox<>(items);
        category.setBackground(new Color(177, 252, 197));
        category.setBounds(600, 200, 150, 30);
        add(category);

        JLabel storeNameLabel = new JLabel("Store Name");
        storeNameLabel.setBounds(50, 250, 150, 30);
        storeNameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(storeNameLabel);

        JLabel storeNameValue = new JLabel(storeName);
        storeNameValue.setBounds(200, 250, 150, 30);
        storeNameValue.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        storeNameValue.setForeground(Color.BLUE);
        add(storeNameValue);

        add = new JButton("ADD");
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
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            String product_id = tempid.getText();
            String product_name = tname.getText();
            String price = tprice.getText();
            String category = (String) this.category.getSelectedItem();

            try {
                conn c = new conn();
                String query = "INSERT INTO product VALUES('" + product_id + "', '" + product_name + "', '" + price + "', '" + category + "', '" + storeName + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new seller(storeName);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new seller(storeName);
        }
    }

    public static void main(String[] args) {
        new add_product("YourStoreName"); // Replace with the actual store name if testing
    }
}
