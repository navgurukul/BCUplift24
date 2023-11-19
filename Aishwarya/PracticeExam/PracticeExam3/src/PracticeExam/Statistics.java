package PracticeExam;

public class Statistics {
    private int matchesNumber;
    private int numberOf;         // number of runs for batter and no wickets for baller

    public Statistics(int matchesNumber, int numberOf){
        this.matchesNumber = matchesNumber;
        this.numberOf = numberOf;
    }
    public int getMatchesNumber(){
        return matchesNumber;
    }

    public int getNumberOf(){
        return numberOf;
    }

    public long calculatedAvg(){
        return getNumberOf() / getMatchesNumber();
    }

}
