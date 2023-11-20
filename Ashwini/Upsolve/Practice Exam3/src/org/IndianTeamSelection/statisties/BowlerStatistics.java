package org.IndianTeamSelection.statisties;

public class BowlerStatistics implements Statistics {
    private int wickets;
    private int matches;

    public BowlerStatistics(int wickets, int matches) {
        this.wickets = wickets;
        this.matches = matches;
    }

    public int getMatches() {
        return matches;
    }

    public double calculateAverage() {
        return (double) wickets / matches;
    }

}
