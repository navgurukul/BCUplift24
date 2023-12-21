package org.uplift.bank.security;

import org.uplift.bank.Timer;
import org.uplift.exception.OtpExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {

    private Random random;
    private Scanner scanner;
    private Timer timer;

    public OtpManager(Random random, Scanner scanner, Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }
    public String generateOTP() {
        return ""+random.nextInt(1000, 10000);
    }

    public boolean validateOtp() throws OtpExpiredException {
        long startTime = timer.getCurrentTime();
        String generateOtp = generateOTP();
        int ctr = 0;
        do{
            System.out.println("Input Otp: "+generateOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if (inputTime-startTime>60000) {
                throw new OtpExpiredException("OTP has been expired...");
            }
            if (generateOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp. tries left "+ (3-ctr));
            ctr++;

        } while (ctr<3);
        return false;
    }
}
