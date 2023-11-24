package exam.org;

public class Statistics {
    private int numberOfMatches;
    private int number;

    public Statistics(int numberOfMatches, int number) {
        this.numberOfMatches = numberOfMatches;
        this.number = number;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getNumber() {
        return number;
    }

    public double calculateAvg(){
        return (double) number/numberOfMatches;
    }
}