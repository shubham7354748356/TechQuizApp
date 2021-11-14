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
public class AnswersDetailPojo 
{

    public AnswersDetailPojo() {
    }

    public AnswersDetailPojo(String examId, String subject, int questionNumber, String correctAnswer, String choosenAnswer) {
        this.examId = examId;
        this.subject = subject;
        this.questionNumber = questionNumber;
        this.correctAnswer = correctAnswer;
        this.choosenAnswer = choosenAnswer;
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

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getChoosenAnswer() {
        return choosenAnswer;
    }

    public void setChoosenAnswer(String choosenAnswer) {
        this.choosenAnswer = choosenAnswer;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        AnswersDetailPojo adp = (AnswersDetailPojo) obj;
        if(this.examId.equals(adp.examId)==false)
            return false;
        if(this.choosenAnswer.equals(adp.choosenAnswer)==false)
            return false;
        if(this.correctAnswer.equals(adp.correctAnswer)==false)
            return false;
        if(this.subject.equals(adp.subject)==false)
            return false;
        if((this.questionNumber==adp.questionNumber)==false)
            return false;
        return true;
    }
    private String examId;
    private String subject;
    private int questionNumber;
    private String correctAnswer;
    private String choosenAnswer;
    
}
