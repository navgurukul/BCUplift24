package org.cricket;

public class Statistic {
    private int numberOfMatches;
    private int number;

    public Statistic (int numberOfMatches,int number) {
        this.numberOfMatches = numberOfMatches;
        this.number = number;
    }
    public double calculateAvrage() {
        return number/numberOfMatches;
    }

}
