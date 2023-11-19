package org.wealthpackage;


public class WealthManager {
    double temp ;


    public double calculateNetWorth(double totalAssets , double totalLiablities){
        temp = totalAssets - totalLiablities ;
        return temp ;

    }
    public boolean isEligibleForMembership(){
        return temp >= 100000000;
    }

    public boolean isPrimeMember() throws EligibilityPrimeException{
        if (temp>1000000000){
            System.out.println("Hey welcome, you are our prime customer!");
            return true;
        }
        else throw new EligibilityPrimeException("Sorry! you cannot be our prime customer.");
    }


}
