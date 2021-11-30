package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;
import java.io.*;
import java.net.*;

public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    Client() {

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

        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(40,40 , Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(37,5,40,40);
        p1.add(l2);

        JLabel l3 = new JLabel("Buntyy");
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
        Image i8 = i7.getImage().getScaledInstance(22,25 , Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(255,8,30,30);
        p1.add(l5);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,27 , Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l6 = new JLabel(i12);
        l6.setBounds(215,10,30,30);
        p1.add(l6);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(8,20 , Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l7 = new JLabel(i15);
        l7.setBounds(298,13,10,20);
        p1.add(l7);

        a1= new JTextArea();
        a1.setBounds(5,55,310,420);
        //a1.setBackground(Color.lightGray);
        a1.setFont(new Font("SANS_SERIF", Font.PLAIN,16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);

        t1 = new JTextField();
        t1.setBounds(5,480,230,26);
        t1.setFont(new Font("SANS_SERIF", Font.PLAIN,15));
        add(t1);

        b1= new JButton("Send");
        b1.setBounds(240,480,72,26);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SANS_SERIF", Font.PLAIN,13));
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(320,510);
        setLocation(750,100);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String out = t1.getText();
            a1.setText(a1.getText()+"\n\t\t"+out);
            dout.writeUTF(out);
            t1.setText("");
        }catch (Exception e){

        };
    }

    public static void main(String[] args) {
        new Client().setVisible(true);

        try {
            s = new Socket("127.0.0.1", 6001);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msgInput = "";
            while (true){
                msgInput = din.readUTF();
            a1.setText(a1.getText()+"\n"+msgInput);
        }

        }catch (Exception e){};

    }
}

