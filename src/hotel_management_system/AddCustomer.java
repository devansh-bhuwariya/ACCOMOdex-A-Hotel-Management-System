package hotel_management_system;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfnumber, tfname, tfemail, tfdeposit;
    JRadioButton rbmale, rbFemale;
    Choice croom;
    JLabel checkintime;
    JButton submit, cancel;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(400, 180, 800, 550);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(text);

        JLabel lblid = new JLabel("ID Proof:");
        lblid.setBounds(60, 80, 300, 30);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        String options[] = { "Aadhar Card", "Passport", "Driving License", "Voter id Card" };
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 30);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("ID Number:");
        lblnumber.setBounds(60, 130, 300, 20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(60, 170, 300, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 170, 150, 25);
        add(tfname);

        JLabel lbgender = new JLabel("Gender:");
        lbgender.setBounds(60, 205, 120, 30);
        lbgender.setFont(new Font("Tohama", Font.PLAIN, 16));
        add(lbgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 205, 70, 30);
        rbmale.setFont(new Font("Tohama", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(280, 205, 100, 30);
        rbFemale.setFont(new Font("Tohama", Font.PLAIN, 14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbFemale);

        JLabel lbemail = new JLabel("Email:");
        lbemail.setBounds(60, 250, 300, 20);
        lbemail.setFont(new Font("Tohama", Font.PLAIN, 16));
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 250, 150, 25);
        add(tfemail);

        JLabel lblroom = new JLabel("Room Number:");
        lblroom.setBounds(60, 300, 130, 20);
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblroom);

        croom = new Choice();
        try {
            Conn c = new Conn();
            String query = "select * from room where availability='Unoccupied'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("Room_Number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200, 300, 150, 20);
        add(croom);

        JLabel lbltime = new JLabel("Checkin time:");
        lbltime.setBounds(60, 340, 150, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 340, 150, 20);
        checkintime.setFont(new Font("Tahoma", Font.PLAIN, 10));
        add(checkintime);

        JLabel lbldeposit = new JLabel("Deposit:");
        lbldeposit.setBounds(60, 380, 100, 20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 380, 150, 25);
        add(tfdeposit);

        cancel = new JButton("Back");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(60, 430, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(200, 430, 150, 30);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        // Image i2 = il.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i1);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 300, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String email=tfemail.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();

            String gender = null;
            if (rbmale.isSelected()) {
                gender = "Male";
            } else if (rbFemale.isSelected()) {
                gender = "Female";
            }

            if (id.equals("") || number.equals("") || name.equals("") || gender.equals("") || email.equals("")
                    || room.equals("") || time.equals("") || deposit.equals("")) {
                JOptionPane.showMessageDialog(null, "ALL THE FIELDS MUST BE FILLED!!");
                return;
            }
            try {
                Conn c = new Conn();
                String query1 = "insert into customer values ('" + id + "','" + number + "','" + name + "','" + gender+ "','" + email + "','" + room + "','" + time + "','" + deposit + "')";

                String query2 = "update room set availability='Occupied' where Room_Number = '" + room + "'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Added Successfully!!");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
