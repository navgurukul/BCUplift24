package newquestion;

public class Identity {
    private String pancardNumber;
    private String aadharcardnumber;

    public String toString(){
        return "pancardNumber is "+pancardNumber +" and AdharCard number is "+aadharcardnumber;
    }


    Identity(String pancardnumber,String aadharcardnumber){
        this.pancardNumber = pancardnumber;
        this.aadharcardnumber = aadharcardnumber;

    }


}
