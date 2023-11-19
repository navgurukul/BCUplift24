public class Statistics implements Comparable <Statistics> {
    private int noOfMatches;
    private int number;

    Statistics( int noOfMatches, int number ){
        this.noOfMatches=noOfMatches;
        this.number=number;
    }
    public int getNoOfMatches(){
        return noOfMatches;
    }
    public int getNumber(){
        return number;
    }

    @Override
    public int compareTo(Statistics o) {
       // Double thisScore= Double.valueOf()
        return 0;
    }



}
