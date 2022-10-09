/**
 *  Assignment 4
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

public class weightedgrade {

    private int pointTotal;
    private int earnedPoints;
    private double assignmentPercent;
    // Initialize Total Weighted Grade as 0
    private double totalWeightedGrade = 0;

    // Set the Total Point
    public void setPointTotal(int pointTotal){
        this.pointTotal = pointTotal;
    }

    // Get the Total Point
    public int getPointTotal(){
        return pointTotal;
    }

    // Set the Earned Point
    public void setEarnedPoints(int earnedPoints){
        this.earnedPoints = earnedPoints;
    }

    // Get the Earned Point
    public int getEarnedPoints(){
        return earnedPoints;
    }

    // Set the Assigment Percentage
    public void setAssigmentPercentage(double assignmentPercent){
        this.assignmentPercent = assignmentPercent;
    }

    // Get the Assigment Percentage
    public double getAssigmentPercentage(){
        return assignmentPercent;
    }

    // Set the Total Weighted Grade
    public void setTotalGrade(int pointTotal, int earnedPoints, double assignmentPercent) {
        this.totalWeightedGrade = totalWeightedGrade+((float)earnedPoints/pointTotal)*assignmentPercent;
    }

    // Get the Total Weighted Grade
    public double getTotalGrade(){
        return totalWeightedGrade;
    }

    // Get the result of Letter Grade by Total Weighted Grade
    public char LetterGarde(double totalWeightedGrade){
        char grade;

        if (totalWeightedGrade >= 90){
            grade = 'A';
        } else if (totalWeightedGrade>= 80) {
            grade = 'B';
        } else if (totalWeightedGrade>= 70) {
            grade = 'C';
        } else if (totalWeightedGrade>= 60) {
            grade = 'D';
        }else{
            grade = 'F';
        }
        return grade;
    }
}
