/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dao;

import TechQuizApp.connection.ConnectionClass;
import TechQuizApp.pojo.ArrayListClass;
import TechQuizApp.pojo.ExamDetailsPojo;
import TechQuizApp.pojo.QuestionsDetailPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author india
 */
public class QuestionListDao 
{
    public static void fillQuestions(ArrayListClass obj)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into question_set values(?,?,?,?,?,?,?,?,?)");
        ArrayList<QuestionsDetailPojo> al = obj.getQuestions();
        for(QuestionsDetailPojo qdp:al)
        {
            ps.setString(1, qdp.getExamId());
              ps.setString(2, qdp.getSubject());
                ps.setInt(3, qdp.getQnunmber());
                  ps.setString(4, qdp.getQuestion());
                    ps.setString(5, qdp.getOption1());
                      ps.setString(6, qdp.getOption2());
                        ps.setString(7, qdp.getOption3());
                          ps.setString(8, qdp.getOption4());
                            ps.setString(9, qdp.getAnswer());
                            ps.executeUpdate();
        }
    
}
    public static ArrayList<QuestionsDetailPojo> getAllQuestionsFromExamId(String ExamId)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from question_set where exam_id=?");
        ps.setString(1,ExamId);
        ResultSet rs = ps.executeQuery();
        ArrayList<QuestionsDetailPojo> al = new ArrayList<>();
        while(rs.next())
        {
            QuestionsDetailPojo edp = new QuestionsDetailPojo();
            edp.setQuestion(rs.getString(4));
            edp.setExamId(rs.getString(1));
            edp.setSubject(rs.getString(2));
            edp.setQnunmber(rs.getInt(3));
            edp.setOption1(rs.getString(5));
            edp.setOption2(rs.getString(6));
            edp.setOption3(rs.getString(7));
            edp.setOption4(rs.getString(8));
            edp.setAnswer(rs.getString(9));
            al.add(edp);
                   
        }
        return al;
        
        
    }
    public static void fillAllQuestionsAgain(ArrayListClass obj)throws SQLException
    {
        Connection conn = ConnectionClass.getConnection();
        PreparedStatement ps = conn.prepareCall("update question_set set question=? , option_1=? , option_2=? , option_3=? , option_4=? , correct_answer=? where exam_id=? and question_number=? ");
        for(QuestionsDetailPojo qdp : obj.getQuestions())
        {
            ps.setString(1, qdp.getQuestion());
            ps.setString(2, qdp.getOption1());
            ps.setString(3, qdp.getOption2());
            ps.setString(4, qdp.getOption3());
            ps.setString(5, qdp.getOption4());
            ps.setString(6, qdp.getAnswer());
            ps.setString(7 ,qdp.getExamId() );
            ps.setInt(8, qdp.getQnunmber());
            ps.executeQuery();
            
        }
    }   
}
