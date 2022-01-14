package com.bdse.pfs.summative.PhaseI;

import com.bdse.pfs.summative.Info;

public class StudentProfile extends Info {

    //Instantiation
    private static double PercentScore;
    private static int FinalPoints;
    private static int Mistakes = 0;
    private static int MaxQuestion;

    //setter
    public static void setMaxQuestion(int maxQuestion) {
        MaxQuestion = maxQuestion;
    }

    public static void setMistakes(int mistakes) {
        Mistakes = mistakes;
    }

    public static void setFinalPoints(int finalPoints) {
        FinalPoints = finalPoints;
    }

    public static void setPercentScore(double percentScore) {
        PercentScore = percentScore;
    }

    //getter
    public static int getFinalPoints() {
        return FinalPoints;
    }

    public static double getPercentScore() {
        return PercentScore;
    }

    public static int getMaxQuestion() {
        return MaxQuestion;
    }

    public static int getMistakes() {
        return Mistakes;
    }

    @Override
    public void getInformation() {
        InformationGather GatherInformation = new InformationGather(); //Instantiate Gathering Class
        GatherInformation.informations(); //Calls on information gathering method
        RetrieveQuestion RetrieveSet = new RetrieveQuestion(); //Instantiate Gathering Class
        RetrieveSet.retrieve(); //Calls on information gathering method
    }
}
