/**
 *  Assignment 6
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class caculateGUI {

    // Set the lable and textfield of point total, earned point,
    // assigment % and weighted grade
    private JFrame frame;
    private JLabel lbtotal;
    private JTextField tftotal;
    private JLabel lbearn;
    private JTextField tfearn;
    private JLabel lbpercent;
    private JTextField tfpercent;
    private JButton jbtcaculate;
    private JLabel lbresult;
    private JTextField tfresult;

    public caculateGUI() {
        //set the frame title
        frame = new JFrame("Caculate Weighted Grade");
        frame.setLayout(null);

        //set the lable and textfield of point total's title, color and poistion
        lbtotal = new JLabel("Point Total");
        lbtotal.setForeground(Color.blue);
        lbtotal.setBounds(5,5,150,50);
        frame.add(lbtotal);

        tftotal = new JTextField();
        tftotal.setBounds(5,40,150,50);
        frame.add(tftotal);

        //set the lable and textfield of earned point's title, color and poistion
        lbearn = new JLabel("Earned Point");
        lbearn.setForeground(Color.blue);
        lbearn.setBounds(180,5,150,50);
        frame.add(lbearn);

        tfearn = new JTextField();
        tfearn.setBounds(180,40,150,50);
        frame.add(tfearn);

        //set the lable and textfield of assigment percentage's title, color and poistion
        lbpercent = new JLabel("Assignment Percentage(%)");
        lbpercent.setForeground(Color.blue);
        lbpercent.setBounds(5,90,250,50);
        frame.add(lbpercent);

        tfpercent = new JTextField();
        tfpercent.setBounds(5,125,150,50);
        frame.add(tfpercent);

        //set the button of caculate's title, color and poistion
        jbtcaculate = new JButton("Caculate the Weight Grade");
        jbtcaculate.setForeground(Color.blue);
        jbtcaculate.setBackground(Color.red);
        jbtcaculate.setOpaque(true);
        jbtcaculate.setBorderPainted(false);
        jbtcaculate.setBounds(80,190,210,50);
        frame.add(jbtcaculate);
        jbtcaculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create weightedGrades class
                weightedgrade wg = new weightedgrade();

                //get input of total point, earned point and assignment percentage
                int pointTotal = Integer.parseInt(tftotal.getText());
                wg.setPointTotal(pointTotal);

                int earnedPoints = Integer.parseInt(tfearn.getText());
                wg.setEarnedPoints(earnedPoints);

                int assignmentPercent = Integer.parseInt(tfpercent.getText());
                wg.setAssigmentPercentage(assignmentPercent);

                //caculate the weighted grade
                double weighted = ((double)wg.getEarnedPoints()/wg.getPointTotal())*wg.getAssigmentPercentage();

                //add the result to the field
                tfresult.setText(String.valueOf(weighted));
            }
        });

        //set the lable and textfield of weighted grade's title, color and poistion
        lbresult = new JLabel("Weighted Grade");
        lbresult.setForeground(Color.blue);
        lbresult.setBounds(80,240,250,50);
        frame.add(lbresult);

        tfresult = new JTextField();
        tfresult.setBounds(80,275,150,50);
        frame.add(tfresult);

        //set frame's size
        frame.setSize(340,400);

        //show frame
        frame.setVisible(true);

    }
}
