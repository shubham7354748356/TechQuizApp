/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.connection.ConnectionClass;
import TechQuizApp.pojo.LoginDetailsPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author india
 */
public class LoginDao 
{
    public static boolean validateLogin(LoginDetailsPojo lp)throws SQLException
    {
        Connection conn   = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from Login_table where user_name=? and user_password=? and user_type=?");
        ps.setString(1, lp.getName());
        ps.setString(2,lp.getPassword());
        ps.setString(3, lp.getUser_type());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public static boolean registerStudent(LoginDetailsPojo ldp)throws SQLException
    {
        Connection conn= ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into login_table values(?,?,?)");
        ps.setString(1, ldp.getName());
        ps.setString(2, ldp.getPassword());
        ps.setString(3, ldp.getUser_type());
        int i =ps.executeUpdate();
        return i==1;
    }
    public static boolean updatePassword(LoginDetailsPojo p)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("update login_table set user_password=? where user_name=? and user_type='Student'");
        ps.setString(1, p.getPassword());
        ps.setString(2, p.getName());
        int i = ps.executeUpdate();
        return i==1;
    }
    
}
