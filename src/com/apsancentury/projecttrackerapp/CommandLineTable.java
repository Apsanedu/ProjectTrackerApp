package com.apsancentury.projecttrackerapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project Tracker is a program to plan your projects.
 * Divide your project into milestones and succeed in all you do!
 * Beautiful milestone tables in your command line!
 *
 * The beautiful table for status window happens in this class
 *
 * @author Apsan Bishwokarma
 * @version 1.0
 * @since  2022-04-30
 */
public class CommandLineTable {
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private final List<String[]> rows = new ArrayList<>();

    public CommandLineTable() {
        setShowVerticalLines(true);
    }

    //More options on the VerticalLines
    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    //setHeaders prints the main row
    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    //add as much rows as you want in the table
    public void addRow(String... cells) {
        rows.add(cells);
    }

    //the main method that handles all other print lines
    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        //headers is the main row. If there's no header then here's the alternative
        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }

        //a cell is an item in a row
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    //
    //prints the command line table around the text
    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }
    //a cell is an item in a row
    //This is where the data printing happens
    private void printRow(String[] cells, int[] maxWidths) {
        //loop on each cell in a row
        for (int i = 0; i < cells.length; i++) {
            //Store each cell as a string.
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);

        }
        System.out.println();
    }

}