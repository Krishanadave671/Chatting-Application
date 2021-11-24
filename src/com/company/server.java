package com.company;

import javax.swing.*;
import java.awt.*;

public class server extends JFrame {
    JPanel p1;
    server() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,350,50);
        add(p1);

//krishana

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,30 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5,10,30,30);
        p1.add(l1);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(40,40 , Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(37,3,40,40);
         p1.add(l2);

         JLabel l3 = new JLabel("prajwal");
         l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
         l3.setBounds(80,5,150,20);
         l3.setForeground(Color.white);
         p1.add(l3);

         JLabel l4 = new JLabel("online");
         l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
         l4.setBounds(80,24,150,20);
         l4.setForeground(Color.white);
         p1.add(l4);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(25,30 , Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(5,10,30,30);
        p1.add(l5);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,30 , Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l6 = new JLabel(i12);
        l6.setBounds(5,10,30,30);
        p1.add(l6);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10,20 , Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l7 = new JLabel(i15);
        l7.setBounds(260,10,10,20);
        p1.add(l7);

        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setSize(300,500);
        setLocation(750,100);
        setVisible(true);
        // prajwal did cg project
// ayush and krishana are working on oop
    }

    public static void main(String[] args) {
        new server().setVisible(true);

    }
}
