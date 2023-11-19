package org.iccselection;

public class Statistics {
    private int numOfMatches ;
    private int runs ;
    private int wickets ;

    Statistics(int numOfMatches,int runs,int wickets){
        this.numOfMatches = numOfMatches ;
        this.runs = runs ;
        this.wickets = wickets ;
    }

    public double calculateAverageForBatsman(){
        return (double) runs/numOfMatches;
    }
    public double calculateAverageForBowler(){
        return (double) wickets/numOfMatches;
    }
}
