/**
 *  Assignment 6
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

public class weightedgrade {

    private int pointTotal;
    private int earnedPoints;
    private double assignmentPercent;
    private double totalWeightedGrade;

    // Set the Total point
    public void setPointTotal(int pointTotal){
        this.pointTotal = pointTotal;
    }

    // Get the Total point
    public int getPointTotal(){
        return pointTotal;
    }

    // Set the Earned point
    public void setEarnedPoints(int earnedPoints){
        this.earnedPoints = earnedPoints;
    }

    // Get the Earned point
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

    // Set the Total weighted grade
    public void setTotalGrade(double totalWeightedGrade) {
        this.totalWeightedGrade = totalWeightedGrade;
    }

    // Get the Total weighted grade
    public double getTotalGrade(){
        return totalWeightedGrade;
    }
}
