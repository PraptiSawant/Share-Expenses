/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.group.expense.manager;
import java.sql.*;
public class DbConnect {
    Connection con=null;
    java.sql.PreparedStatement pst;
    public static Connection dbconnect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
            return con;
        }
        catch(Exception e2)
        {
            System.out.println(e2);
            return null;
        }
    }
}
