package org.uplift.bank.security;

import org.uplift.exception.OtpExpireExecption;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {

    private Random random;
    private Timer timer;
    private Scanner scanner;

    public OtpManager(Random random, Scanner scanner, Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }

    public String generateOtp() {
        return ""+random.nextInt(10000, 10000000);
    }

    public boolean validateOtp() throws OtpExpireExecption{
        long startTime = timer.getCurrentTime();
        String generateOtp = generateOtp();
        int ctr = 0;

        do {
            System.out.println("Please Input Otp: "+ generateOtp);
            String inputOtp = scanner.next();

            long inputTime = timer.getCurrentTime();

            if (inputTime - startTime > 60000){
                throw new OtpExpireExecption("Otp has expired as it was valid for only one minute");
            }
            if(generateOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp.Tries left: "+ (3-ctr-1));
            ctr ++;
        } while (ctr < 3);

        return false;

    }
}
