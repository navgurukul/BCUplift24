package org.uplift.bank;

import org.uplift.exception.OtpExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {
    private  Random random;
    private Scanner scanner;
    private Timer timer;

    public OtpManager(Random random, Scanner scanner, Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }

    public String generateOtp() {

        String otp =  ""+ random.nextInt(1000,100000);
        return otp;
    }
    public boolean validateOtp() throws OtpExpiredException {
        long startTime = timer.getCurrentTime();
        String generatedeOtp = generateOtp();
        int ctr = 0;
        do{
            System.out.println("Enter otp: "+generatedeOtp);
            String inputOtp = scanner.next();
            long endTime = new Date().getTime();
            if(endTime - startTime>60000){
                throw new OtpExpiredException("Your OTP has expired");
            }
            if(generatedeOtp.equals(inputOtp)) return true;
            System.err.println("Invalid OTP, Tries left: "+(3-ctr));
            ctr++;
        }
        while(ctr<3);
        return false;
    }
}
