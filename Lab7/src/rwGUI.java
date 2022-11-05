/**
 *  Assignment 7
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class rwGUI{

    // create a frame
    private JFrame frame;

    // label of read file
    private JLabel rlabel, rnamelabel;

    // label of write file
    private JLabel wlabel;

    // input file name
    private JTextField wFileName;

    // text area of read and write
    private JTextArea rArea, wArea;

    // button of read and write
    private JButton rbtn, wbtn;

    // create a scroll pane
    private JScrollPane rScrollPane, wScrollPane;

    // initail the data list
    private List<String> data = null;

    public rwGUI(String rFileName) {

        // set frame title
        frame = new JFrame("Read & Write CSV File");
        frame.setLayout(null);

        // set read label
        rlabel = new JLabel("Reading File Name");
        rlabel.setForeground(Color.BLUE);
        rlabel.setBounds(5, 5, 200, 20);
        frame.add(rlabel);

        // set read file name
        rnamelabel = new JLabel("annual.csv");
        rnamelabel.setForeground(Color.BLUE);
        rnamelabel.setBounds(5, 30, 200, 20);
        frame.add(rnamelabel);

        // create read text box
        rArea = new JTextArea(50, 50);
        rArea.setBounds(5, 120, 400, 200);
        rScrollPane = new JScrollPane(rArea);
        rScrollPane.setBounds(5, 120, 400, 200);
        rScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        rScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(rScrollPane);

        // create read buttons
        rbtn = new JButton("Click to Read From File");
        rbtn.setForeground(Color.BLUE);
        rbtn.setBackground(Color.RED);
        rbtn.setOpaque(true);
        rbtn.setBorderPainted(false);
        rbtn.setBounds(10, 60, 190, 50);
        frame.add(rbtn);
        rbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rwFile rw = new rwFile();
                //ser file name
                rw.rsetName(rFileName);
                // read file
                String FileName = rw.rgetName();
                StringBuilder sb = new StringBuilder();

                // print 1~5 rows
                data = rw.readFile(FileName);
                int i = 0;
                for (String s : data) {
                    if (i > 5){
                        break;
                    }
                    sb.append(s + "\n");
                    i += 1;
                }
                rArea.setText(String.valueOf(sb));
                sb.setLength(0);
            }
        });

        // set write label
        wlabel = new JLabel("File Name to Write");
        wlabel.setForeground(Color.BLUE);
        wlabel.setBounds(500, 5, 200, 20);
        frame.add(wlabel);

        // set write file name
        wFileName = new JTextField("output.csv");
        wFileName.setForeground(Color.BLUE);
        wFileName.setBounds(500, 30, 200, 20);
        frame.add(wFileName);

        // create write text box
        wArea = new JTextArea(50, 50);
        wArea.setBounds(500, 120, 400, 200);
        wScrollPane = new JScrollPane(wArea);
        wScrollPane.setBounds(500, 120, 400, 200);
        wScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        wScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(wScrollPane);

        // create write buttons
        wbtn = new JButton("Click to Write to File");
        wbtn.setForeground(Color.BLUE);
        wbtn.setBackground(Color.RED);
        wbtn.setOpaque(true);
        wbtn.setBorderPainted(false);
        wbtn.setBounds(500, 60, 190, 50);
        frame.add(wbtn);
        wbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StringBuilder sb = new StringBuilder();
                rwFile rw = new rwFile();
                // set write file name
                rw.wsetName(wFileName.getText());
                rw.writeFile(rw.wgetName(), data);

                if (data != null){
                    for (int row = 0; row < 6; row++) {
                        String[] values = data.get(row).split(",");

                        for(int i = 0; i < 3; i++) {
                            sb.append(values[i]);
                            if( i != 2) {
                                sb.append(",");
                            }
                        }
                        sb.append("\n");
                    }
                    wArea.setText(String.valueOf(sb));
                }
                sb.setLength(0);
            }
        });

        // close the operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set frame size
        frame.setSize(930, 400);
        // user can resize the frame
        frame.setResizable(true);
        // set frame visible
        frame.setVisible(true);
    }
}
