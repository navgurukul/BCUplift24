package org;

public class Statistic {

    private int numOfMatches;
    private int runWicketNum;

    public int getRunWicketNum() {
        return runWicketNum;
    }
    public int getNumOfMatches() {
        return numOfMatches;
    }

    public Statistic(int numOfMatches,int runWicketNum) {
        this.numOfMatches = numOfMatches;
        this.runWicketNum = runWicketNum;
    }
    public double CalulateAverage(Statistic s ){
        return (double) s.runWicketNum /s.numOfMatches;

    }




}
