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
import javax.swing.*;
public class SignUpPage implements ActionListener{
    
    Connection con=DbConnect.dbconnect();
    
    JFrame f1=new JFrame("SHARE EXPENSES");
    
    JPanel p1=new JPanel();
    
    JButton signup=new JButton("Sign Up");
    
    JLabel title=new JLabel("Sign Up");
    JLabel firstname=new JLabel("First Name:");
    JLabel lastname=new JLabel("Last Name:");
    JLabel email=new JLabel("Email:");
    JLabel password=new JLabel("Password:");
    JLabel icon=new JLabel(new ImageIcon("D:\\sw.jpg"));
    
    JTextField first_name_text=new JTextField();
    JTextField last_name_text=new JTextField();
    JTextField email_text=new JTextField();
    JPasswordField pass_text=new JPasswordField();
    SignUpPage(){
        
        signup.addActionListener(this);
       
        
        title.setBounds(680,100,100,50);
        firstname.setBounds(560,200,100,20);
        lastname.setBounds(560,250,100,20);
        email.setBounds(560,300,50,20);
        password.setBounds(560,350,100,20);
        
        first_name_text.setBounds(710,200,150,25);
        last_name_text.setBounds(710,250,150,25);
        email_text.setBounds(710,300,150,25);
        pass_text.setBounds(710,350,150,25);
        signup.setBounds(680,465,100,25);
        p1.setBounds(0,0,455,604);
        icon.setBounds(120,150,200,200);
        
        p1.setBackground(new Color(166,171,253));
        f1.getContentPane().setBackground(new Color(0,0,88));
        
        email.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        firstname.setForeground(Color.WHITE);
        lastname.setForeground(Color.WHITE);
       
        email.setFont(new Font("Verdana",Font.PLAIN,15));
        password.setFont(new Font("Verdana",Font.PLAIN,15));
        title.setFont(new Font("Verdana",Font.PLAIN,25));
        firstname.setFont(new Font("Verdana",Font.PLAIN,15));
        lastname.setFont(new Font("Verdana",Font.PLAIN,15));
        signup.setFont(new Font("Verdana",Font.PLAIN,15));
             
        
        p1.setLayout(null);
        
        f1.add(p1);
        f1.add(title);
        f1.add(email);
        f1.add(password);
        f1.add(pass_text);
        f1.add(email_text);
        f1.add(first_name_text);
        f1.add(signup);
        f1.add(last_name_text);
        f1.add(firstname);
        f1.add(lastname);
        p1.add(icon);
        f1.setLayout(null);
        f1.setSize(955,604);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource().equals(signup))
        {
            try{  
        String f=first_name_text.getText();
        String l=last_name_text.getText();
        String e=email_text.getText();
        String p=String.valueOf(pass_text.getPassword());
        PreparedStatement pst=con.prepareStatement("insert into user(firstname,lastname,email,password) values(?,?,?,?)");
        pst.setString(1,f);
        pst.setString(2,l);
        pst.setString(3,e);
        pst.setString(4,p);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registration Successful");
        first_name_text.setText(" ");
        last_name_text.setText(" ");
        email_text.setText(" ");
        pass_text.setText(" ");
        LoginPage b=new  LoginPage();
        
      }catch(Exception e)
      {
          System.out.println(e);
      }
            
        }
        
    }
    public static void main(String args[]){
    
       SignUpPage b=new SignUpPage();
    }
    
}

