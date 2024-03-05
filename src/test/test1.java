package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test1 implements ActionListener {
    private JFrame frame1;
    private JFrame frame2;
    private JPanel mainPanelFirst;
    private JPanel secondPanel;
    private JButton newWindowButton;
    private int mulitplyPanels;
    private JLabel leftLabel;
    private JLabel rightLabel;
    private JComboBox leftCB;
    private JComboBox rightCB;

    public JFrame createMainUI() {

        frame1 = new JFrame("Main frame");
        frame1.setSize(600, 600);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        mainPanelFirst = new JPanel();
        mainPanelFirst.setLayout(new FlowLayout());
        frame1.add(mainPanelFirst);


        newWindowButton = new JButton("Open new window");
        newWindowButton.addActionListener(this);
        mainPanelFirst.add(newWindowButton);


        return frame1;
    }

    public JFrame createSecondUI() {
        frame2 = new JFrame("Second frame");
        frame2.setSize(600, 600);
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout());
        secondPanel.setBackground(Color.gray);
        frame2.add(secondPanel);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(70,400,20));
        topPanel.setBackground(Color.WHITE);
        secondPanel.add(topPanel);
        leftLabel = new JLabel("Name:");
        topPanel.add(leftLabel);
        return frame2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        createSecondUI();
    }

    test1(){
        frame1.setVisible(true);
    }
    public static void main(String[] args) {
        new test1();
    }
}
