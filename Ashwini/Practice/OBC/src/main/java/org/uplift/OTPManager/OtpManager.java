package org.uplift.OTPManager;

import org.uplift.uplifte.exceptionhandling.OtpExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import org.uplift.account.Timer;


public class OtpManager {

    private Timer timer;
    private Random random;
    private Scanner scanner;
    OtpManager(Random random, Scanner scanner,Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;

    }
    public String generateOtp() {
        return ""+ random.nextInt(1000, 100000);
    }

    public boolean validateOtp() throws OtpExpiredException {
        long  startTime = timer.getCurrentTime();
        String generatedOtp = generateOtp();
        int ctr =0;
        do{
            System.out.println("Please Input OTP- "+ generatedOtp);
            String inputOtp = scanner.next();
            long inputTime =new Date().getTime();
            if (inputTime - startTime >60000){
                throw new OtpExpiredException("Otp has expried:");
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
