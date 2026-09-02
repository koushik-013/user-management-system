package user.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class purchase_details extends JFrame implements ActionListener {

    JTable table;
    JButton refund, back, search, clear,view_refund;
    JTextField productid;
    JTextField productname;
    JTextField current_date;
    JTextField tsearch;
    JComboBox<String> filter1, filter2;
    String customerID;

    purchase_details(String customerID) {
        this.customerID = customerID;

        getContentPane().setBackground(new Color(255, 131, 122));
        setLayout(null);

        JLabel FILTER1 = new JLabel("Categories");
        FILTER1.setBounds(50, 20, 150, 30);
        FILTER1.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(FILTER1);

        String[] items = {"none", "Phone", "Tab", "TV", "Computer", "Headphone"};
        filter1 = new JComboBox<>(items);
        filter1.setBackground(new Color(177, 252, 197));
        filter1.setBounds(50, 50, 150, 30);
        add(filter1);

        JLabel FILTER2 = new JLabel("Sort by");
        FILTER2.setBounds(250, 20, 150, 30);
        FILTER2.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(FILTER2);

        String[] items2 = {"none", "Price high to low", "Price low to high", "Most popular"};
        filter2 = new JComboBox<>(items2);
        filter2.setBackground(new Color(177, 252, 197));
        filter2.setBounds(250, 50, 150, 30);
        add(filter2);

        JLabel Search = new JLabel("Search Product");
        Search.setBounds(550, 50, 150, 30);
        Search.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(Search);

        tsearch = new JTextField();
        tsearch.setBounds(720, 50, 150, 30);
        add(tsearch);

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

//        JLabel pNAME = new JLabel("Received Date");
//        pNAME.setBounds(40, 225, 100, 30);
//        add(pNAME);
//
//        productname = new JTextField();
//        productname.setBounds(40, 250, 150, 30);
//        add(productname);
//
//        JLabel cdate = new JLabel("Current Date");
//        cdate.setBounds(40, 300, 100, 30);
//        add(cdate);
//
//        current_date = new JTextField();
//        current_date.setBounds(40, 325, 150, 30);
//        add(current_date);
//
//        // Get the current date
//        Date currentDate = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Display the current date in the "Current Date" text field
        //current_date.setText(dateFormat.format(currentDate));

        refund = new JButton("Refund");
        refund.setBounds(50, 425, 120, 30);
        refund.addActionListener(this);
        add(refund);

        clear = new JButton("Clear");
        clear.setBounds(50, 475, 120, 30);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("Back");
        back.setBounds(50, 525, 120, 30);
        back.addActionListener(this);
        add(back);

        view_refund = new JButton("View Refunds");
        view_refund.setBounds(50, 575, 120, 30);
        view_refund.addActionListener(this);
        add(view_refund);

        table = new JTable();
        loadOrders(); // Load the orders for the logged-in customer

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    productid.setText(table.getValueAt(selectedRow, 0).toString());
                }
            }
        });

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(200, 120, 900, 580);
        add(jp);

        setSize(1100, 700);
        setLocation(250, 50);
        setVisible(true);
    }

    private void loadOrders() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Product ID", "Name", "Price", "Category", "Store Name", "Customer ID", "Status"}, 0);
        try {
            conn c = new conn();
            String query = "SELECT * FROM orders WHERE customer_id = '" + customerID + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("price"),
                        resultSet.getString("category"),
                        resultSet.getString("store_name"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("status") // Assuming status is a string
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refund) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String productId = table.getValueAt(selectedRow, 0).toString();
                refundProduct(productId);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a product to refund.");
            }
        } else if (e.getSource() == clear) {
            productid.setText("");
            productname.setText("");
            current_date.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        } else if (e.getSource() == back) {
            setVisible(false);
            new user_home(customerID);
        } else if (e.getSource() == search) {
            searchOrders();
        } else if (e.getSource()==view_refund) {
            setVisible(false);
            new view_returns(customerID);

        }
    }

    private void refundProduct(String productId) {
        try {
            conn c = new conn();
            // Get the product details from the orders table
            String query = "SELECT * FROM orders WHERE id = '" + productId + "' AND customer_id = '" + customerID + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                // Insert the product details into the refund table
                String insertQuery = "INSERT INTO refund (id, name, price, category, store_name, customer_id, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.connection.prepareStatement(insertQuery);
                ps.setInt(1, resultSet.getInt("id"));
                ps.setString(2, resultSet.getString("name"));
                ps.setString(3, resultSet.getString("price"));
                ps.setString(4, resultSet.getString("category"));
                ps.setString(5, resultSet.getString("store_name"));
                ps.setInt(6, resultSet.getInt("customer_id"));
                ps.setString(7, "Return Requested");
                ps.executeUpdate();

                // Delete the product from the orders table
                String deleteQuery = "DELETE FROM orders WHERE id = '" + productId + "' AND customer_id = '" + customerID + "'";
                c.statement.executeUpdate(deleteQuery);

                // Refresh the orders table
                loadOrders();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchOrders() {
        String searchTerm = tsearch.getText();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Price", "Category", "Store Name", "Customer ID"}, 0);
        try {
            conn c = new conn();
            String query = "SELECT * FROM orders WHERE customer_id = '" + customerID + "' AND (name LIKE '%" + searchTerm + "%' OR id LIKE '%" + searchTerm + "%')";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("price"),
                        resultSet.getString("category"),
                        resultSet.getString("store_name"),
                        resultSet.getInt("customer_id")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(model);
    }

    public static void main(String[] args) {
        new purchase_details("testUser");
    }
}
