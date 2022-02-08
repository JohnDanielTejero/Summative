package com.pfs.bdse.summative;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionSets{

    private String Subject;
    private ArrayList<String> Questions = new ArrayList<>();
    private ArrayList<String> Choices = new ArrayList<>();
    private ArrayList<String> Answers = new ArrayList<>();

    //changes additions
    private int Mistakes = 0;
    private double PercentScore;
    private int MaxQuestion;
    private int Correct;
    private String[][] Display;

    //setter

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setAnswers(ArrayList<String> answers) {
        Answers = answers;
    }

    public void setChoices(ArrayList<String> choices) {
        Choices = choices;
    }

    public void setQuestions(ArrayList<String> questions) {
        Questions = questions;
    }

    //getter
    public String getSubject() {
        return Subject;
    }

    public int getCorrect() {
        return Correct;
    }

    public int getMistakes() {
        return Mistakes;
    }

    public double getPercentScore() {
        return PercentScore;
    }

    public int getMaxQuestion() {
        return MaxQuestion;
    }

    public String[][] getDisplay() {
        return Display;
    }

    public void questionAnswer(){
        MaxQuestion = Questions.size()-1;
        Display = new String[Questions.size()][7];
        Display[0][0] = "Questions";
        Display[0][1] ="A";
        Display[0][2] ="B";
        Display[0][3] ="C";
        Display[0][4] ="D";
        Display[0][5] ="ChosenAnswer";
        Display[0][6] = "Decision";

        int Counter = 1;
        while(Counter <= MaxQuestion){
            String[] ListOfAns = (Choices.get(Counter)).split("-"); /*Splits the string retrieved into an array*/
            String [] Answer = (Answers.get(Counter)).split("-"); /*Splits the string retrieved into an array*/
            System.out.println();
            System.out.println(Counter + ". "+ Questions.get(Counter));
            Display[Counter][0] = Counter + ". "+ Questions.get(Counter);
            System.out.println("a. "+ ListOfAns[0] + "\nb. "+ ListOfAns[1] +
                    "\nc. "+ ListOfAns[2] + "\nd. "+ ListOfAns[3] + "\n");
            Display[Counter][1] = "a. "+ ListOfAns[0];
            Display[Counter][2] = "b. "+ ListOfAns[1];
            Display[Counter][3] = "c. "+ ListOfAns[2];
            Display[Counter][4] = "d. "+ ListOfAns[3];

            ArrayList<Integer> GetAnswer = takeAnswer(Answer.length);
            int Checking = 0;
            int CorrectCount = 0;
            ArrayList<Integer> AnswerRecord = new ArrayList<>();

            while (Checking < Answer.length){
                for (int i = 0; i <= Answer.length - 1; i++){
                    if (ListOfAns[GetAnswer.get(i)].equalsIgnoreCase(Answer[Checking])){
                        AnswerRecord.add(GetAnswer.get(i));
                        CorrectCount++;
                        break;
                    }else{
                        continue;
                    }
                }
                if (Display[Counter][5] == null){
                    Display[Counter][5] = ListOfAns[GetAnswer.get(Checking)];
                }else{
                    Display[Counter][5] +=", " + ListOfAns[GetAnswer.get(Checking)];
                }
                Checking++;

            }

            if (CorrectCount == Answer.length){
                if (Answer.length == 1){
                    System.out.print("Your answer is ");
                    for (int i = 0; i < AnswerRecord.size(); i++){
                        System.out.print(ListOfAns[AnswerRecord.get(i)] + " and it is correct.");
                    }
                    System.out.println();
                }else{
                    System.out.print("Your answers are ");
                    for (int i = 0; i < AnswerRecord.size(); i++){
                        if (i < AnswerRecord.size() - 1){
                            System.out.print(ListOfAns[AnswerRecord.get(i)] + ", ");
                        }else{
                            System.out.print("and " + ListOfAns[AnswerRecord.get(i)] + " and it is correct.");
                        }
                    }
                    System.out.println();
                }
                Display[Counter][6] = "Correct";
            }else{
                if (Answer.length == 1){
                    System.out.print("Wrong, the correct answer is ");
                    for (int i = 0; i < Answer.length; i ++){
                        System.out.print(Answer[i]);
                    }
                    System.out.println();
                }else{
                    System.out.print("Wrong, the correct answers are ");
                    for (int i = 0; i < Answer.length; i++){
                        if (i < Answer.length - 1){
                            System.out.print(Answer[i] + ", ");
                        }else{
                            System.out.print("and " + Answer[i] + ".");
                        }
                    }
                    System.out.println();
                }
                //additions
                Mistakes++;
                Display[Counter][6] = "Wrong";
            }

            AnswerRecord.clear();
            Counter++;
        }
        //additions
        Correct = MaxQuestion -Mistakes;
        PercentScore = Math.round(((Double.valueOf(Correct)/MaxQuestion)*100)*100/100);

    }
    public static ArrayList<Integer> takeAnswer(int anslength){
        Scanner getAnswer = new Scanner(System.in);
        String [] PossibleAns = {"A","B","C","D"};
        Pattern AnsRegex = Pattern.compile("[a-dA-D]");
        ArrayList <Integer> Anskey = new ArrayList<>();
        ArrayList<String> StoredAns = new ArrayList<>();
        int Counter = 1;

        while (Counter <= anslength){
            String Answer = getAnswer.next();
            Matcher match = AnsRegex.matcher(Answer);
            boolean matchFound = match.find();

            if (Answer.length()== 1){
                if (matchFound){
                    if (Anskey.size() == 0){
                        for (int i = 0; i < PossibleAns.length; i++){
                            if(Answer.equalsIgnoreCase(PossibleAns[i])){
                                StoredAns.add(Answer);
                                Anskey.add(i);
                                break;
                            }
                        }
                    }else{
                        for(int i = 0; i < StoredAns.size(); i++){
                            if(Answer.equalsIgnoreCase(StoredAns.get(i))){
                                System.out.println("enter a new response");
                                return takeAnswer(anslength);
                            }
                        }

                        for(int i = 0; i < PossibleAns.length; i++){
                            if(Answer.equalsIgnoreCase(PossibleAns[i])){
                                StoredAns.add(Answer);
                                Anskey.add(i);
                                break;
                            }
                        }
                    }
                }else{
                    System.out.println("enter a new response");
                    return takeAnswer(anslength);
                }
            }else{
                System.out.println("enter a new response");
                return takeAnswer(anslength);
            }

            Counter++;
        }
        return Anskey;
    }

    public void DisplayRes(String [][]display){
        for (int i =0; i < display.length; i++){
            if (i == 0){
                System.out.println("The format is as follows: ");
            }
            for (int j = 0; j < 7; j++){
                System.out.println(display[i][j]);
            }
            System.out.println();
        }
    }
}
