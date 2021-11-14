/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

import java.util.ArrayList;

/**
 *
 * @author india
 */
public class ArrayListClass 
{
    private ArrayList<QuestionsDetailPojo> al;
   public ArrayListClass()
    {
        al = new ArrayList<>();
    }
   public void add(QuestionsDetailPojo qdp)
   {
       al.add(qdp);
       System.out.println("question setted successfully");
         
   }
    public QuestionsDetailPojo get(int questionNumber)
    {
        return al.get(questionNumber);
    }
    public ArrayList<QuestionsDetailPojo> getQuestions()
    {
        return al;
    }
    public void removeElement(int pos)
    {
        al.remove(pos);
    }
    public int getCount()
    {
        return al.size();
    }
    public void setQuestionAt(QuestionsDetailPojo qdp , int pos)
    {
        al.add(pos, qdp);
    }
    public QuestionsDetailPojo getElementByQuestionNumber(int questionNumber)
    {
        for(QuestionsDetailPojo qdp : al)
        {
            if(qdp.getQnunmber()==questionNumber)
                return qdp;
        }
        return null;
    }
}
