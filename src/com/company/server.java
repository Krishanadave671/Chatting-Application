package com.company;

import javax.swing.*;
import java.awt.*;

public class server extends JFrame {
    JPanel p1;
    server() {
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/3.png"));
        setSize(300,500);
        setLocation(100,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new server().setVisible(true);

    }
}
