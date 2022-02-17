/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.group.expense.manager;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class AddExpenses implements ActionListener{
    
    Connection con=DbConnect.dbconnect();
    
    float  iniexpense=0;
    
    JFrame f1=new JFrame("SPLIT PAY");
    JPanel p1=new JPanel();
    
    JButton b1=new JButton("DISPLAY MEMBERS LIST");
    JButton b2=new JButton("ADD EXPENSE");
    JButton b3=new JButton("GET INITIAL EXPENSE");
    
    JTextArea display=new JTextArea();
    
    JLabel title=new JLabel("Login");
    JLabel event=new JLabel("Event Name:");
    JLabel mfname=new JLabel("Members First Name:");
    JLabel mlname=new JLabel("Members Last Name:");
    JLabel amount=new JLabel("Expense:");
    JLabel t=new JLabel("O");
    
    JTextField event_text=new JTextField();
    JTextField mfname_text=new JTextField();
    JTextField mlname_text=new JTextField();
    JTextField amount_text=new JTextField();
    
    
    AddExpenses(){
        b1.setActionCommand("display");
        b2.setActionCommand("add");
        b3.setActionCommand("initial");
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        p1.setBackground(new Color(0,0,88));
        f1.getContentPane().setBackground(new Color(166,224,58));
        p1.setBounds(60,100,400,400);
        
        event.setBounds(30,50,200,20);
        mfname.setBounds(30,130,200,20);
        mlname.setBounds(30,180,200,20);
        amount.setBounds(30,290,200,20);
        title.setBounds(370,40,100,50);
        
        
        b1.setBounds(100,92,200,25);
        b2.setBounds(100,320,200,25);
        b3.setBounds(100,230,200,25);
        
        p1.setLayout(new BorderLayout());
        
        event_text.setBounds(200,50,150,20);
        mfname_text.setBounds(200,130,150,20);
        mlname_text.setBounds(200,180,150,20);
        amount_text.setBounds(200,290,150,20);
      
        event.setForeground(Color.WHITE);
        mfname.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        
        
         event.setFont(new Font("Verdana",Font.PLAIN,15));
        
        title.setFont(new Font("Verdana",Font.PLAIN,25));
       
        mfname.setFont(new Font("Verdana",Font.PLAIN,15)); 
        mlname.setFont(new Font("Verdana",Font.PLAIN,15)); 
        
        amount.setFont(new Font("Verdana",Font.PLAIN,15)); 
        
      display.setText("Member \nFirst Name \t  Last Name \t Total Expenditure\n");
      display.setBounds(500,100,400,400);
        
        f1.add(p1);
        f1.add(display);
        p1.add(title);
        p1.add(event);
        p1.add(mfname);
        p1.add(mlname);
        f1.add(title);
        p1.add(event_text);
        
        p1.add(amount);
        p1.add(mfname_text);
        p1.add(mlname_text);
     
        p1.add(amount_text);
        p1.add(b1);
        p1.add(b3);
        p1.add(b2);
        p1.add(t);
        
        
        f1.setLayout(null);
        f1.setSize(955,604);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getActionCommand().equals("add"))
        {
            try
            {
                 String e=event_text.getText();
                 PreparedStatement pst=con.prepareStatement("SELECT `firstname`, `lastname`,`amount` FROM `event` WHERE event=?");
                 pst.setString(1,e);
                ResultSet rs=pst.executeQuery();
   
     
        }
        catch(Exception ev)
        {
             System.out.println(ev);
        }
           
        }
        else if(evt.getActionCommand().equals("display"))
        {
            try
            {  
               String e=event_text.getText();
               PreparedStatement pst=con.prepareStatement("SELECT `firstname`, `lastname`,`amount` FROM `event` WHERE event=?");
               pst.setString(1,e);
               ResultSet rs=pst.executeQuery();
               while(rs.next())
        { 
            
            display.setText(display.getText()+" "+rs.getString(1)+"\t "+rs.getString(2)+"\t"+rs.getString(3)+"\n");
        }
        
             }catch(Exception e)
      {
          System.out.println(e);
      }   
            
        }
        
        
        
    }
    public void b1ActionPerformed(java.awt.event.ActionEvent evt) {                                   
       if(evt.getSource().equals(b3))
        {
            try{  
            System.out.println("hjbcskvn");
            PreparedStatement pst=con.prepareStatement("SELECT `amount` FROM `event` WHERE firstname=? and lastname=?");
            String fn=mfname_text.getText();
            String ln=mlname_text.getText();
            pst.setString(1,fn);
            pst.setString(2,ln);
            ResultSet rs=pst.executeQuery();
        
         while(rs.next())
        { 
            iniexpense=rs.getFloat(1);
            System.out.println(iniexpense);
         
        }
                }catch(Exception e)
      {
          System.out.println(e);
      }  
    }  
    }
    public static void main(String args[]){
    
       AddExpenses b=new AddExpenses();
    }
    
}
