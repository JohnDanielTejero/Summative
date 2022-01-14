package com.bdse.pfs.summative.PhaseIII;


import com.bdse.pfs.summative.PhaseI.StudentProfile;

import java.util.Scanner;

public class ResultDisplay extends StudentProfile {

    public void RetrieveResult() { //Method that displays the final result

        System.out.println("Hi " + getName() + ", You answered " + getFinalPoints() +" Questions Right, " + getMistakes() +
                " Questions Wrong for a total of " + getMaxQuestion() + " Questions. You scored " + getPercentScore() + "%");

        //Feature added not in the Project Brief
        System.out.println("Do you want to see your stats? Type Y for yes and N for no");
        while(true){
            Scanner DisplayStat = new Scanner(System.in);
            String Stats = DisplayStat.next();

            if (Stats.equalsIgnoreCase("Y")){
                System.out.println("Here is the overall statistics of your MCQ test. \n");
                System.out.println(DisplayStats() + "\n");
                System.out.println("Thank you for answering, have a nice day!");
                break;
            }else if (Stats.equalsIgnoreCase("N")){
                System.out.println("Thank you for answering, have a nice day!");
                break;
            }else{
                System.out.println("Please enter an appropriate response");
            }
        }
    }

    public String DisplayStats(){ /*The String below gets returned*/
        return "Name:'" + getName() + '\'' + "\n" +
                "Subject:'" + getSubject() + '\'' + "\n"+
                "Score:" + getFinalPoints() + "/" + getMaxQuestion() + "\n" +
                "Percentage:" + getPercentScore() + "%";
    }

}
