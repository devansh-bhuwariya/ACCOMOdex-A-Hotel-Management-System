
package hotel_management_system;

/**
 *
 * @author devan
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    public HotelManagementSystem(){
        setBounds(175,75,1240,720);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image= new JLabel(i1);
        image.setBounds(0,0,1240,720);
        add(image);

        JLabel title=new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setBounds(600, 0, 500, 75);
        title.setFont(new Font("Georgia",Font.BOLD,20));
        image.add(title);

        JLabel credits=new JLabel("Made By~");
        credits.setBounds(800, 80, 240, 30);
        credits.setFont(new Font("Georgia",Font.BOLD,10));
        image.add(credits);

        JLabel mem1=new JLabel("Devansh Bhuwariya    60009210158");
        mem1.setBounds(800, 100, 240, 30);
        mem1.setFont(new Font("Georgia",Font.PLAIN,10));
        image.add(mem1);
        
        JLabel mem2=new JLabel("Nihar Ketkar                  60009210156");
        mem2.setBounds(800, 120, 240, 30);
        mem2.setFont(new Font("Georgia",Font.PLAIN,10));
        image.add(mem2);
        
        JLabel mem3=new JLabel("Darshankumar Patel   60009210123");
        mem3.setBounds(800, 140, 240, 30);
        mem3.setFont(new Font("Georgia",Font.PLAIN,10));
        image.add(mem3);

        JButton b1=new JButton("Continue");
        b1.setBounds(1090, 600, 100, 50);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        b1.setFont(new Font("Georgia",Font.BOLD,13));
        image.add(b1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
