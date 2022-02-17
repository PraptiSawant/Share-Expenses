/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.group.expense.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Prapti sawant
 */
public class ExpenseReport extends javax.swing.JFrame {

    /**
     * Creates new form ExpenseReport
     */
    Connection con=DbConnect.dbconnect();
    String e[]=new String[20];
    int j=0,c=0,count=0;
    
    public ExpenseReport() {
        initComponents();
        try{  
            PreparedStatement pst=con.prepareStatement("SELECT count(*) FROM event");
            ResultSet rs=pst.executeQuery();
        
         while(rs.next())
        { 
            count=rs.getInt(1);
            System.out.println(count);
         
        }
                }catch(Exception e)
      {
          System.out.println(e);
      }  
        try{ 
            int i=0;
            
            PreparedStatement pst=con.prepareStatement("SELECT `event` FROM event");
            ResultSet rs=pst.executeQuery();
        
         while(rs.next())
        { 
            e[i]=rs.getString(1);
            i++;
        
        }
                }catch(Exception e)
      {
          System.out.println(e);
      }  
        display.setText(display.getText()+"List of Events /Groups \n");
        for(int k=0;k<count;k++)
        {
            for(j=0;j<k;j++)
            {
                if(e[k].equals(e[j]))
                {
                   break;
                }
            }
            if(k==j)
               display.setText(display.getText()+""+e[k]+"\n"); 
        }
        
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        event_text = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(166, 171, 253));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 88));
        jLabel1.setText("GROUP EXPENSE REPORT");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 88));
        jLabel2.setText("Event/Group Name:");

        event_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event_textActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("ViEW REPORT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        display.setColumns(20);
        display.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        display.setRows(5);
        jScrollPane3.setViewportView(display);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(261, 261, 261)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(jButton1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(28, 28, 28)
                                        .addComponent(event_text, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(event_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try{ 
            int sum=0;
            int y[];
            y=new int[20];
            String fname[]=new String[100];
            String lname[]=new String[100];
            String category[]=new String[100];
            float expense[]=new float[100];
            String gn="null";
            int n=0;
            int i=0;
            String d="null";
            int no=0;
            int id=0;
            float total_amount=0;
          
        String e=event_text.getText();
        PreparedStatement pst=con.prepareStatement("select * from event where event=? ");
        pst.setString(1,e);
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        { 
            gn=rs.getString(2);
            d=rs.getString(3);
            no=rs.getInt(4);
            id=rs.getInt(1);
            fname[i]=rs.getString(5);
            lname[i]=rs.getString(6);
            category[i]=rs.getString(7);
            expense[i]=rs.getFloat(8);
            total_amount=total_amount+expense[i];
            i++;
            
        }
        jTextArea1.setText(jTextArea1.getText()+"GROUP/EVENT NAME:   "+gn+"\nEVENT DATE:   "+d+"\nNO OF MEMBERS:   "+no+"\n-------------------------------------------------------------------------------------------------------------\nMEMBER FIRST NAME\tMEMBER LAST NAME\tCATEGORY\tTOTAL EXPENDITURE\n");
        System.out.println(c);
        for(i=0;i<no;i++)
        {
        jTextArea1.setText(jTextArea1.getText()+fname[i]+"\t\t"+lname[i]+"\t\t"+category[i]+"\t"+expense[i]+"\n");
            
        }  
        jTextArea1.setText(jTextArea1.getText()+"-----------------------------------------------------------------------------------------\n                                                        EXPENSE REPORT                                             \nGROUP'S TOTAL EXPENDITURE :  "+total_amount+"\nOn Splitting each group member should pay : "+(total_amount/no)+"\n-----------------------------------------------------------------------------------------------------------------------------\n");
        for(int j=0;j<no;j++)
           {
               float s=(total_amount/no)-expense[j];
               if(s>0)
               {
                   jTextArea1.setText(jTextArea1.getText()+""+fname[j]+"  "+lname[j]+"\nTOTAL EXPENSE = "+expense[j]+"\tCHARGED = "+(total_amount/no)+"\tPAID LESS ="+s+"\n\n");
               }
               else
                   jTextArea1.setText(jTextArea1.getText()+""+fname[j]+"  "+lname[j]+"\nTOTAL EXPENSE = "+expense[j]+"\tCHARGED = "+(total_amount/no)+"\tPAID EXTRA ="+(-(s))+"\n\n");
           }
           
           
      }catch(Exception e)
      {
          System.out.println(e);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void event_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_event_textActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePage b=new HomePage();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpenseReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea display;
    private javax.swing.JTextField event_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
