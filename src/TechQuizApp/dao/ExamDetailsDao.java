/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.connection.ConnectionClass;
import TechQuizApp.pojo.ExamDetailsPojo;
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
public class ExamDetailsDao {
    public static int getExamIdFromTable()throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        Statement st  = conn.createStatement();
        ResultSet rs = st.executeQuery("select count(*) from exam_detail");
        rs.next();
        return rs.getInt(1);
    }
    public static void setExam(ExamDetailsPojo edp) throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into exam_detail values(?,?,?)");
        ps.setString(1, edp.getExamId());
        ps.setString(2, edp.getExamSubject());
        ps.setInt(3, edp.getQnumbers());
        ps.executeQuery();
    }
    public static ArrayList<String> getAllExamIdFromSubject(String subject)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select exam_id from exam_detail where exam_subject=? minus select exam_id from performance_table where exam_subject=? and user_id=?");
        ps.setString(1, subject);
        ps.setString(2, subject);
        ps.setString(3, UserProfile.getUserNameInProfile());
        ResultSet rs = ps.executeQuery();
        ArrayList<String> al = new ArrayList<>();
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        return al;
    }
    public static int getQuerstionsNumberFromId(String id)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select exam_questions from exam_detail where exam_id=?");
        ps.setString(1, id);;
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
        
    }
    public static int getQuestionCountFromId(String id)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select exam_questions from exam_detail where exam_id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
             
    }
}
