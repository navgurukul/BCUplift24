package org.IndiaTeamSelection;

public class Statistics {
    private int matches;
    private  int number;
    Statistics(){
        this.matches=matches;
        this.number=number;
    }
    public int getMatches(){
        return  matches;
    }
    public  int getNumber(){
        return  number;
    }
    public  double calculateAvrage(int matches,int number){

        return number/matches;
    }
}
