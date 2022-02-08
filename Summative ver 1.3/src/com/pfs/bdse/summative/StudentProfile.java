package com.pfs.bdse.summative;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class StudentProfile {
    private String StudentName;
    private String ChosenSubject;
    private ArrayList<QuestionSets> Questionnaires = new ArrayList<>();
    Scanner Input = new Scanner(System.in);

     public StudentProfile(){
         while(true){
             System.out.println("Enter your Name to get started.");
             String Name = Input.nextLine();
             Boolean NameValidate = validateName(Name);

             if (NameValidate){
                 this.setStudentName(Name);
                 break;
             }else{
                 System.out.println("Enter a valid name");
             }
         }
    }
    //setter


    public void setQuestionnaires(ArrayList<QuestionSets> questionnaires) {
        Questionnaires = questionnaires;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setChosenSubject(String chosenSubject) {
        ChosenSubject = chosenSubject;
    }


    //getter

    public String getStudentName() {
        return StudentName;
    }

    public String getChosenSubject() {
        return ChosenSubject;
    }
    public ArrayList<QuestionSets> getQuestionnaires() {
        return Questionnaires;
    }


    public boolean validateName(String name){
        return name.matches("[A-Z][a-z]*");
    }
    public abstract void startTest();

}
