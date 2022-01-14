package com.bdse.pfs.summative.PhaseII;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleAns {
    public static int getSingleAns() {
        Scanner getAnswer = new Scanner(System.in);
        String[] PossibleAns = {"A","B","C","D"};
        Pattern AnsRegex = Pattern.compile("[a-dA-D]");
        String Answer = getAnswer.next();
        int AnsKey;
        Matcher match = AnsRegex.matcher(Answer);
        boolean matchFound = match.find();
        if (matchFound){
            for(int i = 0; i < PossibleAns.length; i++){
                if (Answer.equalsIgnoreCase(PossibleAns[i])){
                    AnsKey = i;
                    return AnsKey;
                }
            }
        }else {
            System.out.println("enter a valid response");
            return getSingleAns();
        }

        return getSingleAns();
    }
}
