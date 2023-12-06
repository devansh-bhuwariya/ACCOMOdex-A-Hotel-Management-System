package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout, back;

    public Checkout() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300, 180, 800, 400);

        JLabel text = new JLabel("CHECKOUT");
        text.setBounds(100, 20, 150, 20);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblid = new JLabel("Customer Id:");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(60, 60, 150, 30);
        add(lblid);

        ccustomer = new Choice();
        lblroomnumber = new JLabel();
        lblcheckintime = new JLabel();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("Id_Number"));
                lblroomnumber.setText(rs.getString("Room_Number"));
                lblcheckintime.setText(rs.getString("Checkin_Time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ccustomer.setBounds(220, 65, 150, 30);
        ccustomer.setBackground(Color.WHITE);
        add(ccustomer);

        JLabel lblroom = new JLabel("Room Number:");
        lblroom.setBounds(60, 110, 150, 30);
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblroom);

        lblroomnumber.setBounds(220, 110, 150, 30);
        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Checkin Time:");
        lblcheckin.setBounds(60, 160, 150, 30);
        lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcheckin);

        
        lblcheckintime.setBounds(220, 160, 150, 30);
        lblcheckintime.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkout Time:");
        lblcheckout.setBounds(60, 210, 150, 30);
        lblcheckout.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(220, 210, 200, 30);
        lblcheckouttime.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(lblcheckouttime);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFocusPainted(false);
        back.addActionListener(this);
        back.setBounds(60, 260, 120, 30);
        add(back);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFocusPainted(false);
        checkout.addActionListener(this);
        checkout.setBounds(220, 260, 120, 30);
        add(checkout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 45, 400, 250);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = "delete from customer where Id_Number='" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availability ='Unoccupied' where Room_Number='" + lblroomnumber + "'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Checked-Out Successfully!!");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Checkout();
    }
}
