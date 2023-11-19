package org.uplift24.PracticeExample;

public class Statistics {
    private int matches;
    private int numberOf;

    public Statistics(int matches,int numberOf){
        this.matches=matches;
        this.numberOf=numberOf;
    }

    public int getMatches() {

        return matches;
    }

    public int getNumberOf() {

        return numberOf;
    }
    public double calculateAverage(){
        double av=numberOf/matches;
        return av;
    }
}


