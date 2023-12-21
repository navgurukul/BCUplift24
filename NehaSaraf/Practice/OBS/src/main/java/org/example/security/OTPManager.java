package org.example.security;

import org.example.exception.OTPExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OTPManager {
    private Random random;
    private Scanner scanner;
    private Timer timer;

    public OTPManager(Random random,Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner=scanner;
        this.timer=timer;
    }

    public String generateOTP(){
        return ""+ random.nextInt(1000,100000);
    }

    public boolean validateOTP() throws OTPExpiredException {
        long startTime=timer.getCurrentTime();
        String generatedOTP=generateOTP();
        int ctr=0;
        do{
            System.out.println("Please Enter otp: "+generatedOTP);
            String inputOTP=scanner.next();
            long inputTime =timer.getCurrentTime();
            if(inputTime-startTime>6000){
                throw new OTPExpiredException("Open Expired.Please Try again for new OTP");
            }
            if(generatedOTP.equals(inputOTP))return true;
            System.err.println("Invalid otp.Tries left "+(3-ctr-1));
            ctr++;
        }
        while(ctr<3);
        return false;

    }

}
