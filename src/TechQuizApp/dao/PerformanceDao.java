/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.connection.ConnectionClass;
import TechQuizApp.pojo.PerformancePojo;
import TechQuizApp.pojo.ResultPojo;
import TechQuizApp.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author india
 */
public class PerformanceDao 
{
    public static boolean addPerformance(PerformancePojo pp)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into performance_table values(?,?,?,?,?,?,?)");
        ps.setString(1, pp.getUserId());
        ps.setString(2, pp.getSubject());
        ps.setString(3 , pp.getExamId());
        ps.setInt(4, pp.getRight());
        ps.setInt(5 , pp.getWrong());
        ps.setInt(6 , pp.getUnattempted());
        ps.setDouble(7 , pp.getPercenteges());
       int i = ps.executeUpdate();
        if(i==1)
            return true;
        return false;
        
        
        
    }
    public static ArrayList<String> getAllIdsByIUserId(String userId)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select exam_id from performance_table where user_id=?");
        ps.setString(1,userId);
        ResultSet rs = ps.executeQuery();
        ArrayList<String> al = new ArrayList<>();
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        return al;
        
    }
    public static String getSubject (String examId)throws SQLException
    {
         Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select exam_subject from performance_table where exam_id=? and user_id=?");
        ps.setString(1,examId);
        ps.setString(2, UserProfile.getUserNameInProfile());
        ResultSet rs = ps.executeQuery();
       rs.next();
       
        return rs.getString(1);
}
      public static double getPercentage (String examId)throws SQLException
    {
         Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select percentages from performance_table where exam_id=? and user_id=?");
        ps.setString(1,examId);
        ps.setString(2, UserProfile.getUserNameInProfile());
        ResultSet rs = ps.executeQuery();
       rs.next();
       
        return rs.getDouble(1);
}
       public static ArrayList<String>getAllStudentIds()throws SQLException
      {
      Connection conn = ConnectionClass.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select distinct user_id from performance_table");
      ArrayList<String> al = new ArrayList<>();
    
      while(rs.next())
      
      {
     al.add(rs.getString(1));
      }
      
       return al;
      }
       public static ResultPojo getSingleResult(String examId , String userId)throws SQLException
       {
           Connection conn = ConnectionClass.getConnection();
           PreparedStatement ps = conn.prepareStatement("select exam_subject  , percentages from performance_table where exam_id=? and user_id=?");
           ps.setString(1, examId);
           ps.setString(2, userId);
           ResultSet rs = ps.executeQuery();
           rs.next();
           ResultPojo rp  =new ResultPojo();
           rp.setSubject(rs.getString(1));
           rp.setPercentages(rs.getDouble(2));
           return rp;
       }
       public static ArrayList<PerformancePojo> getAllStudentsResult()throws SQLException
       {
           Connection conn = ConnectionClass.getConnection();
           PreparedStatement ps = conn.prepareStatement("select * from performance_table");
           ResultSet rs = ps.executeQuery();
           ArrayList<PerformancePojo> al = new ArrayList<>();
           while(rs.next())
           {
               PerformancePojo pp = new PerformancePojo();
              pp.setUserId( rs.getString(1));
               pp.setSubject(rs.getString(2));
               pp.setSubject(rs.getString(3));
               pp.setRight(rs.getInt(4));
               pp.setWrong(rs.getInt(5));
               pp.setUnattempted(rs.getInt(6));
               pp.setPercenteges(rs.getDouble(7));
               al.add(pp);
           }
           return al;
       }
}
