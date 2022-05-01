package com.apsancentury.projecttrackerapp;

import java.util.Scanner;

/**
 * Project Tracker is a program to plan your projects.
 * Divide your project into milestones and succed in all you do!
 * Beautiful milestone tables in your command line!
 *
 * @author Apsan Bishwokarma
 * @version 1.0
 * @since  2022-04-30
 */

public class ProjectTrackerApp {
    //using same scanner instance in this whole class
    static Scanner in = new Scanner(System.in);
    static MilestoneTracker[] mt;
    static int noMilestones;
    //save ASCII art in a String to use later in different .java files
    static String statusArt = """
                                
                 +-+-+-+-+-+-+-+ +-+-+-+-+-+-+
                 |P|r|o|j|e|c|t| |S|t|a|t|u|s|
                 +-+-+-+-+-+-+-+ +-+-+-+-+-+-+
                """;

    //My program starts here!
    public static void main(String[] args) {

        //First create an instance of ProjectTracker.
        new ProjectTracker();

        System.out.print("How many milestones? ");
        noMilestones = in.nextInt();

        //Create an array instance of MilestoneTracker class
        /* This is how I am initializing the array instance of MilestoneTracker
         *
         * static MilestoneTracker[] mt;
         * mt = new MilestoneTracker[3]; //let's have 3 milestones for example
         * mt[0] = new MilestoneTracker();
         * mt[1] = new MilestoneTracker();
         * mt[2] = new MilestoneTracker();
         *
         */

        mt = new MilestoneTracker[noMilestones + 1];
        //We need as many mt objects as the user wants.
        for (int i = 0; i < noMilestones; i++) {
            mt[i] = new MilestoneTracker();
        }
        projectCreated();
        statusprint();
    }



    //The loop that runs this program.
    //Users can edit their work, print status or exit the application.
    private static void workloop() {
        System.out.println(" 1. Edit Work \n 2. Print Status Window\n 3. Save Status Window in txt file\nor 0 to exit!");

        //Control the choices of our user
        System.out.print("\nYour choice? ");
        int input = in.nextInt();
        switch (input) {
            case 1: {
                //Edit work with changestatus()
                changestatus();
            }

            case 2: {
                //Print status window with statusprint()
                statusprint();
            }
            case 3: {
                //Save status window in txt file with CreateTxt()
                createTxt();

            }
            case 0: {
                //exits the program
                System.exit(0);
            }
        }
    }

    //statusprint() creates the status window
    private static void statusprint() {
        projectStatusart();
        //Creating an instance of CommandLineTable to have access to the beautiful table
        CommandLineTable table = new CommandLineTable();
        table.setHeaders("No.", "Title", "Description", "Hours", "Status");

        for (int i = 0; i < noMilestones; i++) {
            table.addRow("I".repeat(i+1) + ".", mt[i].title, mt[i].description, mt[i].hours + " hrs", mt[i].milestonestatus.toString());
        }
        table.print();
        System.out.print("\n");
        workloop();
    }
    //creaTxt() is the method that prints the contents in .txt
    private static void createTxt() {
        //Create an instance of WriteText.java file
        WriteText writeText = new WriteText();

        for (int i = 0; i < noMilestones; i++) {
            writeText.addRow("I".repeat(i+1) + ".", mt[i].title, mt[i].description, mt[i].hours + " hrs", mt[i].milestonestatus.toString());
        }
        workloop();
    }

    //When users choose changestatus() they can edit the status of the project.
    private static void changestatus() {
        System.out.println("Enter milestone no. press[enter] then status text ");
        int selectstatus = in.nextInt();
        selectstatus--;
        in.nextLine();

        //System.out.print("Enter Status");
        String industrialising = in.nextLine();


        mt[selectstatus].milestonestatus.replace(0,mt[selectstatus].toString().length(), industrialising);
        statusprint();
    }

    private static void projectCreated() {
        System.out.println("Congratulations!!! " + ProjectTracker.title + " created!");
        System.out.println(ProjectTracker.days + " days left!");
    }

    private static void projectStatusart() {
        System.out.print("\n");
        for (int i = 1; i < statusArt.length(); i++) {
            System.out.print(statusArt.charAt(i));
        }

    }

}

