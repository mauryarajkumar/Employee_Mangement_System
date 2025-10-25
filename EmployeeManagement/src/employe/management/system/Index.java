package employe.management.system;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame {
      Index(){
//          First Image Import  In the Front Page
   ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/front.gif"));
   Image i2 =i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
    ImageIcon i3 =new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,1170,650);
    add(image);







          setTitle("Employee Management System");
          setSize(1170,650);
          setLocation(200,50);
          setLayout(null);
          setVisible(true);


//          making thread For Close the front frame to jump into login page after 5 second

        try{
            Thread.sleep(5000);
            setVisible(false);
//            To Jump Into Login page
            new Login();
        } catch(Exception e){
            e.printStackTrace();

        }




      }





    public static void main(String[] args) {
      new Index();
    }
}
