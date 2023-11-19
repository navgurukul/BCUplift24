package org.worldCupselection;

public class Statistics {
    private final int numberOfMatches;

    private final  int numbers;

    public int getNumbers(){
        return numbers;
    }

    public Statistics(int numberOfMatches, int numbers) {
        this.numberOfMatches = numberOfMatches;
        this.numbers = numbers;
    }
    //numbers can be runs/wickets



    private double calculateAvg;
    public double getCalculateAvg(){
        calculateAvg=numbers/numberOfMatches;
        return getCalculateAvg();
    }
}
