package org.uplift.security;

import org.uplift.exception.OtpExpiredException;

import java.util.Random;
import java.util.Scanner;

public class OtpManager {
    private Random random;
    private Scanner scanner;
    private Timer timer;
    public OtpManager(Random random, Scanner scanner,Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }

    public String generateOtp() {
        return "" + random.nextInt(1000,10000);
    }


    public boolean validateOtp() throws OtpExpiredException{

        String generatedOtp = generateOtp();
        long currentTime = timer.getCurrentTime();
        int counter=0;

        do {
            System.out.println("Enter this otp to proceed: " + generatedOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if((inputTime-currentTime)>60000) throw new OtpExpiredException("Otp has been expired.");
            if(generatedOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp: " + (3-(counter+1)) + " attempts left.");
            counter++;
        }while (counter<3);

        return false;
    }
}
