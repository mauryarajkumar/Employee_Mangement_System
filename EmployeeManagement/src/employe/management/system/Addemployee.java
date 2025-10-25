package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addemployee extends JFrame implements ActionListener {
    Random ran=new Random();
    int number = ran.nextInt(999999);

    JTextField  tname, tfname, taddress, temail, tsalary , tpost , tphone ;
  JLabel tempid;
  JButton add, back;

    Addemployee(){


        JLabel heading=new JLabel("Employee Details");
        heading.setBounds(440,50,400,40);
        heading.setFont(new Font("Rale way",Font.BOLD,25));
        add(heading);
//first name
  JLabel name=new JLabel("Name:");

  name.setBounds(80,150,150,30);
  add(name);

  tname=new JTextField();
  tname.setBounds(200,150,150,30);
  add(tname);

//  Father name
        JLabel fname=new JLabel("Father Name:");

        fname.setBounds(400,150,150,30);
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(500,150,150,30);
        add(tfname);

        //  addres
        JLabel address =new JLabel("Address:");

        address.setBounds(700,150,150,30);
        add(address);

        taddress=new JTextField();
        taddress.setBounds(800,150,150,30);
        add(taddress);

        //  email
        JLabel email =new JLabel("Email:");

        email.setBounds(80,200,150,30);
        add(email);

        temail=new JTextField();
        temail.setBounds(200,200,150,30);
        add(temail);

        //  salary
        JLabel salary =new JLabel("Salary:");

        salary.setBounds(400,200,150,30);
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(500,200,150,30);
        add(tsalary);

        //  post
        JLabel post =new JLabel("Post:");

        post.setBounds(700,200,150,30);
        add(post);

        tpost=new JTextField();
        tpost.setBounds(800,200,150,30);
        add(tpost);

//        Phone number
        JLabel phone =new JLabel("Phone:");

        phone.setBounds(80,250,150,30);
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(200,250,150,30);
        add(tphone);


        //  empid
        JLabel empid =new JLabel("Employee ID:");

        empid.setBounds(400,250,150,30);
        add(empid);

        tempid=new JLabel(""+number);
        tempid.setBounds(500,250,150,30);
        add(tempid);

//  For Button
        add = new JButton("Add Employee");
        add.setBounds(300,350,150,30);
       add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(500,350,150,30);
       back.addActionListener(this);
        add(back);



        setTitle("Add Employee Details");
        setSize(1000,550);
        setLocation(200,100);
        setLayout(null);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==add){
           String name=tname.getText();
           String fathername=tfname.getText();
           String address=taddress.getText();
           String email=temail.getText();
           String salary=tsalary.getText();
           String post=tpost.getText();
           String phone=tphone.getText();
           String empId=tempid.getText();

           try{
               conn  c = new conn();
               String query  = "insert into employeedetails values('"+name+"', '"+fathername+"', '"+address+"', '"+email+"', '"+salary+"', '"+post+"', '"+phone+"', '"+empId+"')";

               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Employee Details Added Successfully");
               setVisible(false);
               new Main();

           }catch(Exception ex){
               ex.printStackTrace();
           }

       } else if(e.getSource()==back){
           setVisible(false);
           new Main();
       }
    }



    public static void main(String[] args) {
        new Addemployee();
    }
}
