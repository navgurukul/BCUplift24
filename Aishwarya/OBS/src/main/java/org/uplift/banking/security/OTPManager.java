package org.uplift.banking.security;

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

    public boolean validateOtp() throws OtpExpiredException{

        long startTime = timer.getCurrentTime();
        String generateOtp = generateOTP();
        int counter = 0;

        do{
            System.out.println("Please input otp");
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime - startTime > 60000) {
                throw new OtpExpiredException("Expired as try again");
            }
            if(generateOtp.equals( inputOtp )) return true;
            System.err.println("Invalid Input. Tries left " + (3-counter-1));
            counter++;
        }while(counter < 3);

        return false;
    }


}
