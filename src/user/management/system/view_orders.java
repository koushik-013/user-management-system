package user.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view_orders extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;
    String storeName;

    view_orders(String storeName) {
        this.storeName = storeName;
        getContentPane().setBackground(new Color(255, 131, 122));

        JLabel search = new JLabel("Search by Product id");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from product");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c = new conn();
            String query = "SELECT * FROM orders WHERE store_name = '" + storeName + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(220,70,80,20);
        back.addActionListener(this);
        add(back);

        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);


        setSize(900, 700);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from orders where id = '"+choiceEMP.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == update){
            setVisible(false);
            new update_orders(choiceEMP.getSelectedItem());
        }
        else {
            setVisible(false);
            new seller(storeName);
        }

    }

    public static void main(String[] args) {
        new view_orders("");
    }
}
