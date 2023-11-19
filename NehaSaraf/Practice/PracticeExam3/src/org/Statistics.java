package org;

public class Statistics {
    private int matches;
    private int number;
    public Statistics(int matches, int number){
        this.matches=matches;
        this.number=number;
    }
    public int getMatches(){
        return matches;
    }
    public int getNumber(){
        return number;
    }
    public double calculateAvg(){
        double avg=number/(double) matches;
        return avg;
    }

}
