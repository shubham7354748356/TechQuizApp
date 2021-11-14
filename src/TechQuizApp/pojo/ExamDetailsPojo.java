/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

/**
 *
 * @author india
 */
public class ExamDetailsPojo 
{

    public ExamDetailsPojo() {
    }

    public ExamDetailsPojo(String examId, String examSubject, int Qnumbers) {
        this.examId = examId;
        this.examSubject = examSubject;
        this.Qnumbers = Qnumbers;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public int getQnumbers() {
        return Qnumbers;
    }

    public void setQnumbers(int Qnumbers) {
        this.Qnumbers = Qnumbers;
    }
    private String examId;
    private String examSubject;
    private int Qnumbers;
    
}
