package com.ammarabbas;

import java.awt.*;

import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1920;
    final int PANEL_HEIGHT = 1080;

    int x;
    int y;
    int i;
    int q;
    int overcomplicating;
    int measure1;
    int measure2;
    boolean correctanswer;
    float enteredFloat;
    String enteredString;
    JButton Enter;
    JTextField answerLabel;

    boolean runner;
    double temp;
    int answer;

    Timer delay;

    BufferedImage hello;

    // 1. Rectangle
    // 2. Triangle
    // 3. Circle


    MyPanel() {

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.decode("#1F040C"));

        this.setLayout(null);

        answerLabel = new JTextField();
        Enter = new JButton("Enter");

        runner = false;

        ;
    }

    public void paint(Graphics g) {

        if(i==0 || runner == true){
            Random rand = new Random();
            int whichShape = rand.nextInt(3)+1;
            int whichQuestion = rand.nextInt(2)+1;

            overcomplicating = rand.nextInt(2)+1;
            measure1 = rand.nextInt(100)+1;
            measure2 = rand.nextInt(35)+1;

            if (overcomplicating == 1){
                measure2 = measure1 + measure2;
            }
            else{measure2 = measure1 - measure2;}

            if (whichShape == 1){
                x = 1;
            }
            else if (whichShape == 2){
                x = 2;
            }
            else if (whichShape == 3){
                x = 3;
            }

            if (whichQuestion == 1){
                y = 1;
            }
            else if (whichQuestion == 2){
                y = 2;
            }
        }

        super.paint(g); // paint background
        Graphics2D g2D = (Graphics2D) g;            // casting as graphisc2d object
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Enter.setBackground(Color.lightGray);

        try {
            hello = ImageIO.read(new File("C:\\Users\\s465908\\IdeaProjects\\src\\com\\ICS4U_RST\\src\\com\\ammarabbas\\JFrame background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image billo = hello.getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        g2D.drawImage(billo, 0, 0,null);

        g2D.setFont(new Font("Comfortaa",Font.BOLD ,30));
        g2D.setColor(Color.WHITE);

        g2D.setFont(new Font("Comfortaa", Font.PLAIN,15));
        g2D.drawString("Ignore all decimals.", 100,450);

        if (x == 1){
            g2D.fillRect(1100,400,300,300);
            g2D.setFont(new Font("Comfortaa", Font.PLAIN, 15));
            g2D.setColor(Color.white);
            g2D.drawLine(1100,390,1400,390);
            g2D.drawString(String.valueOf(measure1) + " cm", 1235,385);
            g2D.drawLine(1090,400,1090,700);
            g2D.drawString(String.valueOf(measure2) + " cm", 1040,550);
        }
        else if (x == 2){
            int[] xPoints = {1050,1200,1350};
            int[] yPoints = {650,450,650};
            g2D.fillPolygon(xPoints, yPoints, 3);g2D.setColor(Color.black);
            g2D.drawLine(1200,450,1200,650);
            g2D.setFont(new Font("Comfortaa", Font.PLAIN, 15));
            g2D.drawString(String.valueOf(measure1) + " cm", 1210,575);
            g2D.setColor(Color.white);
            g2D.setFont(new Font("Comfortaa", Font.PLAIN, 15));
            g2D.drawString(String.valueOf(measure2) + " cm", 1185,675);
            g2D.drawLine(1050,655,1350,655);

            g2D.setFont(new Font("Comfortaa", Font.PLAIN, 15));
            g2D.setColor(Color.white);
            g2D.drawString("Assume that all sides are equal.", 1090,710);
        }
        else if (x == 3){
            g2D.fillOval(1100,400,300,300);
            g2D.setColor(Color.black);
            g2D.setFont(new Font("Comfortaa", Font.PLAIN, 15));
            g2D.drawLine(1250, 400, 1250,700);
            g2D.drawString(String.valueOf(measure1) + " cm", 1260,555);
        }

        if (y == 1){
            g2D.setColor(Color.white);
            g2D.setFont(new Font("Comfortaa", Font.BOLD, 30));
            String area = "Find the area of the following shape.";
            g2D.drawString(area, 100,400);
        }
        else if (y == 2){
            g2D.setColor(Color.white);
            g2D.setFont(new Font("Comfortaa", Font.BOLD, 30));
            String perimeter = "Find the perimeter of the following shape.";
            g2D.drawString(perimeter, 100,400);
        }

        answerLabel.setBounds(200,500,200,40);
        answerLabel.setEditable(true);
        this.add(answerLabel);
        Enter.setBounds(100,500,100,40);
        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (i>1 && runner == true) {
                    enteredString = answerLabel.getText();

                    enteredFloat = Float.parseFloat(enteredString);

                    answerLabel.setEditable(false);
                    answerLabel.setText("");
                    correctanswer = calculation(enteredFloat);
                    if(correctanswer){
                        System.out.println("Your answer of " + (int)(enteredFloat) + " is correct.");
                    }
                    else{
                        System.out.println("Your answer of " + (int)(enteredFloat) + " is incorrect. The correct answer is " + answer + ".");
                    }
                    q += 1;
                    i=1;
                    repaint();
                }
                }

        });
        this.add(Enter);
        i+=1;
        runner = true;
    }


    public boolean calculation(Float yo){

        if (x==1){
            if (y==1){
                temp = measure1*measure2;
                answer= (int) (temp);
                if (answer==yo){return true;}
                else{return false;}
            }
            else{
                temp = 2 * (measure1 + measure2);
                answer= (int) (temp);
                if (answer==yo){return true;}
                else{return false;}
            }
        }

        if (x==2){
            if (y==1){
                temp = 0.5*(measure1*measure2);
                answer= (int) (temp);
                if (answer==yo){return true;}
                else{return false;}
            }
            else{
                temp = measure2*3;
                answer= (int) (temp);
                if (answer==yo){return true;}
                else{return false;}
            }
        }
        if (x==3){
            if (y==1){
                temp = 3.14*(measure1*0.5)*(measure1*0.5);
                answer= (int) (temp);
                if (answer==yo){return true;}
                else{return false;}
            }
            else{
                temp = 3.14*measure1;
                answer= (int) (temp);
                if (answer==yo){return true;}
                else{return false;}
            }
        }
        else{return false;}

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}