package org.uplift.bank.security;

import org.uplift.exception.OtpExpiredException;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {
    Random random;
    Scanner scanner;
    Timer timer;
    public OtpManager(Random random, Scanner scanner, Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }
    public String generateOtp() {
        return "" + random.nextInt(1000, 100000);
    }

    public boolean validateOtp() throws OtpExpiredException {
        long startTime = timer.getCurrentTime();
        String generatedOtp = generateOtp();
        int ctr = 0;
        do {
            System.out.println("Please input otp: " + generatedOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime - startTime > 60000) {
                throw new OtpExpiredException("Otp has expired as it is only valid for 1 minute. Please try again with a new otp");
            }
            if(generatedOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp. Tries left: " + (3 - ctr - 1));
            ctr++;
        } while(ctr < 3);
        return false;
    }
}
