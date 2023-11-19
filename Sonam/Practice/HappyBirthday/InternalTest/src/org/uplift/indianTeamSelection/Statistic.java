package org.uplift.indianTeamSelection;

public class Statistic {
    private int matches;
    private int number;
    public Statistic(int matches, int number){
        this.matches=matches;
        this.number=number;
    }
    public String toString(){
        return matches+" "+
                number+"\n";
    }

    public int getMatches() {
        return matches;
    }

    public int getNumber() {
        return number;
    }
}
