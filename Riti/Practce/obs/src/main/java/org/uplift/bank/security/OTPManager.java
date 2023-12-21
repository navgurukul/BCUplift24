package org.uplift.bank.security;


import org.uplift.exceptions.OTPExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OTPManager {

    private static final int OTP_LENGTH = 6;
    private Random random;
    private Scanner scanner;
    private Timer timer;
    public OTPManager(Random random,Scanner scanner,Timer timer ) {
        this.random=random;
        this.scanner=scanner;
        this.timer=timer;
    }

    public String generateOTP() {
//        Random random = new Random();
//        StringBuilder otp = new StringBuilder();
//
//        for (int i = 0; i < OTP_LENGTH; i++) {
//            otp.append(random.nextInt(10));
//
//        }
//
//        return otp.toString();
        String otp=""+random.nextInt(1000,100000);
        return otp;
    }

    public boolean validOTP() throws OTPExpiredException {
        long startTime=timer.getCurrentTime();
        String genratedOTP=generateOTP();
        int ctr=0;
        do {
            System.out.println("Please Input a OTP:-"+genratedOTP);
            String inputOTP=scanner.next();
            long endTime=timer.getCurrentTime();
            if((startTime+endTime)>60000){
                throw new OTPExpiredException("Time OUT");
            }

            if(genratedOTP.equals(inputOTP)) return true;
            System.err.println("Invalid Input");
            ctr++;
        }while (ctr<3);
        return false;

//        String inputOTP=scanner.next();
//        return genratedOTP.equals(inputOTP);
    }
}

