package com.sms.micro;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class homeRedesign implements ActionListener {
    JFrame f = new JFrame("student home");
    JTabbedPane tb;
    JPanel manage, home, attend, results, manage_left, manage_right;
    JTextField  tuser,tname, mname, mid, menroll;
    JComboBox<String> mbranch;
    JComboBox<String> myear;
    JPasswordField tpass;
    JButton login, insert, delete, update, search, refresh;
    JLabel head, name, pass, mlname, mlid, mlbranch, mlyear, mlenroll;
    JTable table;
    ImageIcon icon;
    Font h1 = new Font("calibri", Font.BOLD, 26);
    Font hn1 = new Font("calibri", Font.BOLD, 50);
    Font h2 = new Font("calibri", Font.PLAIN, 20);
    Font light = new Font("calibri", Font.PLAIN, 16);
    Color c1 = new Color(18, 173, 193);
    Color cb1 = new Color(12, 141, 161);
    Color cb2 = new Color(86, 151, 161);
    Color c2 = new Color(253, 208, 55);
    Color cy1 = new Color(255, 255, 102);
    String insert_q = "insert into students (roll,name,enroll,branch,year) " +
            "values(?,?,?,?,?)";
    String password = "asus";
    DefaultTableModel mod = new DefaultTableModel();

    homeRedesign() {
        f.setBounds(120, 30, 1300, 800);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setResizable(false);
        ImageIcon ic = new ImageIcon("res/logo.png");
        Image scale1 = ic.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        f.setIconImage(scale1);
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        tb = new JTabbedPane();
        tb.setFont(h2);
        tb.setBackground(c1);
        tb.setForeground(Color.white);
        home = new JPanel();
        manage = new JPanel();
        attend = new JPanel();
        results = new JPanel();

        home.setLayout(null);
        home.setBackground(cb2);
        JPanel center_bk = new JPanel();
        JPanel center = new JPanel();
        center.setLayout(null);
        center_bk.setLayout(null);
        center_bk.setBounds(0, 150, 1300, 410);
        center.setBounds(0, 155, 1300, 400);
        center.setBackground(c2);
        center_bk.setBackground(cb1);

        home.add(center);
        home.add(center_bk);
        icon = new ImageIcon("res/students.png");
        Image scale = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        icon = new ImageIcon(scale);
        head = new JLabel(icon);
        JLabel head2 = new JLabel("Student Management System");
        head2.setFont(hn1);
        head2.setForeground(Color.white);
        head.setBounds(20, 15, 100, 100);
        head2.setBounds(150, 20, 700, 100);
        home.add(head);
        home.add(head2);

        tname = new JTextField();
        tpass = new JPasswordField();
        name = new JLabel("Name:");
        pass = new JLabel("Password");
        login = new JButton("Login");
        JLabel admin = new JLabel("Admin Login");
        ImageIcon ic2 = new ImageIcon("res/gears.png");
        scale = ic2.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ic2 = new ImageIcon(scale);
        JLabel admin_l = new JLabel(ic2);
        JLabel admin_r = new JLabel(ic2);
        //tooltip custom
        UIManager.put("ToolTip.background", Color.BLACK);
        UIManager.put("ToolTip.foreground", Color.white);
        Dimension d = new Dimension(150, 30);
        UIManager.put("ToolTip.size", d);
        UIManager.put("ToolTip.font", light);
        tname.setToolTipText("Enter name here");
        tpass.setToolTipText("Enter system password here");
        tname.setBackground(c1);
        tpass.setBackground(c1);
        login.setBackground(cb1);
        tname.setBackground(cy1);
        tpass.setBackground(cy1);
        login.setForeground(Color.white);
        admin.setForeground(cb1);
        name.setFont(h1);
        pass.setFont(h1);
        tname.setFont(h1);
        tpass.setFont(h1);
        login.setFont(h1);
        admin.setFont(hn1);
        admin_l.setBounds(435, 10, 60, 60);
        admin_r.setBounds(800, 10, 60, 60);
        admin.setBounds(520, 10, 500, 60);
        tname.setBounds(400, 80, 500, 60);
        //name.setBounds(400,60,150,60);
        tpass.setBounds(400, 200, 500, 60);
        //pass.setBounds(380,200,200,60);
        login.setBounds(550, 300, 200, 60);
   	//center.add(name);
        center.add(admin_l);
        center.add(admin);
        center.add(admin_r);
        center.add(tname);
        //center.add(pass);
        center.add(tpass);
        center.add(login);
        System.out.println("read");
        tb.add("Home", home);
        f.add(tb);
    //manage section
        manage.setLayout(new GridLayout(1, 0));
        manage_left = new JPanel();
        manage_right = new JPanel();
        manage_left.setLayout(null);
        manage_right.setLayout(new CardLayout());
        manage_left.setBackground(cy1);
        manage_right.setBackground(c1);
        manage.add(manage_left);
        manage.add(manage_right);
    //form contents
        mlid = new JLabel("Roll No");
        mlname = new JLabel("Name");
        mlbranch = new JLabel("Branch");
        mlenroll = new JLabel("Enrollment No");
        mlyear = new JLabel("Year");
        mid = new JTextField();
        mname = new JTextField();
        String[] branch = {"CSE", "MECH", "CIVIL"};
        String[] year = {"FY", "SY", "TY"};
        mbranch = new JComboBox<>(branch);
        myear = new JComboBox<>(year);
        menroll = new JTextField();
        mlid.setFont(h2);
        mlname.setFont(h2);
        mlenroll.setFont(h2);
        mlyear.setFont(h2);
        mlbranch.setFont(h2);
        mid.setFont(h2);
        mname.setFont(h2);
        menroll.setFont(h2);
        myear.setFont(h2);
        mbranch.setFont(h2);
        mlname.setBounds(50, 30, 80, 40);
        mname.setBounds(130, 30, 400, 40);
        mlid.setBounds(50, 100, 100, 40);
        mid.setBounds(150, 100, 100, 40);
        mlenroll.setBounds(50, 170, 150, 40);
        menroll.setBounds(200, 170, 200, 40);
        mlbranch.setBounds(50, 240, 100, 40);
        mbranch.setBounds(130, 240, 100, 40);
        mlyear.setBounds(300, 240, 100, 40);
        myear.setBounds(350, 240, 100, 40);
        manage_left.add(mlname);
        manage_left.add(mname);
        manage_left.add(mlid);
        manage_left.add(mid);
        manage_left.add(mlenroll);
        manage_left.add(menroll);
        manage_left.add(mlbranch);
        manage_left.add(mbranch);
        manage_left.add(mlyear);
        manage_left.add(myear);

        insert = new JButton("Insert");
        delete = new JButton("Delete");
        update = new JButton("update");
        search = new JButton("search");
        refresh = new JButton("refresh");
        insert.setFont(h2);
        delete.setFont(h2);
        update.setFont(h2);
        search.setFont(h2);
        refresh.setFont(h2);
        insert.setBackground(cb1);
        delete.setBackground(cb1);
        update.setBackground(cb1);
        search.setBackground(cb1);
        refresh.setBackground(cb1);
        insert.setForeground(Color.WHITE);
        delete.setForeground(Color.WHITE);
        update.setForeground(Color.WHITE);
        search.setForeground(Color.WHITE);
        refresh.setForeground(Color.WHITE);
        insert.setBounds(120, 400, 100, 40);
        delete.setBounds(420, 400, 100, 40);
        update.setBounds(260, 400, 100, 40);
        search.setBounds(400, 500, 100, 40);
        refresh.setBounds(260, 500, 100, 40);
        manage_left.add(insert);
        manage_left.add(delete);
        manage_left.add(update);
        manage_left.add(refresh);
        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        refresh.addActionListener(this);
   //adding text listeners to textfields
        f.setVisible(true);
//  listeners
        login.addActionListener(
                e -> {
            String pas = String.valueOf(tpass.getPassword());
            if (tname.getText().equals("system") && pas.equals(password)) {
                //JOptionPane.showMessageDialog(f,"Login successful","Admin Login",JOptionPane.INFORMATION_MESSAGE);
                tb.remove(home);
                tb.add("Manage Students", manage);
                fetch();
            } else {
                JOptionPane.showMessageDialog(f, "Incorrect username or password", "Admin Login", JOptionPane.ERROR_MESSAGE);
                tname.setText("");
                tpass.setText("");
            }
        });
    }

    //listeners
    @Override
    public void actionPerformed(ActionEvent e) {

        try
       {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "student_db", "7412369");
            if (e.getSource() == insert) {
                if ((mid.getText() != null && mname.getText() != null && menroll.getText() != null)) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select roll from students");
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        if (Integer.parseInt(mid.getText())!=id) {
                            PreparedStatement pst = con.prepareStatement(insert_q);
                            pst.setInt(1, Integer.parseInt(mid.getText()));
                            pst.setString(2, mname.getText());
                            pst.setInt(3, Integer.parseInt(menroll.getText()));
                            pst.setString(4, String.valueOf(mbranch.getSelectedItem()));
                            pst.setString(5, String.valueOf(myear.getSelectedItem()));
                            int rows = pst.executeUpdate();
                            if (rows > 0) {
                                System.out.println("Record inserted successfully");
                                mid.setText("");
                                mname.setText("");
                                menroll.setText("");
                                mbranch.setSelectedItem("CSE");
                                myear.setSelectedItem("FY");
                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                model.setRowCount(0);
                                fetch();
                            }else {
                                System.out.println("record not inserted!");
                            }
                        }else {
                            JOptionPane.showMessageDialog(f,"This roll number is already allocated to another student","System",JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please input values to process", "System", JOptionPane.INFORMATION_MESSAGE);
                }
                }
            if (e.getSource() == delete) {
                PreparedStatement pst = con.prepareStatement("delete from students where roll=" + Integer.parseInt(mid.getText()));
                int rows = pst.executeUpdate();
                if (rows == 1) {
                    System.out.println("record deleted successfully");
                    JOptionPane.showMessageDialog(f, "Record deleted successfully", "System", JOptionPane.INFORMATION_MESSAGE);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    fetch();
                }
            }
            if (e.getSource() == update) {
                if ((mid.getText() != null && mname.getText() != null && menroll.getText() != null)) {
                    int id = Integer.parseInt(mid.getText());
                    PreparedStatement pst = con.prepareStatement("update students set name=?,enroll=?,branch=?,year=? where roll="+id);
                    pst.setString(1, mname.getText());
                    pst.setInt(2, Integer.parseInt(menroll.getText()));
                    pst.setString(3, String.valueOf(mbranch.getSelectedItem()));
                    pst.setString(4, String.valueOf(myear.getSelectedItem()));
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        System.out.println("Record updated successfully");
                        mid.setText("");
                        mname.setText("");
                        menroll.setText("");
                        mbranch.setSelectedItem("CSE");
                        myear.setSelectedItem("FY");
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setRowCount(0);
                        fetch();
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please input values to process", "System", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (e.getSource() == refresh) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                fetch();
            }
        } catch (Exception sql) {
            System.out.println("not connected");
            JOptionPane.showMessageDialog(f, "Connection failed with database!", "System", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fetch() {
        try {
            table = new JTable() {
                public boolean editCellAt(int row, int column, java.util.EventObject e) {
                    return false;
                }
            };
            String[] col = {"ROLL No", "NAME", "ENROLLMENT NO", "BRANCH", "YEAR"};
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "student_db", "7412369");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from students");
            mod.setColumnIdentifiers(col);
            table.setModel(mod);
            table.setDragEnabled(false);
            table.setGridColor(cb2);
            table.setBackground(cb2);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);
            table.setCellSelectionEnabled(true);
            manage_right.add(new JScrollPane(table), "card1", 0);
            while (rs.next()) {
                int roll = rs.getInt("roll");
                String name = rs.getString("name");
                int enroll = rs.getInt("enroll");
                String branch = rs.getString("branch");
                String year = rs.getString("year");
                mod.addRow(new Object[]{roll, name, enroll, branch, year});
            }
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println("not connected");
            JOptionPane.showMessageDialog(f, "Connection failed with database!", "System", JOptionPane.ERROR_MESSAGE);
        }
    }
}
