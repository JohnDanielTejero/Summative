package com.pfs.bdse.summative;

import java.io.File;
import java.util.ArrayList;

public class Student extends StudentProfile{
    private String InitialResultMessage;
    private ArrayList<QuestionSets> AnsweredSets = new ArrayList<>();

    public Student() {
        super();
    }

    public void selectSubject(){
        File Files = new File("src\\com\\pfs\\bdse\\summative\\Questionnaires");
        String [] PathNames = Files.list();
        while (true){
            int counter = 1;
            ArrayList<String> SubjectValidator = new ArrayList<>();
            for (String pathname : PathNames){
                String Subjects = pathname.substring(0, pathname.lastIndexOf("."));
                SubjectValidator.add(Subjects);
                System.out.println(counter + ".) " + Subjects);
                counter++;
            }

            System.out.println("Please enter the name of the subject");
            String ChooseSubject = Input.next();
            Boolean SubjectValidate = validateSubject(SubjectValidator, ChooseSubject);

            if (SubjectValidate){
                this.setChosenSubject(ChooseSubject);
                break;
            }else{
                System.out.println("enter a valid response");
            }
        }
    }

    @Override
    public void startTest() {
        RetrieveQuestion newQuestion = new RetrieveQuestion();
        newQuestion.retrieve(this.getChosenSubject());
        newQuestion.questionAnswer();
        //addition
        AnsweredSets.add(newQuestion);
        setQuestionnaires(AnsweredSets);
        InitialResultMessage ="Hi " + this.getStudentName() + ", You answered " +
                newQuestion.getCorrect() +" Questions Right, " + newQuestion.getMistakes() +
                " Questions Wrong for a total of " + newQuestion.getMaxQuestion() +
                " Questions. You scored " + newQuestion.getPercentScore() + "%";
    }

    private Boolean validateSubject(ArrayList<String> subjectValidator, String chooseSubject) {
        for(int i = 0;  i < subjectValidator.size(); i++){
            if (chooseSubject.equals(subjectValidator.get(i))){
                return true;
            }
        }
        return false;
    }

    //addition
    public void getResult() {
      if (getQuestionnaires().size()<1){
          System.out.println("Take atleast one MCQ test first");
      }else{
          System.out.println(InitialResultMessage);
          System.out.println("\ndo you want to see your statistics? Type y for yes, n for no.");
          String Response = Input.next();
          while (true){
              if (Response.length()==1){
                  if (Response.equalsIgnoreCase("y")){
                      GetStats();
                      System.out.println("Thank you and have a nice day!");
                  }else if(Response.equalsIgnoreCase("n")){
                      System.out.println("Thank you and have a nice day!");
                      break;
                  }else{
                      System.out.println("please enter an appropriate Response");
                  }
              }else{
                  System.out.println("Do not exceed 1 character.");
              }
          }
      }
    }

    private void GetStats() {
        Boolean HasSubject = false;
        while (!HasSubject){
            System.out.println("Choose a Subject Set Taken:");
            for (QuestionSets Answered: getQuestionnaires()){
                System.out.println(Answered.getSubject());
            }
            String RetrieveSubject = Input.next();
            for(QuestionSets Answered: getQuestionnaires()){
                if (RetrieveSubject.equalsIgnoreCase(Answered.getSubject())){
                    System.out.println("Name: " + this.getStudentName() + "\n" +
                            "Subject: " + Answered.getSubject() + "\n");
                    Answered.DisplayRes(Answered.getDisplay());
                    HasSubject = true;
                }else{
                    System.out.println("This set does not exist");
                }
            }
        }
    }
}
