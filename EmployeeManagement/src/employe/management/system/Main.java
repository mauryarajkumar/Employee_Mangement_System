package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {


    public Main(){
//  image for Home Section
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/Iconhome.jpg"));
        Image i2=i1.getImage().getScaledInstance(1220,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1170,650);
        add(img);


//        heading Text

        JLabel title=new JLabel("Employee Management System");
        title.setBounds(340,100,400,40);
        title.setFont(new Font("Rale way",Font.BOLD,25));
        img.add(title);

// Buttons
        JButton addbtn=new JButton("Add Employee");
        addbtn.setBounds(340,200,150,40);
        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                here write frame Of the Add Employee
           new Addemployee();

            }
        });
        img.add(addbtn);


        JButton view=new JButton("View Employee");
        view.setBounds(540,200,150,40);
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                here frame Of the view
                new viewemployee();
                setVisible(false);


            }
        });
        img.add(view);

        JButton removebtn=new JButton("Remove Employee");
        removebtn.setBounds(430,280,150,40);
        removebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                here frame of the Remove btn

            }
        });

        img.add(removebtn);


        setTitle("Well Come to Home");
        setLocation(250,100);
        setSize(1120,630);
        setLayout(null);
        setVisible(true);

    }


    public static void main(String []args){
        new Main();
    }
}
