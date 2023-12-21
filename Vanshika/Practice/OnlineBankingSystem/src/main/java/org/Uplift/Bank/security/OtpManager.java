package org.Uplift.Bank.security;

import org.Uplift.exception.OtpExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {


    private Random random;
    private Scanner scanner;
    private Timer timer;
    OtpManager(Random random, Scanner scanner, Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }
    public String generateOtp() {
        return ""+ random.nextInt(1000, 100000);
    }

    public boolean validateOtp() throws OtpExpiredException {
        long startTime = new Date().getTime();
        String generatedOtp = generateOtp();
        int ctr =0;
        System.out.println("Please Input OTP- "+ generatedOtp);
        do{
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if (inputTime- startTime>60000){
                throw new OtpExpiredException("Time has expired");
            }
            if(generatedOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp. tries left " + (2-ctr));
            ctr++;
        }
        while(ctr <3);
        System.out.println("Please try again later");
        return false;

    }


}
