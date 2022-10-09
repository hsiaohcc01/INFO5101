/**
 *  Assignment 4
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

import java.util.*;

public class main {

    public static void main(String[] args) {

        // Create an object of the weightedgrade class
        weightedgrade wg = new weightedgrade();

        // Get user input of Number of Assignments
        Scanner user_input = new Scanner(System.in);
        System.out.println("Please Enter Number of Assignments: ");
        String arraySize = user_input.nextLine();

        // Get user input of Point Total
        System.out.println("Please enter Point Total of " + arraySize + " Assignments: ");
        String points = user_input.nextLine();
        // Remove all whitespace from user input
        String newPoints = points.replaceAll(" ", "");
        // Create a new list to storage the Total Point
        ArrayList<String> point = new ArrayList<>(Arrays.asList(newPoints.split(",")));
        // Check if input is not grater than arraySize
        if (point.size() > Integer.valueOf(arraySize)){
            System.out.println("The number of input Point total can't over " + arraySize + ". Please start over.");
            System.exit(0);
        }

        // Get user input of Earned Point
        System.out.println("Please enter Earned Point of " + arraySize + " Assignments: ");
        String earns = user_input.nextLine();
        // Remove all whitespace from user input
        String newEarns = earns.replaceAll(" ", "");
        // Create a new list to storage the Earned Point
        ArrayList<String> earned = new ArrayList<>(Arrays.asList(newEarns.split(",")));
        // Check if input is not grater than arraySize
        if (earned.size() > Integer.valueOf(arraySize)){
            System.out.println("The number of input Earned Point can't over " + arraySize + ". Please start over.");
            System.exit(0);
        }

        // Get user input of Assigment Percentage
        System.out.println("Please enter Assigment Percentage(%) of "+arraySize+" Assignments: ");
        String percents = user_input.nextLine();
        // Remove all whitespace from user input
        String newPercents = percents.replaceAll(" ", "");
        // Create a new list to storage the Assigment Percentage
        ArrayList<String> percent = new ArrayList<>(Arrays.asList(newPercents.split(",")));
        // Check if input is not grater than arraySize
        if (percent.size() > Integer.valueOf(arraySize)){
            System.out.println("The number of Assigment Percentage can't over " + arraySize + ". Please start over.");
            System.exit(0);
        }

        // Calculate Total Weighted Grade that using for loop
        for(int i = 0; i < Integer.valueOf(arraySize); i ++) {
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
