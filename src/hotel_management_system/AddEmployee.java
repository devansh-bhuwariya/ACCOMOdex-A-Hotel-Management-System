package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfemail, tfphone, tfaadhaar, tfsalary;
    JRadioButton rbmale, rbFemale;
    JComboBox cbjob;
    JButton submit, cancel;

    public AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(370, 180, 850, 540);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 380);
        add(image);

        JLabel lbname = new JLabel("Name:");
        lbname.setBounds(60, 30, 120, 30);
        lbname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel lbage = new JLabel("Age:");
        lbage.setBounds(60, 80, 120, 30);
        lbage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lbgender = new JLabel("Gender:");
        lbgender.setBounds(60, 130, 120, 30);
        lbgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(280, 130, 100, 30);
        rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbFemale);

        JLabel lbjob = new JLabel("Job:");
        lbjob.setBounds(60, 180, 120, 30);
        lbjob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbjob);

        String str[] = { "Chef", "Manager", "Housekeeping", "Cleaning", "Waiter", "Receptionist" };
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 120, 30);
        add(cbjob);

        JLabel lbsalary = new JLabel("Salary:");
        lbsalary.setBounds(60, 230, 120, 30);
        lbsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lbphone = new JLabel("Phone:");
        lbphone.setBounds(60, 280, 120, 30);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lbemail = new JLabel("Email:");
        lbemail.setBounds(60, 330, 120, 30);
        lbemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        JLabel lbaadhaar = new JLabel("Aadhaar:");
        lbaadhaar.setBounds(60, 380, 120, 30);
        lbaadhaar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbaadhaar);

        tfaadhaar = new JTextField();
        tfaadhaar.setBounds(200, 380, 150, 30);
        add(tfaadhaar);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(60, 430, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhaar = tfaadhaar.getText();
            String gender = null;
            if (rbmale.isSelected()) {
                gender = "Male";
            } else if (rbFemale.isSelected()) {
                gender = "Female";
            }
            String job = (String) cbjob.getSelectedItem();
            if (name.equals("") || age.equals("") || gender.equals("") || job.equals("") || salary.equals("")
                    || phone.equals("") || email.equals("") || aadhaar.equals("")) {
                JOptionPane.showMessageDialog(null, "ALL THE FIELDS MUST BE FILLED!!");
                return;
            }
            try {
                Conn c = new Conn();
                String query = "insert into employee values ('" + name + "','" + age + "','" + gender + "','" + job
                        + "','" + salary + "','" + phone + "','" + email + "','" + aadhaar + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully!!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            // new HotelManagementSystem();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();

    }
}
