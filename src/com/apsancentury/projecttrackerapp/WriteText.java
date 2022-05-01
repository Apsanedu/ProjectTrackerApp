package com.apsancentury.projecttrackerapp;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


/**
 * Project Tracker is a program to plan your projects.
 * Divide your project into milestones and succeed in all you do!
 * Beautiful milestone tables in your command line!
 *
 * @author Apsan Bishwokarma
 * @version 1.0
 * @since  2022-04-30
 */

public class WriteText{
    public static PrintWriter printWriter;

    //WriteText() constructor
    public WriteText() {
        try{
            //create an instance of PrintWriter class
            printWriter = new PrintWriter(ProjectTracker.title +".txt");

            //accessing static variables from ProjectTracker.java and pring in the file
            printWriter.print(ProjectTracker.art);
            printWriter.println(ProjectTracker.title + "!");
            printWriter.println(ProjectTracker.projectdescription);
            printWriter.println("Start date: " +ProjectTracker.startDate + "\n End date: " + ProjectTracker.endDate);
            printWriter.println("You have " +ProjectTracker.days + " days left.!\n\n");
            printWriter.println(ProjectTrackerApp.statusArt);
            //Important to flush and close File classes
            printWriter.flush();
        }
        //File classes need an exception handler to work.
        //Print the exception e in terminal
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addRow(String noMilestone, String title, String description, String s1, String status) {
        try{
            //initializing FileWriter instance to append to an already existing txt file
            FileWriter fileWriter= new FileWriter(ProjectTracker.title +".txt", true);
            //initialize PrintWriter from FileWriter instance
            PrintWriter printWriter1 = new PrintWriter(fileWriter);

            //Print text in txt file
            printWriter1.println("Milestone " +noMilestone);
            printWriter1.println("\tTitle: \t" +title);
            printWriter1.println("\tDescription: \t" +description);
            printWriter1.println("\tHours: " +s1);
            printWriter1.println("\tStatus: \t" +status);
            printWriter1.println("\n");

            //Important to flush and close File classes
            printWriter1.flush();
            fileWriter.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



}