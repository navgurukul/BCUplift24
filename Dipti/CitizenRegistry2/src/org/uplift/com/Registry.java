package org.uplift.com;

import java.util.HashSet;
import java.util.Set;

public class Registry {
    Set<Citizen> ListOfCitizen= new HashSet<>();

    public void addCitizen(Citizen c) throws InvalidAadharException{
        if (ListOfCitizen.contains(c)){
            throw new InvalidAadharException("addhar id already exists" + c.getAadharid() );
        }
        else{
            ListOfCitizen.add(c);

            System.out.println(c.getName());
        }
    }
}
