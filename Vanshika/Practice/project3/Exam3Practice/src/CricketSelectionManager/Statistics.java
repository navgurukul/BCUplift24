package CricketSelectionManager;

public class Statistics {
    private double matches;
    private double numbers;

    public Statistics(double matches, double numbers){
        this.matches = matches;
        this.numbers = numbers;
    }


    public double getMatches() {
        return matches;
    }

    public double getNumbers() {
        return numbers;
    }

    public double calculateAvg(){
        return (double) numbers / (double) matches;
    }
    public String toString(){
        return String.valueOf(matches);
    }
}
