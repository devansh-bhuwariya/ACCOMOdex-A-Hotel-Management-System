package hotel_management_system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, rooms, department, allEmployee, customers, managerInfo, checkout, update, roomStatus,
            searchRoom, back;

    public Reception() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setBounds(400, 180, 800, 570);

        newCustomer = new JButton("Add Customer");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setFocusPainted(false);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFocusPainted(false);
        rooms.addActionListener(this);
        add(rooms);

       

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10, 110, 200, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setFocusPainted(false);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10, 150, 200, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.setFocusPainted(false);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10, 190, 200, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setFocusPainted(false);
        managerInfo.addActionListener(this);
        managerInfo.setFocusPainted(false);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10, 230, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFocusPainted(false);
        checkout.addActionListener(this);
        add(checkout);

        // update = new JButton("Update Status");
        // update.setBounds(10, 270, 200, 30);
        // update.setBackground(Color.BLACK);
        // update.setForeground(Color.WHITE);
        // update.setFocusPainted(false);
        // add(update);

        // roomStatus = new JButton("Update Room Status");
        // roomStatus.setBounds(10, 310, 200, 30);
        // roomStatus.setBackground(Color.BLACK);
        // roomStatus.setForeground(Color.WHITE);
        // roomStatus.setFocusPainted(false);
        // add(roomStatus);

        // searchRoom = new JButton("Search Room");
        // searchRoom.setBackground(Color.BLACK);
        // searchRoom.setForeground(Color.WHITE);
        // searchRoom.setBounds(10, 350, 200, 30);
        // searchRoom.setFocusPainted(false);
        // add(searchRoom);

        back = new JButton("Back");
        back.setBounds(10, 450, 200, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(il);
        image.setBounds(250, 30, 500, 470);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }else if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }

    }

    public static void main(String[] args) {
        new Reception();
    }
}
