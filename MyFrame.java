package com.ammarabbas;

import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame{        // this class behaves like  a JFrame

    MyPanel panel;          // creating instance of MyPanel class.

    MyFrame(){          // constructor

        panel = new MyPanel();          // instantiating it within MyFrame

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // frame closes when you press x
        this.add(panel);            // adding panel to the Frame
        this.pack();                // packs everything after things are added
        this.setLocationRelativeTo(null);       // start in the middle of the screen
        this.setVisible(true);              // makes frame visible
    }
}