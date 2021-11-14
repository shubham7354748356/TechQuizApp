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
public class PerformancePojo 
{

    public PerformancePojo() {
    }

    public PerformancePojo(String userId, String examId, String subject, int right, int wrong, int unattempted, double percenteges) {
        this.userId = userId;
        this.examId = examId;
        this.subject = subject;
        this.right = right;
        this.wrong = wrong;
        this.unattempted = unattempted;
        this.percenteges = percenteges;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getUnattempted() {
        return unattempted;
    }

    public void setUnattempted(int unattempted) {
        this.unattempted = unattempted;
    }

    public double getPercenteges() {
        return percenteges;
    }

    public void setPercenteges(double percenteges) {
        this.percenteges = percenteges;
    }
    private String userId;
    private String examId;
    private String subject;
    private int right;
    private int wrong;
    private int unattempted;
    private double percenteges;
    
}
