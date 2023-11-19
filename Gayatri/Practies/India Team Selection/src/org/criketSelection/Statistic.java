package org.criketSelection;

public class Statistic {
    private int noOfMatches;
    private int number;

    public Statistic(int noOfMatches, int number){
        this.noOfMatches=noOfMatches;
        this.number=number;
    }

    public int getNoOfMatches(){
        return noOfMatches;
    }
    public int getNumberber(){
        return number;
    }

    public double calaculateAvg(){
        return getNumberber()/getNoOfMatches();
    }
}
