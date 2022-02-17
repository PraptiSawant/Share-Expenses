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
import javax.swing.*;
public class HomePage implements ActionListener{
    
    Connection con=DbConnect.dbconnect();
        
    JFrame f1=new JFrame("SHARE EXPENSES");
    JPanel p1=new JPanel();
    JButton b1=new JButton(new ImageIcon("D:\\c.jpg"));
    JButton b2=new JButton(new ImageIcon("D:\\e.jpg"));
    JButton b3=new JButton(new ImageIcon("D:\\a.jpg"));
    JButton b4=new JButton(new ImageIcon("D:\\d.jpg"));
    JButton b5=new JButton(new ImageIcon("D:\\v.jpg"));
    JButton b6=new JButton(new ImageIcon("D:\\v.jpg"));
    JButton b7=new JButton(new ImageIcon("D:\\r.jpg"));
    
    JLabel title=new JLabel("WELCOME TO SHARE EXPENSES");
    JLabel l1=new JLabel("Create a Group");
    JLabel l2=new JLabel("Add Expenses");
    JLabel l3=new JLabel("View all Groups");
    JLabel l4=new JLabel("Delete Member Record");
    JLabel l5=new JLabel("Group Expense Report");
    JLabel l6=new JLabel("Graphical View");
    JLabel l7=new JLabel("About Application");
   JLabel l9=new JLabel("About");
   
    HomePage(){
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    
       
        title.setBounds(200,30,600,50);
        l1.setBounds(40,140,200,20);
        l2.setBounds(240,140,200,20);
        l3.setBounds(440,140,200,20);
        l4.setBounds(605,140,200,20);
        l5.setBounds(100,295,200,20);
        l6.setBounds(300,295,300,20);
        l9.setBounds(240,295,200,20);
        l7.setBounds(500,295,200,20);
       
        
        
        
        b1.setBounds(20,20,180,120);
        b2.setBounds(215,20,180,120);
        b3.setBounds(410,20,180,120);
        b4.setBounds(605,20,180,120);
        b5.setBounds(100,174,180,120);
        b6.setBounds(290,174,180,120);
        b7.setBounds(480,174,180,120);
      
        
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.WHITE);
        b5.setBackground(Color.WHITE);
        b6.setBackground(Color.WHITE);
        b7.setBackground(Color.WHITE);

        
        p1.setBounds(60,100,800,350);
        
        p1.setLayout(new GridLayout());
       
        
        p1.setBackground(new Color(0,0,88));
        f1.getContentPane().setBackground(new Color(166,171,253));
        
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l7.setForeground(Color.WHITE);
        
        title.setForeground(new Color(0,0,88));
       
        
        l1.setFont(new Font("Verdana",Font.BOLD,15));
        l2.setFont(new Font("Verdana",Font.BOLD,15));
        l3.setFont(new Font("Verdana",Font.BOLD,15));
        l4.setFont(new Font("Verdana",Font.BOLD,15));   
        l5.setFont(new Font("Verdana",Font.BOLD,15));
        l6.setFont(new Font("Verdana",Font.BOLD,15));
        l7.setFont(new Font("Verdana",Font.BOLD,15));
     
        title.setFont(new Font("Verdana",Font.BOLD,30));
        
         
        
        p1.setLayout(new BorderLayout());
        
        f1.add(p1);
        f1.add(title);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);

        p1.add(l5);
 
        p1.add(l6);
        p1.add(l7);
        p1.add(l9);
       
        f1.setLayout(null);
        f1.setSize(955,604);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource().equals(b1))
        {
            CreateGroup b=new  CreateGroup();
        }
        else if(evt.getSource().equals(b2))
        {
            AddExpense a=new AddExpense();
            a.setVisible(true);
        }
        else if(evt.getSource().equals(b3))
        {
            ViewAllTheGroups v=new ViewAllTheGroups();
            v.setVisible(true);
        }
        else if(evt.getSource().equals(b4))
        {
            DeleteMemberRecord d=new  DeleteMemberRecord();
            d.setVisible(true);
        }
        else if(evt.getSource().equals(b5))
        {
            ExpenseReport r=new ExpenseReport();
            r.setVisible(true);
        }
        else if(evt.getSource().equals(b6))
        {
               BarGraphView g=new BarGraphView();
           
        }
        else
        {
            About t=new About();
            t.setVisible(true);
        }
    }
    public static void main(String args[]){
    
       HomePage b=new  HomePage();
    }
    
}

