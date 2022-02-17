/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.group.expense.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarGraphView implements ActionListener{
    Connection con=DbConnect.dbconnect();
    String fname[]=new String[100];
    String lname[]=new String[100];
        int no=0; 
        int sum=0;
        int expense[]=new int[100];
     
            
        JButton b1=new JButton("ENTER");
    JFrame f1=new JFrame();
    JLabel l1=new JLabel("Event/Group Name :");
        JTextField event_text=new JTextField();
        
        JPanel p=new JPanel(){
        public void paint(Graphics g){
            int l=0;
            g.drawLine(20,20,20,550);
            g.drawLine(20,550,900,550);
            for(int j=0;j<no;j++)
            {
                try{
             g.setColor(Color.BLUE);
            g.fillRect(20,40+l,((expense[j])),40);
            g.setColor(Color.WHITE);
            g.drawString(fname[j],30, 53+l);
            l=l+80;
            }catch(Exception ev)
    {}
            
        }
            
            
        }
    };

    
    public BarGraphView(){
    b1.addActionListener(this);
    
        
       
        p.setLayout(null);
       p.setBounds(10,80,1200,620);
       l1.setBounds(200,40,300,25);
       b1.setBounds(300,80,100,25);
        l1.setFont(new Font("Verdana",Font.PLAIN,15));
        
       event_text.setBounds(400,40,200,20);
        f1.add(b1);
        f1.add(l1);
        f1.getContentPane().add(p);
        f1.add(event_text);
        f1.setLayout(null);
        f1.setSize(1200,700);
        f1.setVisible(true);
}
    
    public static void main(String args[])
    {
        
         BarGraphView r=new BarGraphView();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource().equals(b1))
        {
         try{ 
           System.out.println("hello");
           int i=0;
           String e=event_text.getText();
           PreparedStatement pst=con.prepareStatement("SELECT `firstname`, `lastname`,`amount`,`nm` FROM `event` WHERE event=? ");
           pst.setString(1,e);
           System.out.println("hello");
           ResultSet rs=pst.executeQuery();
        while(rs.next())
        { 
             no=rs.getInt(4);
            fname[i]=rs.getString(1);
            lname[i]=rs.getString(2);
            expense[i]=rs.getInt(3);
            sum=sum+expense[i];
            i++;
            
        }     
      }catch(Exception e)
      {
          System.out.println(e);
      }
         for(int j=0;j<no;j++)
            {
         System.out.println(expense[j]);
        }
            
            
        }
         
    }

}