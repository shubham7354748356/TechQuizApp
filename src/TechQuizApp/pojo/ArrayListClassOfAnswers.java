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
public class ArrayListClassOfAnswers 
{
    private ArrayList<AnswersDetailPojo> al;
    public ArrayListClassOfAnswers()
    {
        al = new ArrayList<>();
    }
    public void addAnswer(AnswersDetailPojo adp)
    {
       al.add(adp);
    }
    public AnswersDetailPojo getAnswersDetailPojoByQuestionNumber(int questionNumber)
    {
       for(AnswersDetailPojo a : al)
       {
           if(a.getQuestionNumber()==questionNumber)
               return a;
       }
       System.out.println("nothing will found");
       return null;
    }
    public void removeAtIndex(int pos)
    {
        al.remove(pos);
    }
    public void addAtIndex(int pos , AnswersDetailPojo a)
    {
        al.add(pos, a);
    }
    public int getAllQuestionsCount()
    {
        return al.size();
    }
    public AnswersDetailPojo getAnswersDetailPojoByAnswersObject(AnswersDetailPojo obj)
    {
        System.out.println("fetching answre detail pojo");
        for(AnswersDetailPojo ad : al)
        {
            if(ad.equals(obj))
                    return ad;
                    
        }
        System.out.println("nothing is found");
        return null;
    }
    public ArrayList<AnswersDetailPojo> getAllObjects ()
    {
        return al;
    }
}
