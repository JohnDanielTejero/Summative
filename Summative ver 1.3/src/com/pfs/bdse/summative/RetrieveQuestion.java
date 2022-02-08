package com.pfs.bdse.summative;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RetrieveQuestion extends QuestionSets {

    public static String line ="";
    public static String SplitBy = ",";
    private ArrayList<String> Questionsbuffer = new ArrayList<>();
    private ArrayList<String> Choicesbuffer = new ArrayList<>();
    private ArrayList<String> Answersbuffer = new ArrayList<>();

    public void retrieve(String currentsubject){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\pfs\\bdse\\summative\\Questionnaires\\" + currentsubject + ".csv"));
            while((line = br.readLine()) != null) {
                System.out.println();
                String[] qna = line.split(SplitBy);
                Questionsbuffer.add(qna[0]);
                Choicesbuffer.add(qna[1]);
                Answersbuffer.add(qna[2]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        this.setSubject(currentsubject);
        this.setQuestions(Questionsbuffer);
        this.setChoices(Choicesbuffer);
        this.setAnswers(Answersbuffer);
    }

}