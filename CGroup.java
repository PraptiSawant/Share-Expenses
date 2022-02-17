/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.group.expense.manager;

/**
 *
 * @author Prapti sawant
 */import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class CGroup implements ActionListener{
    
    Connection con=DbConnect.dbconnect();
    
    JFrame f1=new JFrame("SPLIT PAY");
    JPanel p1=new JPanel();
    
    JButton add_members=new JButton("ADD MEMBERS");
    JButton create_group=new JButton("CREATE GROUP");
    
    JLabel title=new JLabel("Login");
    JLabel event=new JLabel("Event Name:");
    JLabel date=new JLabel("Date Of Event:");
    JLabel nm=new JLabel("No Of Members:");
    JLabel mfname=new JLabel("Members First Name:");
    JLabel mlname=new JLabel("Members Last Name:");
    JLabel category=new JLabel("Category:");
    JLabel amount=new JLabel("Amount Spent:");
    JLabel text=new JLabel("Once Done Adding members click --->");
    JLabel t=new JLabel("O");
    
    JTextField event_text=new JTextField();
    JTextField date_text=new JTextField();
    JTextField nm_text=new JTextField();
    JTextField mfname_text=new JTextField();
    JTextField mlname_text=new JTextField();
    JTextField category_text=new JTextField();
    JTextField amount_text=new JTextField();
    
    
    CGroup(){
        
        add_members.addActionListener(this);
        create_group.addActionListener(this);
       
        p1.setBackground(new Color(0,0,88));
        f1.getContentPane().setBackground(new Color(166,224,58));
        p1.setBounds(60,100,800,400);
        
        event.setBounds(150,50,200,20);
        date.setBounds(150,90,200,20);
        nm.setBounds(150,130,200,20);
        mfname.setBounds(150,170,200,20);
        mlname.setBounds(150,210,200,20);
        category.setBounds(150,250,200,20);
        amount.setBounds(150,290,200,20);
        title.setBounds(370,40,100,50);
        text.setBounds(190,498,300,20);
        
        create_group.setBounds(520,501,200,25);
        add_members.setBounds(310,350,100,25);
        
        event_text.setBounds(350,50,250,20);
        date_text.setBounds(350,90,250,20);
        nm_text.setBounds(350,130,250,20);
        mfname_text.setBounds(350,170,250,20);
        mlname_text.setBounds(350,210,250,20);
        category_text.setBounds(350,250,250,20);
        amount_text.setBounds(350,290,250,20);
      
       
        
        
     
        
         event.setForeground(Color.WHITE);
        date.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        
        
         event.setFont(new Font("Verdana",Font.PLAIN,15));
        date.setFont(new Font("Verdana",Font.PLAIN,15));;
        title.setFont(new Font("Verdana",Font.PLAIN,25));
        nm.setFont(new Font("Verdana",Font.PLAIN,15));
        mfname.setFont(new Font("Verdana",Font.PLAIN,15)); 
        mlname.setFont(new Font("Verdana",Font.PLAIN,15)); 
        category.setFont(new Font("Verdana",Font.PLAIN,15)); 
        amount.setFont(new Font("Verdana",Font.PLAIN,15)); 
        text.setFont(new Font("Verdana",Font.PLAIN,15)); 
        
        p1.setLayout(new BorderLayout());
        
        f1.add(p1);
        p1.add(title);
        p1.add(event);
        p1.add(date);
        p1.add(nm);
        p1.add(mfname);
        p1.add(mlname);
        p1.add(category);
        
        f1.add(title);
        p1.add(event_text);
        p1.add(date_text);
        p1.add(nm_text);
        p1.add(amount);
        p1.add(mfname_text);
        p1.add(mlname_text);
        p1.add(category_text);
        p1.add(amount_text);
        p1.add(add_members);
        f1.add(create_group);
        f1.add(text);
        p1.add(t);
        
        
        f1.setLayout(null);
        f1.setSize(955,604);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource().equals(add_members))
        {
            try
            {
                String e=event_text.getText();
                String d=date_text.getText();
                String n=nm_text.getText();
                String mf=mfname_text.getText();
                String ml=mlname_text.getText();
                String c=category_text.getText();
                String a=amount_text.getText();
        PreparedStatement pst=con.prepareStatement("insert into event(event,date,nm,firstname,lastname,cat,amount) values(?,?,?,?,?,?,?)");
        pst.setString(1,e);
        pst.setString(2,d);
        pst.setString(3,n);
        pst.setString(4,mf);
        pst.setString(5,ml);
        pst.setString(6,c);
        pst.setString(7,a);
       
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"data added");
   
     
        }
        catch(Exception e)
        {
            
        }
           
        }
         else
        {
                    
            System.out.println("err");
        }
        
        
    }
    public static void main(String args[]){
    
       CreateGroup b=new  CreateGroup();
    }
    
}
