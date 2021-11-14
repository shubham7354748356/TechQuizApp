/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.gui;

import TechQuizApp.dao.PerformanceDao;
import TechQuizApp.dao.QuestionListDao;
import TechQuizApp.pojo.AnswersDetailPojo;
import TechQuizApp.pojo.ArrayListClass;
import TechQuizApp.pojo.ArrayListClassOfAnswers;
import TechQuizApp.pojo.ExamDetailsPojo;
import TechQuizApp.pojo.PerformancePojo;
import TechQuizApp.pojo.QuestionsDetailPojo;
import TechQuizApp.pojo.UserProfile;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author india
 */
public class TakeExamFrame extends javax.swing.JFrame {
    private Color old;
  private QuestionsDetailPojo qdp;  
  private ArrayListClass alc;
  private ExamDetailsPojo edp;
  private int questionNumber;
  private ArrayListClassOfAnswers alcoa;
  private int pos;
  private String question;
  private String option1;
  private String option2;
  private String option3;
  private String option4;
  private String correctAnswer;
  private String choosenAnswer;
  private AnswersDetailPojo adp;

    /**
     * Creates new form TakeExamFrame
     */
    public TakeExamFrame() {
        initComponents();
        this.setTitle("TECHQUIZ APP");
        this.setLocationRelativeTo(null);
            jlblUserName.setText("HELLO "+UserProfile.getUserNameInProfile().toUpperCase());
            old = jlblLogout.getForeground();
            JOptionPane.showMessageDialog(null , "YOU HAVE ONLY 10 MINUTES TO COMPLETE THIS EXAM\nAFTER THE TIME THE EXAM WILL BE SAVED SUCCESSFULLY" , "TIME" , JOptionPane.INFORMATION_MESSAGE);
            
            alc = new ArrayListClass();
            alcoa = new ArrayListClassOfAnswers();
            questionNumber = 1;
            
            jlblQuestionNumber.setText("QUESTION NUMBER :- "+questionNumber);
           
    }
    public TakeExamFrame(ExamDetailsPojo edp)
    {
        this();
        this.edp = edp;
         loadQuestions();
         System.out.println("questionsLoaded Successfully");
         showQuestions();
         Tim t = new Tim();
         t.start();
    }
    class Tim extends Thread{
        int sec=0;
        int min=0;
        String str="";
        public void run()
        {
            for(;;)
            {
               str = min+":";
                if(sec<10)
                    str=str+"0";
                str = str+sec;
                jlblTime.setText(str);
                if(min==10)
                    break;
                sec++;
                if(sec>59)
                {
                    sec=0;
                    min = min+1;
                }
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ei)
                {
                    ei.printStackTrace();
                }
                sec++;
                if(sec>59)
                {
                    sec=0;
                    min++;
                }
            }
            donePaper();
        }
    }
    public void loadQuestions()
    {
       try
       {
          ArrayList<QuestionsDetailPojo> al = QuestionListDao.getAllQuestionsFromExamId(edp.getExamId());
          if(al.isEmpty())
          {
               JOptionPane.showMessageDialog(null, "NO QUESTION FOUND" , "EXAM" , JOptionPane.INFORMATION_MESSAGE);
              return;
          }
          for(QuestionsDetailPojo q : al)
          {
              alc.add(q);
             // JOptionPane.showMessageDialog(null, "question added");
          }
       }
       catch(SQLException sq)
       {
           JOptionPane.showMessageDialog(null, "PROBLEM WITH THE DATABASE" , "ERROR" , JOptionPane.ERROR_MESSAGE);
           sq.printStackTrace();
       }
    }
    private void showQuestions()
    {
       
        buttonGroup1.clearSelection();
        qdp = alc.getElementByQuestionNumber(questionNumber);
        question = qdp.getQuestion();
        option1 = qdp.getOption1();
        option2 = qdp.getOption2();
        option3 = qdp.getOption3();
        option4 = qdp.getOption4();
        jtaQuestions.setText(question);
        jrbOption1.setText(option1);
        jrbOption2.setText(option2);
        jrbOption3.setText(option3);
        jrbOption4.setText(option4);
        correctAnswer = qdp.getAnswer();
        AnswersDetailPojo obj = alcoa.getAnswersDetailPojoByQuestionNumber(questionNumber);
        
        if(obj!=null)
        {
            
            String str = obj.getChoosenAnswer();
            System.out.println("str got "+str);
            switch(str)
            {
                case "Answer-1":
                    jrbOption1.setSelected(true);
                    break;
                case "Answer-2" :
                     jrbOption2.setSelected(true);
                    break;
                case "Answer-3":
                     jrbOption3.setSelected(true);
                    break;
                case "Answer-4":
                     jrbOption4.setSelected(true);
            }
        }

        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlblUserName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaQuestions = new javax.swing.JTextArea();
        jrbOption1 = new javax.swing.JRadioButton();
        jrbOption2 = new javax.swing.JRadioButton();
        jrbOption3 = new javax.swing.JRadioButton();
        jrbOption4 = new javax.swing.JRadioButton();
        jbtnNext = new javax.swing.JButton();
        jbtnPrevious = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jbtnDone = new javax.swing.JButton();
        jlblQuestionNumber = new javax.swing.JLabel();
        jlblLogout = new javax.swing.JLabel();
        jlblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 114, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(808, 472));

        jlblUserName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblUserName.setForeground(new java.awt.Color(255, 255, 255));

        jtaQuestions.setColumns(20);
        jtaQuestions.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtaQuestions.setRows(5);
        jScrollPane1.setViewportView(jtaQuestions);

        buttonGroup1.add(jrbOption1);
        jrbOption1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbOption1.setForeground(new java.awt.Color(255, 255, 255));
        jrbOption1.setText("jRadioButton1");

        buttonGroup1.add(jrbOption2);
        jrbOption2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbOption2.setForeground(new java.awt.Color(255, 255, 255));
        jrbOption2.setText("jRadioButton2");
        jrbOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOption2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbOption3);
        jrbOption3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbOption3.setForeground(new java.awt.Color(255, 255, 255));
        jrbOption3.setText("jRadioButton3");
        jrbOption3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOption3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbOption4);
        jrbOption4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jrbOption4.setForeground(new java.awt.Color(255, 255, 255));
        jrbOption4.setText("jRadioButton4");
        jrbOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOption4ActionPerformed(evt);
            }
        });

        jbtnNext.setBackground(new java.awt.Color(0, 0, 0));
        jbtnNext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnNext.setForeground(new java.awt.Color(255, 255, 255));
        jbtnNext.setText("NEXT");
        jbtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNextActionPerformed(evt);
            }
        });

        jbtnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        jbtnPrevious.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnPrevious.setForeground(new java.awt.Color(255, 255, 255));
        jbtnPrevious.setText("PREVIOUS");

        jbtnCancel.setBackground(new java.awt.Color(0, 0, 0));
        jbtnCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnCancel.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCancel.setText("CANCEL");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnDone.setBackground(new java.awt.Color(0, 0, 0));
        jbtnDone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnDone.setForeground(new java.awt.Color(255, 255, 255));
        jbtnDone.setText("DONE");
        jbtnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDoneActionPerformed(evt);
            }
        });

        jlblQuestionNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblQuestionNumber.setForeground(new java.awt.Color(255, 255, 255));

        jlblLogout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlblLogout.setForeground(new java.awt.Color(255, 255, 255));
        jlblLogout.setText("Logout");
        jlblLogout.setEnabled(false);
        jlblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlblLogoutMouseExited(evt);
            }
        });

        jlblTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTime.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbOption4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnPrevious)
                                    .addComponent(jbtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbOption1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbOption2)
                                    .addComponent(jrbOption3))
                                .addGap(0, 83, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblLogout))
                .addGap(6, 6, 6)
                .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblQuestionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jbtnNext)
                        .addGap(29, 29, 29)
                        .addComponent(jbtnPrevious)
                        .addGap(32, 32, 32)
                        .addComponent(jbtnCancel)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnDone)
                            .addComponent(jrbOption4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jrbOption1)
                        .addGap(32, 32, 32)
                        .addComponent(jrbOption2)
                        .addGap(42, 42, 42)
                        .addComponent(jrbOption3)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String getChoosenAnswer()
    {
        if(jrbOption1.isSelected())
            return "Answer-1";
        else if(jrbOption2.isSelected())
            return "Answer-2";
        else if(jrbOption3.isSelected())
            return "Answer-3";
        else if(jrbOption4.isSelected())
            return "Answer-4";
        return null;
    }
    private void jbtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNextActionPerformed
       
        if(isValidate()==true)
        {
         
            adp = new AnswersDetailPojo();
            adp.setCorrectAnswer(correctAnswer);
            adp.setExamId(qdp.getExamId());
            adp.setQuestionNumber(questionNumber);
            adp.setSubject(qdp.getSubject());
            String ans = getChoosenAnswer();
            adp.setChoosenAnswer(ans);
           
            AnswersDetailPojo ad = alcoa.getAnswersDetailPojoByQuestionNumber(questionNumber);
            
            if(ad!=null)
            {
               if(! ad.getChoosenAnswer().equals(getChoosenAnswer()));
               {
                   alcoa.removeAtIndex(pos);
                   alcoa.addAtIndex(pos, adp);
                   
               }
               
            }
            else
            alcoa.addAnswer(adp);
        }
            pos++;
            if(pos>=alc.getCount())
            {
                JOptionPane.showMessageDialog(null , "YOU HAVE DONE WITH YOUR EXAM \nPRESS DONE");
                pos=0;
            }
            questionNumber++;
            if(questionNumber>alc.getCount())
            {
                questionNumber=1;
            }
            jlblQuestionNumber.setText("QUESTION NUMBER :- "+questionNumber);
            showQuestions();
        
    }//GEN-LAST:event_jbtnNextActionPerformed
    private void donePaper()
    {
        int right=0;
        int wrong=0;
        int unattempted = 0;
        double percentages = 0.0;
        for(AnswersDetailPojo a : alcoa.getAllObjects())
        {
            if(a.getChoosenAnswer().equals(a.getCorrectAnswer()))
            {
                ++right;
            }
            else
            {
                ++wrong;
            }
        }
        unattempted = alc.getCount()-right-wrong;
        percentages =((double) right/alc.getCount())*100;
        JOptionPane.showMessageDialog(null, "RIGHT ANSWERS: "+right+"\nWRONG ANSWERS: "+wrong+"\nUNATTEMPTED: "+unattempted , "RESULT" , JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null , "YOUR PERCENTAGES IS: "+percentages , "RESULT" , JOptionPane.INFORMATION_MESSAGE);
        try
        {
            PerformancePojo pp = new PerformancePojo();
            pp.setExamId(edp.getExamId());
            pp.setSubject(edp.getExamSubject());
            pp.setRight(right);
            pp.setWrong(wrong);
            pp.setUnattempted(unattempted);
            pp.setUserId(UserProfile.getUserNameInProfile());
            pp.setPercenteges(percentages);
            boolean b = PerformanceDao.addPerformance(pp);
            if(b)
            {
                JOptionPane.showMessageDialog(null, "YOUR RESULT IS SAVED SUCCESSFULLY" , "THANKS" , JOptionPane.INFORMATION_MESSAGE);
                StudentOptionFrame sof = new StudentOptionFrame();
                sof.setVisible(true);
                this.dispose();
            }
            
        }
        catch(SQLException sq)
        {
            JOptionPane.showMessageDialog(null, "PROBLEM WITH THE DATABASE" , "ERROR" , JOptionPane.ERROR_MESSAGE);
            sq.printStackTrace();
        }
    }
    private void jbtnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDoneActionPerformed
        donePaper();
    }//GEN-LAST:event_jbtnDoneActionPerformed

    private void jrbOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOption2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbOption2ActionPerformed

    private void jrbOption3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOption3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbOption3ActionPerformed

    private void jrbOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOption4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbOption4ActionPerformed

    private void jlblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLogoutMouseClicked
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jlblLogoutMouseClicked

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        TakePaperFrame tpf = new TakePaperFrame();
        tpf.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void jlblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLogoutMouseEntered
        jlblLogout.setForeground(Color.red);
    }//GEN-LAST:event_jlblLogoutMouseEntered

    private void jlblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLogoutMouseExited
            jlblLogout.setForeground(old);
    }//GEN-LAST:event_jlblLogoutMouseExited
    private boolean isValidate()
    {
        
        if(jrbOption1.isSelected()==false&&jrbOption2.isSelected()==false&&jrbOption3.isSelected()==false&&jrbOption4.isSelected()==false)
        {
           
            return false;
        }
       return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeExamFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnDone;
    private javax.swing.JButton jbtnNext;
    private javax.swing.JButton jbtnPrevious;
    private javax.swing.JLabel jlblLogout;
    private javax.swing.JLabel jlblQuestionNumber;
    private javax.swing.JLabel jlblTime;
    private javax.swing.JLabel jlblUserName;
    private javax.swing.JRadioButton jrbOption1;
    private javax.swing.JRadioButton jrbOption2;
    private javax.swing.JRadioButton jrbOption3;
    private javax.swing.JRadioButton jrbOption4;
    private javax.swing.JTextArea jtaQuestions;
    // End of variables declaration//GEN-END:variables
}
