package user.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_returns extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    String storeName;

    view_returns(String storeName) {
        this.storeName = storeName;
        getContentPane().setBackground(new Color(255, 131, 122));

        table = new JTable();
        try {
            conn c = new conn();
            String query = "SELECT * FROM refund WHERE username = '" + storeName + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        back = new JButton("Back");
        back.setBounds(20, 20, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new purchase_details(storeName);
        }
    }

    public static void main(String[] args) {
        new view_returns("");
    }
}
