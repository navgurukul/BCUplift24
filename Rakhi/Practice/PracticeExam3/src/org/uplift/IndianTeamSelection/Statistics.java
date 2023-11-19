package org.uplift.IndianTeamSelection;

public class Statistics {
    private int numberOfMatches;
    private int number;

    Statistics(int numberOfMatches,int number){
        this.numberOfMatches=numberOfMatches;
        this.number=number;
    }

    public int getNumberOfMatches(){
        return numberOfMatches;
    }

    public int getNumber(){
        return number;
    }

    public double calculateAverage(){
        double average=number/numberOfMatches;
        return average;
    }
}
