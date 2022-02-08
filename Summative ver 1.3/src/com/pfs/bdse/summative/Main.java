package com.pfs.bdse.summative;

/*
 * MCQ Test System
 *
 * Version:      1.3
 * Author:       John Daniel M. Tejero
 * Date Created: 2/8/22
 *
 * Changelogs:
 *
 * As of February 8, 2022
 * - Student can now select multiple questionnaires
 * - Classes are compressed to reasonable amount
 * - Result can be retrieved anytime as long as the user took at least one set
 * - Removed unnecessary classes and functions
 *
 * */
public class Main{
    public static void main(String[] args) {

        Student Davis = new Student(); /*Instantiation*/
        newTest(Davis);/*Starts new Test MCQ*/
        newTest(Davis);
        Davis.getResult();/*Get the result*/
        Davis.getResult();

    }

    public static void newTest(Student student){
        student.selectSubject(); /*Set the current subject*/
        student.startTest();/*Start the test*/
    }
}
