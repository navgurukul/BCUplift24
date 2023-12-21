package org.uplift.banking.security;

import org.uplift.exception.OtpExpiredException;

import java.util.Random;

import java.util.Scanner;

public class OtpManager {
    private Random random;

    private Scanner scanner;
    private Timer timer;

    public OtpManager(Random random,Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner=scanner;
        this.timer=timer;
    }

    public String otpGenerator(){
        String otp=""+random.nextInt(1000,100000);
//        return ""+random.nextInt(1000,100000);
        return otp;
    }

    public boolean validateOtp()throws OtpExpiredException{
        long startTimer=timer.getCurrentTime();
        String genetratedOtp = otpGenerator();
        int ctr=0;
        do{
            System.out.println("Your OTP is"+genetratedOtp);
            System.out.println("Enter OTP");
            String inputOtp=scanner.next();

            long inputTimer=timer.getCurrentTime();

            if((inputTimer-startTimer)>60000) {
                throw new OtpExpiredException("Otp has expired");
            }

            if(genetratedOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp. Tries left "+(3-ctr-1) );
            ctr++;
        }while(ctr<3);
        return false;
    }

}
