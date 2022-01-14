/*
* MCQ Test System
*
* Version:      1.1
* Author:       John Daniel Tejero
* Date Created: 1/14/22
*
* Changelogs:
* -Created an abstract class which holds the name and the subject question set
* -Created a class called StudentProfile that contains the statistics of the student
* -Changed the overall structure of the code
* -Reduced Unnecessary instantiation of variable.
*
* */

package com.bdse.pfs.summative;

import com.bdse.pfs.summative.PhaseI.StudentProfile;
import com.bdse.pfs.summative.PhaseIII.ResultDisplay;
import static com.bdse.pfs.summative.PhaseII.QuestionAndAnswer.promptQuestion;

public class Main {
    public static void main(String[] args){

        //getting information
        StudentProfile Student = new StudentProfile(); /*Instantiation of new Student Class*/
        Student.getInformation(); /*Gather Information and store it on Info class*/

        //question and answer
        promptQuestion(Student.getQuestions(), Student.getChoices(), Student.getAnswers());
        /* Calls the method promptQuestion on QuestionAndAnswer Class
        *
        * It iterates all the question until the loop breaks
        * Stores the score gathered on StudentProfile
        *
        * */

        //result
        ResultDisplay DisplayProfile = new ResultDisplay(); /* instantiate ResultDisplay*/
        DisplayProfile.RetrieveResult(); /* display result */

    }
}
