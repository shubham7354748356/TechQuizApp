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
public class QuestionsDetailPojo 
{

    public QuestionsDetailPojo() {
    }

    public QuestionsDetailPojo(String question, String option1, String option2, String option3, String option4, int Qnunmber, String examId, String answer, String subject) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.Qnunmber = Qnunmber;
        this.examId = examId;
        this.answer = answer;
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getQnunmber() {
        return Qnunmber;
    }

    public void setQnunmber(int Qnunmber) {
        this.Qnunmber = Qnunmber;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int Qnunmber;
    private String examId;
    private String answer;
    private String subject;
   
}
