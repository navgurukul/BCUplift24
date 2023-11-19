package precticeexam3;

class Statistics implements Comparable<Statistics>{
    private int numberOfMatches;
    private int TotalNumbers;
    private int average;


    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    Statistics(int matches, int numbers){
        this.numberOfMatches = matches;
        this.TotalNumbers = numbers;
    }

    public int calculatePlayerAverage(){
        average =  TotalNumbers/numberOfMatches;
        return average;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Number of matches : ");
        sb.append(numberOfMatches);
        sb.append(" Player Average : ");
        sb.append(calculatePlayerAverage());
        return sb.toString();
    }

    public int compareTo(Statistics object){
        return Integer.valueOf(this.average).compareTo(object.calculatePlayerAverage());
    }

}
