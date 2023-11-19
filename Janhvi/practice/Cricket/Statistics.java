package org.uplift.PracticeExam3.Cricket;

import org.uplift.PracticeExam3.Players;

public class Statistics{
    private int noOfMatches;
    private int numbers;
    public Statistics(int noOfMatches, int numbers){
        this.noOfMatches = noOfMatches;
        this.numbers = numbers;
    }
    public int getNoOfMatches(){
        return noOfMatches;
    }
    public int getNumbers(){
        return numbers;
    }
    public double caculateAverage(){
        return numbers / (double) noOfMatches;
    }

}