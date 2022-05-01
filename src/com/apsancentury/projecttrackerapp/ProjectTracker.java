package com.apsancentury.projecttrackerapp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

public class ProjectTracker {

    //save ASCII art in a static String to use later in different .java files
    static String art = """
                                

            8888888b.                   d8b                   888         88888888888                       888                      \s
            888   Y88b                  Y8P                   888             888                           888                      \s
            888    888                                        888             888                           888                      \s
            888   d88P 888d888 .d88b.  8888  .d88b.   .d8888b 888888          888  888d888 8888b.   .d8888b 888  888  .d88b.  888d888\s
            8888888P"  888P"  d88""88b "888 d8P  Y8b d88P"    888             888  888P"      "88b d88P"    888 .88P d8P  Y8b 888P"  \s
            888        888    888  888  888 88888888 888      888             888  888    .d888888 888      888888K  88888888 888    \s
            888        888    Y88..88P  888 Y8b.     Y88b.    Y88b.           888  888    888  888 Y88b.    888 "88b Y8b.     888    \s
            888        888     "Y88P"   888  "Y8888   "Y8888P  "Y888          888  888    "Y888888  "Y8888P 888  888  "Y8888  888    \s
                                        888                           +-+-+-+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+ +-+-+-+                                 \s
                                       d88P                           |S|u|c|c|e|s|s| |i|n| |a|l|l| |y|o|u| |d|o|!|                                 \s
                                     888P"                            +-+-+-+-+-+-+-+ +-+-+ +-+-+-+ +-+-+-+ +-+-+-+                                \s
                                                                                                                                
                                                                                                                               
                                                                                        
                 """;

    static String art1 = """
                          
            +-+-+-+-+-+-+ +-+-+-+-+-+-+-+
            |C|r|e|a|t|e| |P|r|o|j|e|c|t|
            +-+-+-+-+-+-+ +-+-+-+-+-+-+-+
                           
            """;
    static String title;
    static String projectdescription;
    static long days;
    static String startDate;
    static String endDate;

    public ProjectTracker() {
        //Print the beautiful ASCII art
        projectASCII();

        //Ask the user for inputs about project
        projectIntialize();
    }

    private void projectIntialize() {

        Scanner in = new Scanner(System.in);


        System.out.print("Project Title: ");
        ProjectTracker.title = in.nextLine();

        System.out.print("Project description: ");
        ProjectTracker.projectdescription = in.nextLine();

        System.out.print("Start Date [yyyy-mm-dd format]: ");
        startDate = in.nextLine();

        System.out.print("End Date [yyyy-mm-dd format]: ");
        endDate = in.nextLine();
        System.out.println("\n");

        //get no.OfDaysBetween
        ProjectTracker.days = getNoOfDaysBetween();

    }

    //Print the beautiful ASCII art
    private void projectASCII() {
        for (int i = 1; i < art.length(); i++) {
            System.out.print(art.charAt(i));
        }
        for (int i = 1; i < art1.length(); i++) {
            System.out.print(art1.charAt(i));
        }
    }

    //Calculate the number of days between two days
    private long getNoOfDaysBetween() {
        LocalDate dateBefore = LocalDate.parse(startDate);
        LocalDate dateAfter = LocalDate.parse(endDate);

        return ChronoUnit.DAYS.between(dateBefore, dateAfter);
    }
}
