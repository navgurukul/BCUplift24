package org.uplift.exam3;

public class Statistics {
    private int noOfMatches;
    private int noOfWicketsOrRun;
    private double avg;

    public Statistics(int noOfMatches, int noOfWicketsOrRun){
        this.noOfMatches = noOfMatches;
        this.noOfWicketsOrRun = noOfWicketsOrRun;
        this.avg = getAvg();

    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public int getNoOfWicketsOrRun() {
        return noOfWicketsOrRun;
    }

    public double getAvg() {
        return noOfWicketsOrRun / noOfMatches;
    }

    public String toString(){
        StringBuilder details = new StringBuilder();
        details.append(noOfMatches);
        details.append(noOfWicketsOrRun);
        details.append(getAvg());
        return details.toString();
    }
}
