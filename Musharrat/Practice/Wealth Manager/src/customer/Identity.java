package customer;

public class Identity {
    String aadharNum;
    String panNumber;

    public Identity(String aadharNum, String panNumber){
        this.aadharNum = aadharNum;
        this.panNumber = panNumber;
    }

    @Override
    public String toString() {
        return " aadharNum: "+ aadharNum
                + " panNum: "+ panNumber;
    }
}

