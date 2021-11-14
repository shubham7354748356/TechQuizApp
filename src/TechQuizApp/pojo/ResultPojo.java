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
public class ResultPojo
{

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPercentages() {
        return percentages;
    }

    public void setPercentages(double percentages) {
        this.percentages = percentages;
    }
    private String subject;
    private double percentages;
    
}
