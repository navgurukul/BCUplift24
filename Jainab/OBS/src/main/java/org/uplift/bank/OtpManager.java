package org.uplift.bank;

import org.uplift.exception.OtpExpireException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {
    Random random;
    Scanner scanner;
    Timer timer;

    public OtpManager(Random random, Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner=scanner;
        this.timer=timer;
    }

    public String generateOtp() {
        return ""+random.nextInt(1000,100000);
    }

    public boolean validateOtp() throws OtpExpireException {
        long startTime = timer.getCurrentTime();
        String generateOtp= generateOtp();
        int ctr=0;

        do{
            System.out.println("Enter Otp : " + generateOtp);
            String inputOtp= scanner.next();

            long inputTime = timer.getCurrentTime();
            if(inputTime - startTime > 60000){
                throw new OtpExpireException("OTP Expired");
            }
            if(generateOtp.equals(inputOtp)) return true;
            System.out.println("Invalid otp.. Tries left: "+(3-ctr-1));
            ctr++;
        }while(ctr<3);
        return false;
    }
}
