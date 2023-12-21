package org.uplift.bank.security;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OTPManager {
    Random random;
    private Scanner scanner;
    private Timer timer;

    public OTPManager(Random random, Scanner scanner, Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }

    public String generateOTP(){
        String otp =  "" + random.nextInt( 1000, 100000 );
        return otp;
    }

    public boolean validateOtp(){
        long startTime = timer.getCurrentTime();
        String generateOtp = generateOTP();
        int counter = 0;

        do{
            System.out.println("Please input otp");
            String inputOtp = scanner.next();
            long endtime = timer.getCurrentTime();
            if(generateOtp.equals(inputOtp)) {
                throw new OtpExpiredException("expired as try again");
            }
            System.err.println("Invalid Input. Tries left " + (3-counter-1));
            counter++;
        }while(counter < 3);

        return false;
    }


}
