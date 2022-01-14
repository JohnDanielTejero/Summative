package com.bdse.pfs.summative.PhaseI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RetrieveQuestion extends StudentProfile{

    //Instantiation
    private static String line = "";
    private static String splitBy = ",";
    private static ArrayList<String> questions = new ArrayList<String>();
    private static ArrayList<String> choices = new ArrayList<String>();
    private static ArrayList<String> answers = new ArrayList<String>();

    public void retrieve(){
        try{
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\bdse\\pfs\\summative\\questions\\" + super.getSubject() + ".csv"));
            while ((line = br.readLine()) != null) { //returns a Boolean value
                String[] qna = line.split(splitBy); //used comma as separator
                //[Question, Choices, Answer]

                questions.add(qna[0]); /*Stores the questions to the arraylist*/
                choices.add(qna[1]); /*Stores the choices to the arraylist*/
                answers.add(qna[2]); /*Stores the answers to the arraylist*/
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        //sets the StudentProfile variables to gathered arraylists of their respective type
        setQuestions(questions);
        setChoices(choices);
        setAnswers(answers);

    }

}

