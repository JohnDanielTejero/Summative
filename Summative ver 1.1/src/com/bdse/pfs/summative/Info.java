package com.bdse.pfs.summative;

import java.util.ArrayList;

public abstract class Info {

    //Instantiation
    private static String Name;
    private static String Subject;
    private static ArrayList<String> Questions = new ArrayList<String>();
    private static ArrayList<String> Choices = new ArrayList<String>();
    private static ArrayList<String> Answers = new ArrayList<String>();



    //setter
    public static void setName(String name) {
        Name = name;
    }
    public static void setSubject(String subject) {
        Subject = subject;
    }
    public static void setQuestions(ArrayList<String> questions) {
        Questions = questions;
    }
    public static void setAnswers(ArrayList<String> answers) {
        Answers = answers;
    }
    public static void setChoices(ArrayList<String> choices) {
        Choices = choices;
    }


    //getter
    public static String getName() {
        return Name;
    }
    public static String getSubject() {
        return Subject;
    }

    public ArrayList<String> getQuestions() {
        return Questions;
    }
    public ArrayList<String> getChoices() {
        return Choices;
    }
    public ArrayList<String> getAnswers() {
        return Answers;
    }

    public abstract void getInformation();
}
