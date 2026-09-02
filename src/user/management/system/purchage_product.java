package user.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class purchage_product extends JFrame implements ActionListener {

    JTable table;
    JTable table2;
    JButton add, purchage, print, back, search, clear, apply;
    JTextField productid;
    JTextField productname;
    JTextField cid;  // Field for entering customer ID
    JComboBox<String> filter1, filter2;
    Choice choiceEMP;
    String customerID;

    // Constructor updated to accept customerID
    purchage_product(String customerID) {
        this.customerID = customerID;

        getContentPane().setBackground(new Color(255, 131, 122));

        choiceEMP = new Choice();
        choiceEMP.setBounds(720, 50, 150, 50);
        add(choiceEMP);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from product");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel FILTER1 = new JLabel("Categories");
        FILTER1.setBounds(50, 20, 150, 30);
        FILTER1.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(FILTER1);

        String items[] = {"none", "Phone", "Tab", "TV", "Computer", "Headphone"};
        filter1 = new JComboBox<>(items);
        filter1.setBackground(new Color(177, 252, 197));
        filter1.setBounds(50, 50, 150, 30);
        add(filter1);

        JLabel FILTER2 = new JLabel("Sort by");
        FILTER2.setBounds(250, 20, 150, 30);
        FILTER2.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(FILTER2);

        String items2[] = {"none", "Price high to low", "Price low to high", "Most popular"};
        filter2 = new JComboBox<>(items2);
        filter2.setBackground(new Color(177, 252, 197));
        filter2.setBounds(250, 50, 150, 30);
        add(filter2);

        JLabel Search = new JLabel("Search Product");
        Search.setBounds(550, 50, 150, 30);
        Search.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(Search);

        search = new JButton("Search Product");
        search.setBounds(900, 50, 150, 30);
        search.addActionListener(this);
        add(search);

        JLabel pID = new JLabel("Product ID");
        pID.setBounds(40, 150, 100, 30);
        add(pID);

        productid = new JTextField();
        productid.setBounds(40, 175, 150, 30);
        add(productid);

        JLabel pNAME = new JLabel("Product Name");
        pNAME.setBounds(40, 225, 100, 30);
        add(pNAME);

        productname = new JTextField();
        productname.setBounds(40, 250, 150, 30);
        add(productname);

        JLabel id = new JLabel("Customer ID");
        id.setBounds(40, 300, 100, 30);
        add(id);

        cid = new JTextField();
        cid.setBounds(40, 325, 150, 30);
        add(cid);

        add = new JButton("ADD");
        add.setBounds(20, 550, 80, 20);
        add.addActionListener(this);
        add(add);

        purchage = new JButton("Purchase");
        purchage.setBounds(120, 550, 80, 20);
        purchage.addActionListener(this);
        add(purchage);

        print = new JButton("Print");
        print.setBounds(20, 600, 80, 20);
        print.addActionListener(this);
        add(print);

        clear = new JButton("Clear");
        clear.setBounds(120, 600, 80, 20);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("Back");
        back.setBounds(65, 650, 80, 20);
        back.addActionListener(this);
        add(back);

        apply = new JButton("Apply");
        apply.setBounds(425, 50, 80, 30);
        apply.addActionListener(this);
        add(apply);

        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from product");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(200, 120, 900, 300);
        add(jp);

        table2 = new JTable();
        updateCartTable();  // Call method to update cart table

        JScrollPane jp2 = new JScrollPane(table2);
        jp2.setBounds(200, 500, 900, 300);
        add(jp2);

        setSize(1100, 900);
        setLocation(250, 0);
        setLayout(null);
        setVisible(true);
    }

    private void updateCartTable() {
        try {
            conn c = new conn();
            String query = "select * from cart where customer_id = '" + customerID + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            table2.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "select * from product where id = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == add) {
            String id = productid.getText();
            String name = productname.getText();
            customerID = cid.getText();  // Get the customer ID from the text field

            String query = "insert into cart (id, name, price, category, store_name, customer_id) " +
                    "select id, name, price, category, store_name, '" + customerID + "' " +
                    "from product where id = '" + id + "'";
            try {
                conn c = new conn();
                int rowsAffected = c.statement.executeUpdate(query);
                if (rowsAffected > 0) {
                    updateCartTable();  // Update the cart table after adding a product
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == purchage) {
            // Implement purchase functionality here
            try {
                conn c = new conn();
                String query = "insert into orders (id, name, price, category, store_name, customer_id, status) " +
                        "select id, name, price, category, store_name, customer_id, 'false' " +
                        "from cart where customer_id = '" + customerID + "'";
                c.statement.executeUpdate(query);

                // Clear the cart after purchase
                String deleteQuery = "delete from cart where customer_id = '" + customerID + "'";
                c.statement.executeUpdate(deleteQuery);

                updateCartTable();  // Update the cart table after purchase
                JOptionPane.showMessageDialog(null, "Purchase successful!");

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            // Implement print functionality here
        } else if (e.getSource() == clear) {
            // Implement clear functionality here
        } else if (e.getSource() == back) {
            setVisible(false);
            new user_home(customerID);  // Navigate back to user home
        } else if (e.getSource() == apply) {
            String selectedCategory = filter1.getSelectedItem().toString();
            String selectedSortBy = filter2.getSelectedItem().toString();

            StringBuilder query = new StringBuilder("select * from product where 1=1");

            if (!"none".equals(selectedCategory)) {
                query.append(" and category = '").append(selectedCategory).append("'");
            }

            if ("Price high to low".equals(selectedSortBy)) {
                query.append(" order by price desc");
            } else if ("Price low to high".equals(selectedSortBy)) {
                query.append(" order by price asc");
            } else if ("Most popular".equals(selectedSortBy)) {
                query.append(" order by popularity desc");  // Assuming there is a 'popularity' column
            }

            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query.toString());
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new purchage_product("testCustomer"); // Example usage with a test customerID
    }
}
