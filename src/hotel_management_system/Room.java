package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;

    public Room() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(275, 180, 1050, 600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(590, 590, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availibility");
        l2.setBounds(120, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(340, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed");
        l5.setBounds(420, 10, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(10, 40, 490, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancel = new JButton("Back");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(180, 500, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Room();
    }

}
