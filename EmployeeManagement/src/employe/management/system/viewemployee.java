package employe.management.system;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewemployee extends JFrame implements ActionListener {

  JTable table;
    Choice chEMP;
   JButton searchbtn, printbtn, updatebtn , backbtn;

     viewemployee(){

         JLabel l1=new JLabel("Search By Employee ID");
         l1.setBounds(20,10,150,30);
         add(l1);

         chEMP=new Choice();
         chEMP.setBounds(200,10,200,30);
         add(chEMP);

//         poup the employee id from the database
         try{
             conn c = new conn();
             ResultSet  resultSet=c.statement.executeQuery("select * from employeedetails");
             while (resultSet.next()){
                 chEMP.add(resultSet.getString("empId"));
             }
         } catch (Exception e) {
             e.printStackTrace();
         }




  table=new JTable();
         try{
             conn c = new conn();
             ResultSet  resultSet=c.statement.executeQuery("select * from employeedetails");
//             we have to import jar file for the resultset to fetch table table from the dbUtils
             table.setModel(DbUtils.resultSetToTableModel(resultSet));

         }catch(Exception e){
             e.printStackTrace();
         }

//         Table data large then use scroll pane
         JScrollPane scroll=new JScrollPane(table);
         scroll.setBounds(10,100,1050,600);
         add(scroll);


//         Button
         searchbtn=new JButton("Search");
         searchbtn.setBounds(20,50,100,30);
         searchbtn.addActionListener(this);
         add(searchbtn);

         printbtn=new JButton("Print");
         printbtn.setBounds(130,50,100,30);
         printbtn.addActionListener(this);
         add(printbtn);

         updatebtn=new JButton("Update");
          updatebtn.setBounds(240,50,100,30);
          updatebtn.addActionListener(this);
          add(updatebtn);


          backbtn=new JButton("Back");
          backbtn.setBounds(350,50,100,30);
          backbtn.addActionListener(this);
          add(backbtn);

            setTitle("View Employee");
            setSize(1100, 600);
            setLocation(200,100);
            setLayout(null);

            setVisible(true);
     }

     public void actionPerformed(ActionEvent e){
         if(e.getSource()==searchbtn){
             String qeury= "select * from employeedetails where empId='"+chEMP.getSelectedItem()+"'";
             try{
                 conn c = new conn();
                 ResultSet  resultSet=c.statement.executeQuery(qeury);
//                 Store again in the table
                 table.setModel(DbUtils.resultSetToTableModel(resultSet));

             } catch(SQLException se){
                 se.printStackTrace();
             }
         } else if(e.getSource()==printbtn){
             try{
                 table.print();

             } catch (Exception ee){
                 ee.printStackTrace();
             }
         } else if(e.getSource()==updatebtn){

           //  setVisible(false);
//             here we can use frame of the update class

         } else {
             setVisible(false);
             new Main();

         }

     }

    public  static void main(String[] args) {
        new viewemployee();

    }
}
