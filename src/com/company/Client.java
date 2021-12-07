package com.company;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;;
import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Client implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JPanel a1;
    static JFrame f1 = new JFrame();

    static Box vertical = Box.createVerticalBox();

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    boolean typing;


    Client() {
        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(69, 122, 128));
        p1.setBounds(0,0,330,53);
        f1.add(p1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(24,20 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5,11,30,30);
        p1.add(l1);

        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(42,42 , Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(37,6,42,42);
        p1.add(l2);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(22,25 , Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(260,10,30,30);
        p1.add(l5);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,27 , Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l6 = new JLabel(i12);
        l6.setBounds(220,12,30,30);
        p1.add(l6);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(8,20 , Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l7 = new JLabel(i15);
        l7.setBounds(304,16,10,20);
        p1.add(l7);

        JLabel l3 = new JLabel("Buntyy");
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        l3.setBounds(87,6,150,20);
        l3.setForeground(Color.white);
        p1.add(l3);

        JLabel l4 = new JLabel("online");
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        l4.setBounds(87,27,150,20);
        l4.setForeground(Color.white);
        p1.add(l4);

        Timer t = new Timer(1, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                if(!typing){
                    l4.setText("online");

                }

            }
        });
        t.setInitialDelay(1000);


        a1= new JPanel();
        //a1.setBounds(5,58,320,434);
        //a1.setBackground(Color.lightGray);
        a1.setFont(new Font("SANS_SERIF", Font.PLAIN,16));

        //f1.add(a1);

        JScrollPane sp= new JScrollPane(a1);
        sp.setBounds(4,57,324,438);
        sp.setBorder(BorderFactory.createEmptyBorder());

        ScrollBarUI ui = new BasicScrollBarUI(){

            protected JButton createDecreaseButton(int orientation){
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(new Color(69, 122, 128));
                button.setForeground(Color.WHITE);
                this.thumbColor= new Color(69,122,128);
                return button;
            }
            protected JButton createIncreaseButton(int orientation){
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(new Color(69, 122, 128));
                button.setForeground(Color.WHITE);
                this.thumbColor= new Color(69,122,128);
                return button;
            }
        };
        sp.getVerticalScrollBar().setUI(ui);
        f1.add(sp);

        t1 = new JTextField();
        t1.setBounds(5,498,239,26);
        t1.setFont(new Font("SANS_SERIF", Font.PLAIN,15));
        f1.add(t1);

        t1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                l4.setText("Online...");

                t.stop();
                typing=true;
            }

            public void keyReleased(KeyEvent ke){
                typing=false;
                if(!t.isRunning()){
                    t.start();

                }
            }
        });

        b1= new JButton("Send");
        b1.setBounds(250,498,72,26);
        b1.setBackground(new Color(69, 122, 128));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SANS_SERIF", Font.PLAIN,13));
        b1.addActionListener(this);
        f1.add(b1);

        f1.getContentPane().setBackground(Color.WHITE);
        f1.setLayout(null);
        f1.setSize(330,530);
        f1.setLocation(750,100);
        f1.setUndecorated(true);
        f1.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String out = t1.getText();

            JPanel p2 = formatLabel(out);

            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START);

            //a1.add(p2);

            dout.writeUTF(out);
            t1.setText("");
        }catch (Exception e){
            System.out.println(e);
        };
    }

    public static JPanel formatLabel(String out){
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));

        JLabel l1 = new JLabel("<html><p style = \"width : 105px\">"+out+"</p></html>");
        l1.setFont(new Font("DIALOG", Font.BOLD,16));
        l1.setBackground(new Color(37,211,102));
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(10,10,10,50));

        Calendar cal= Calendar.getInstance();
        SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");

        JLabel l2= new JLabel();
        l2.setText(sdf.format(cal.getTime()));
        l2.setFont(new Font("DIALOG", Font.BOLD,11));


        p3.add(l1);
        p3.add(l2);
        return p3;
    }

    public static void main(String[] args) {
        new Client().f1.setVisible(true);

        try {
            s = new Socket("127.0.0.1", 6002);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msgInput = "";
            while (true){
                msgInput = din.readUTF();
                JPanel p2= formatLabel(msgInput);
                JPanel left = new JPanel(new BorderLayout());
                left.add(p2, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(13));
                a1.add(vertical, BorderLayout.PAGE_START);
                f1.validate();

        }

        }catch (Exception e){};

    }
}

