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
public class LoginPage implements ActionListener{
    
    Connection con=DbConnect.dbconnect();
    
    JFrame f1=new JFrame("SHARE EXPENSES");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JButton login=new JButton("Login");
    JButton signup=new JButton("Sign Up");
    JLabel title=new JLabel("Login");
    JLabel email=new JLabel("Email:");
    JLabel password=new JLabel("Password:");
    JLabel new_user=new JLabel("Don't have an account ?");
    JLabel icon=new JLabel(new ImageIcon("D:\\sw.jpg"));
    JTextField emailtext=new JTextField();
    JPasswordField passtext=new JPasswordField();
    LoginPage(){
        
        login.addActionListener(this);
        signup.addActionListener(this);
       
        email.setBounds(560,200,50,20);
        password.setBounds(560,300,100,20);
        emailtext.setBounds(710,200,150,25);
        passtext.setBounds(710,300,150,25);
        login.setBounds(650,400,100,25);
        signup.setBounds(740,465,100,25);
        p1.setBounds(0,0,455,604);
        title.setBounds(640,100,100,50);
        new_user.setBounds(540,465,200,20);
        icon.setBounds(120,150,200,200);
        
        p1.setBackground(new Color(166,171,253));
        f1.getContentPane().setBackground(new Color(0,0,88));
        
        email.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        new_user.setForeground(Color.WHITE);
        
        email.setFont(new Font("Verdana",Font.PLAIN,15));
        password.setFont(new Font("Verdana",Font.PLAIN,15));;
        title.setFont(new Font("Verdana",Font.PLAIN,25));
        new_user.setFont(new Font("Verdana",Font.PLAIN,15));        
        
        p1.setLayout(null);
        
        f1.add(p1);
        f1.add(title);
        f1.add(email);
        f1.add(password);
        f1.add(passtext);
        f1.add(emailtext);
        f1.add(login);
        f1.add(signup);
        f1.add(new_user);
        p1.add(icon);
        f1.setLayout(null);
        f1.setSize(955,604);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource().equals(login))
        {
            try
            {
                String e=emailtext.getText();
                String p=String.valueOf(passtext.getPassword());
        PreparedStatement pst=con.prepareStatement("select * from user where email=? and password=?");
        pst.setString(1,e);
        pst.setString(2,p);
        ResultSet r=pst.executeQuery();
        if(r.next())
        {
           JOptionPane.showMessageDialog(null,"Login Successful");
           HomePage h=new HomePage();
           
        }
        else
            JOptionPane.showMessageDialog(null,"Entered wrong data Try again");
        }
        catch(Exception e)
        {
            
        }
        }
        else 
        {
              SignUpPage b=new SignUpPage();
             
        }
        
    }
    public static void main(String args[]){
    
       LoginPage b=new  LoginPage();
    }
    
}
