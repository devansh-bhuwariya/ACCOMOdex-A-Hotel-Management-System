package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JTextField usernameField, passwordField;
    JButton login, cancel;
    
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(175, 75, 550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel user = new JLabel("Username:");
        user.setBounds(40, 20, 100, 30);
        add(user);

        usernameField = new JTextField();
        usernameField.setBounds(150, 20, 150, 30);
        add(usernameField);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 10, 150, 150);
        add(l3);

        cancel = new JButton("Cancel");
        cancel.setBounds(40, 140, 120, 30);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        add(cancel);

        login = new JButton("Login");
        login.setBounds(180, 140, 120, 30);
        login.addActionListener(this);
        login.setFont(new Font("serif", Font.BOLD, 15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == login) {
            String user=usernameField.getText();
            String pass=passwordField.getText();
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+user+"'and password='"+pass+"'";
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password!");
                    return;
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new HotelManagementSystem();
        }
    }
    public static void main(String[] args){
        new Login();
    }
    
}
