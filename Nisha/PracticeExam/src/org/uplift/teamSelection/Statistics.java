package org.uplift.teamSelection;

public class Statistics {
   private int numbers;
    private int noOfMatches;

    public Statistics(int numbers,int noOfMatches){
        this.numbers=numbers;
        this.noOfMatches=noOfMatches;
    }

    public double calculateAverage(){
        return -1.0;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public int getNumbers() {
        return numbers;
    }
}
