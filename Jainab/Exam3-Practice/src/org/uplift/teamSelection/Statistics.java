package org.uplift.teamSelection;

public class Statistics {
    private int matches;
    private int numberOfRuns;
    private int numberOfWickets;

    Statistics(int matches, int numberOfRuns, int numberOfWickets) {
        this.matches = matches;
        this.numberOfRuns=numberOfRuns;
        this.numberOfWickets=numberOfWickets;
    }

    public double calculateAvgRuns(){
        return (double) numberOfRuns /matches;
    }
    public double calculateAvgWickets(){
        return (double) numberOfWickets /matches;
    }
}
