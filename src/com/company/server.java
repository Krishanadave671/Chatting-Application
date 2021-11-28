package com.company;

import javax.swing.*;
import java.awt.*;

public class server extends JFrame {
    JPanel p1;
    server() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,355,50);
        add(p1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(24,20 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5,10,30,30);
        p1.add(l1);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(40,40 , Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(37,5,40,40);
         p1.add(l2);

         JLabel l3 = new JLabel("Pemao");
         l3.setFont(new Font("SAN_SERIF",Font.BOLD,16));
         l3.setBounds(83,5,150,20);
         l3.setForeground(Color.white);
         p1.add(l3);

         JLabel l4 = new JLabel("online");
         l4.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
         l4.setBounds(83,25,150,20);
         l4.setForeground(Color.white);
         p1.add(l4);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(22,26 , Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(235,8,30,30);
        p1.add(l5);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,28 , Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l6 = new JLabel(i12);
        l6.setBounds(195,10,30,30);
        p1.add(l6);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(8,20 , Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l7 = new JLabel(i15);
        l7.setBounds(278,13,10,20);
        p1.add(l7);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setSize(320,500);
        setLocation(750,100);
        setVisible(true);

    }

    public static void main(String[] args) {
        new server().setVisible(true);

    }
}
//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