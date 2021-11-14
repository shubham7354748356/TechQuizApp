/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author india
 */
public class ConnectionClass 
{
    private static Connection conn;
    static
    {
        try
        {
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-KPOQTE2:1521/XE" , "advancejavabatch" , "123");
       
        
        }
        catch(ClassNotFoundException cnf)
        {
            JOptionPane.showMessageDialog(null, "unable to load the driver");
        }
        catch(SQLException sq)
        {
            JOptionPane.showMessageDialog(null, "poblem with the data base");
            sq.printStackTrace();
        }
    }
    public static Connection getConnection ()
    {
        return conn;
    }
    public static void closeConnection()
    {
        if(conn!=null)
        {
            try
            {
                conn.close();
               
            }
            catch(SQLException sq)
            {
                JOptionPane.showMessageDialog(null, "unable to close the connection");
            }
           
        }
    }
    
}
