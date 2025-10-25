package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login(){
     JLabel username = new JLabel("Username");
     username.setBounds(40,20,100,30);
     add(username);

     tusername = new JTextField();
     tusername.setBounds(150,20,150,30);
     add(tusername);



        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

      login = new JButton("Login");
      login.setBounds(80,150,100,30);
      login.addActionListener(this);
      add(login);

      back = new JButton("Back");
      back.setBounds(200,150,100,30);
      back.addActionListener(this);
      add(back);


//        Login Avatar Icon


        ImageIcon i11 =  new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,300);
        add(imgg);




//      login background image
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("Icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);




        setTitle("Login");
        setLocation(500,200);
        setSize(600,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
//            Login process data base
            try{
                String  username = tusername.getText();
                String  password = tpassword.getText();
//                use here connection
                 conn conn = new conn();

//                 query for checking the username and password are same or not
                String query = "select * from login where username='"+username+"' and password='"+password+"'";
                ResultSet resultset = conn.statement.executeQuery(query);

                if(resultset.next()){
                    setVisible(false);
//                    use here new frame to open after login succesful
                    new Main();

                } else{
                    JOptionPane.showMessageDialog(null,"Wrong Username or Password");
                }


            } catch (Exception E){
                E.printStackTrace();
            }


        } else if (e.getSource()== back) {
            System.exit(420);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
