package org.IndianTeamSelection.statisties;

public class Statistics {
    private int run;
    private int matches;
    public Statistics(int run, int matches){
        this.run = run;
        this.matches=matches;
    }

    public int getMatches(){
        return matches;
    }
    public double  calculateAvg(){
        return run/matches;
    }
}
