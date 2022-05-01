package com.apsancentury.projecttrackerapp;

import java.util.Scanner;

/**
 * Project Tracker is a program to plan your projects.
 * Divide your project into milestones and succeed in all you do!
 * Beautiful milestone tables in your command line!
 *
 * @author Apsan Bishwokarma
 * @version 1.0
 * @since  2022-04-30
 */
public class MilestoneTracker {
    public String title;
    public int hours;
    public String description;
    //using StringBuufer because they are mutable unlike String class
    public StringBuffer milestonestatus = new StringBuffer("Not Started!");

    //MilestoneTracker() class constructor
    public MilestoneTracker() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Milestone title: ");
        title = in.nextLine();

        System.out.print("Enter description: ");
        description = in.nextLine();

        System.out.print("Enter no. of hours: ");
        hours = in.nextInt();

        System.out.println("\n");
    }


}
