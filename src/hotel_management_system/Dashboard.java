package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem reception, add_emp, add_room, logout;

    public Dashboard() {
        setBounds(175, 75, 1240, 720);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1240, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1240, 720);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU!!!");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 30));
        text.setBounds(350, 50, 600, 85);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1240, 30);
        image.add(mb);

        JMenu home = new JMenu("Home");
        home.setBounds(100, 0, 30, 10);
        mb.add(home);

        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        home.add(reception);

        JMenu admin = new JMenu("Admin");
        admin.setBounds(200, 0, 30, 10);
        mb.add(admin);

        add_emp = new JMenuItem("ADD EMPLOYEE");
        add_emp.addActionListener(this);
        admin.add(add_emp);

        add_room = new JMenuItem("ADD ROOM");
        add_room.addActionListener(this);
        admin.add(add_room);

        logout = new JMenuItem("LogOut");
        logout.addActionListener(this);
        admin.add(logout);

        // JButton logout = new JButton("Log Out");
        // logout.addActionListener(this);
        // logout.setFont(new Font("serif", Font.BOLD,15));
        // logout.setBackground(Color.RED); // Set a background color
        // logout.setForeground(Color.BLACK);
        // tab2.add(Box.createHorizontalGlue());
        // logout.setPreferredSize(new Dimension(tab2.getWidth(), 20));// Add space to
        // align the button to the right
        // admin.add(logout);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add_emp) {
            new AddEmployee();

        } else if (ae.getSource() == add_room) {
            new AddRooms();

        } else if (ae.getSource() == logout) {
            new Login();
            setVisible(false);
        } else if (ae.getSource() == reception) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
