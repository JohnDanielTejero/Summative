package com.bdse.pfs.summative.PhaseI;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InformationGather extends StudentStat{

    public void informations(){
        //Instantiation
        boolean Named = false;
        boolean HasChosen = false;
        File files = new File ("src\\com\\bdse\\pfs\\summative\\questions"); //retrieves the path or directory
        ArrayList<String> Subj = new ArrayList<String>(); //for filename with no extension
        ArrayList<String> SubjectName = new ArrayList<String>(); //for filename with extension
        String [] pathnames = files.list(); //gets the lists of filename with extension intact in the current directory

        /* Gets all the filename with the extension and removes all the extension*/
        for (String pathname :pathnames){
            Subj.add(pathname);
            int g = pathname.lastIndexOf(".");
            SubjectName.add(pathname.substring(0,g));
        }
        Scanner Input = new Scanner(System.in);
        while (!Named){
            System.out.println("please enter your name");
            String Name = Input.next();
            boolean NameCheck = firstName(Name);
            if (NameCheck) {
                this.setName(Name); /*Stores the name in the abstract class*/
                Named = true; /*breaks the loop*/
            }else{
                System.out.println("invalid name format");
            }
        }

        while (!HasChosen){
            int SubjectCount = 1;
            System.out.println("Choose your Multiple Choice Question Set. The Options are :");
            for (int i = 0; i < SubjectName.size(); i++){
                String Subjects = SubjectName.get(i);
                System.out.println(SubjectCount + ".) " + Subjects);
                SubjectCount++;/*Increment the numbering of the subject*/
            }

            System.out.println();
            System.out.print("enter the name of the subject\t");
            String Subject = Input.next();
            boolean CheckSubject = checkSubj(SubjectName, Subject);

            if (CheckSubject){
                this.setSubject(Subject); /*Stores in the abstract class*/
                HasChosen = true; /*Breaks the loop*/
            }else{
                System.out.println("That set does not exist or is in wrong format");
            }
        }

    }
    /*Validation of name format and subject */
    private boolean checkSubj(ArrayList<String> subjectName, String subject) {
        for (int i = 0; i < subjectName.size(); i++){
            if (subject.equals(subjectName.get(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean firstName( String firstName ) {/*Checks if name is in valid format */
        return firstName.matches( "[A-Z][a-z]*" );
    }

}
