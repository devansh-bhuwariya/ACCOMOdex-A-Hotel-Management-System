package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;
public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;

    public ManagerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400, 180, 800, 600);


        JLabel l1 = new JLabel("Name");
        l1.setBounds(20, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(120, 10, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(210, 10, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(320, 10, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(400, 10, 100, 20);
        add(l5);
        JLabel l6 = new JLabel("Contact");
        l6.setBounds(500, 10, 100, 20);
        add(l6);
        JLabel l7 = new JLabel("Email");
        l7.setBounds(600, 10, 100, 20);
        add(l7);
        JLabel l8 = new JLabel("Aadhaar");
        l8.setBounds(700, 10, 100, 20);
        add(l8);
        table = new JTable();
        table.setBounds(10, 40, 760, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancel = new JButton("Back");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(330, 500, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }

}

