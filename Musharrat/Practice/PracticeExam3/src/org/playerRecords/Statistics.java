package org.playerRecords;

public class Statistics {
    private double matches;
    private int number;

    Statistics(double matches, int number){
        this.matches = matches;
        this.number = number;
    }

    public double getAverage(){
        return matches/number;
    }

    public double getMatches() {
        return matches;
    }

    public int getNumber() {
        return number;
    }
}
