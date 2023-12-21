package org.uplift.security;

import org.uplift.exception.OtpExpiredException;

import java.util.Random;
import java.util.Scanner;

public class OTPManager {
    Random random;
    Scanner scanner;
    Timer timer;



    public OTPManager(Random random, Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer=timer;
    }

    public String generateOtp() {
        return String.valueOf(random.nextInt(1000, 10000));
    }

    public boolean validateOtp() throws OtpExpiredException {
        String generatedOtp = generateOtp();
        long startTime = timer.getCurrentTime();

        int c=0;
        do {
            System.out.println("Enter OTP: "+generatedOtp);

            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime-startTime>60000){
               throw new OtpExpiredException("Otp is expired");
            }
            if(generatedOtp.equals(inputOtp))return true;
            System.err.println("Invalid OTP. Tries Left"+(3-c-1));
            c++;
        }while(c<3);
        return false;
    }
}
