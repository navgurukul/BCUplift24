package org.uplift.bank.security;

import java.util.Random;
import java.util.Scanner;

public class OTPManager {

     Random random;
     Scanner scanner;
     Timer timer;

    public OTPManager(Random random,Scanner scanner,Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }


    public String generateOtp() {
        return "" + random.nextInt(1000,100000);


    }

    public boolean validateOtp() throws OtpExpiredException {

        long startTime = timer.getCurrentTime();
        String generatedOtp = generateOtp();
        int ctr = 0;

        do{
            System.out.println("Please input otp : "+ generatedOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime - startTime > 60000){
                throw new OtpExpiredException("otp expired ");
            }
            if(generatedOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp Tries left : " + (ctr - 3 - 1));
            ctr++;
        }
        while(ctr<3);

        return false;
    }




}
