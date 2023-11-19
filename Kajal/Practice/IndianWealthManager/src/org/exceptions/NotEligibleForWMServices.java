package org.exceptions;

public class NotEligibleForWMServices extends Exception{
    public NotEligibleForWMServices(){
        super("Sorry! You are not eligible for Worth Management Services.");
    }
}
