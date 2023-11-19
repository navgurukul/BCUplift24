package org.uplift.com;

import java.util.Objects;

public class Citizen {
    private String name;
    private String aadharid;
    private String phonenumber;
    public Citizen(String name, String aadharid, String phonenumber){
        this.name=name;
        this.aadharid=aadharid;
        this.phonenumber=phonenumber;
    }

    public String getName() {
        return name;
    }

    public String getAadharid() {
        return aadharid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public int hashCode(){
        return Objects.hash(aadharid);
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (getClass()!=obj.getClass())
            return false;
        Citizen other= (Citizen) obj;
        return Objects.equals (aadharid,other.aadharid);

    }
}
