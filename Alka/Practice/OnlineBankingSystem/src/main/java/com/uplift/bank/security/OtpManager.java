package com.uplift.bank.security;
import com.uplift.exceptions.OtpExpiredException;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {

    private Random random;

    private Scanner scanner;

    private Timer timer;

    public OtpManager(Random random,Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer=timer;
    }


    public String generateOtp() {
        return  ""+random.nextInt(1000,100000);
    }


    public boolean validiateOtp() throws OtpExpiredException {
        long startTime =  timer.getCurrentTime();
        String generateOtp = generateOtp();
        int ctr = 0;
        do {
            System.out.println("Please input your otp: " + generateOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime-startTime>60000){
                throw new OtpExpiredException("OTP has been expired as time is only valid for the one minute. Please try again later!");
            }
            if (generateOtp.equals(inputOtp)) return true;
            System.err.println("Invalid OTP, tries left: "+(3-ctr-1));
            //err is for showing/print errors in red color
            ctr++;
        }
        while (ctr<3);
        System.out.println("Please try again later");
        return false;
    }
}
