/**
 *  Assignment 3
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

import java.util.*;

public class main {

    public static void main(String[] args) {

        // Create an object of the weightedgrade class
        weightedgrade wg = new weightedgrade();

        // Get user input of Total Point
        Scanner user_input = new Scanner(System.in);
        System.out.println("Please Enter Point Total of 8 Assignments: ");
        String points = user_input.nextLine();
        // Remove all whitespace from user input
        String newPoints = points.replaceAll(" ", "");
        // Create a new list to storage the Total Point
        ArrayList<String> point = new ArrayList<>(Arrays.asList(newPoints.split(",")));

        // Get user input of Earned Point
        System.out.println("Please Enter Earned Point of 8 Assignments: ");
        String earns = user_input.nextLine();
        // Remove all whitespace from user input
        String newEarns = earns.replaceAll(" ", "");
        // Create a new list to storage the Earned Point
        ArrayList<String> earned = new ArrayList<>(Arrays.asList(newEarns.split(",")));

        // Get user input of Assigment Percentage
        System.out.println("Please Enter Assigment Percentage(%) of 8 Assignments: ");
        String percents = user_input.nextLine();
        // Remove all whitespace from user input
        String newPercents = percents.replaceAll(" ", "");
        // Create a new list to storage the Assigment Percentage
        ArrayList<String> percent = new ArrayList<>(Arrays.asList(newPercents.split(",")));
        user_input.close();

        // Calculate Total Weighted Grade that using for loop
        for(int i = 0; i < 8; i ++) {
            wg.setTotalGrade(Integer.valueOf(point.get(i)),
                            Integer.valueOf(earned.get(i)),
                            Integer.valueOf(percent.get(i)));
        }

        // Show the final result of Total Grade and Letter Grade
        System.out.println("======== Final Result ========");
        System.out.println("Total Grade = " + wg.getTotalGrade());
        System.out.println("Letter Grade = " + wg.LetterGarde(wg.getTotalGrade()));
    }
}
