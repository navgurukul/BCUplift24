package org.IndianTeamSelection.statisties;

public class BatsmanStatistics implements Statistics{
    private int runs;
    private int matches;

    public BatsmanStatistics(int runs, int matches) {
        this.runs = runs;
        this.matches = matches;
    }

    public int getMatches() {
        return matches;
    }

    public double calculateAverage() {
        return (double) runs / matches;
    }
}
