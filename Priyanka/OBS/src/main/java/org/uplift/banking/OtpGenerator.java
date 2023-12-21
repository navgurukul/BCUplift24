package org.uplift.banking;

import org.uplift.banking.security.Timer;

import java.util.Random;
import java.util.Scanner;

public class OtpGenerator {
    Random random;
    Scanner scanner;
    Timer timer;
    public OtpGenerator(Random random,Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }
    public String generateOtp() {
        String otp = ""+random.nextInt(1000,100000);
        return otp;

    }

    public boolean validateOtp() throws OtpExpiredException {
        long startTime = timer.getcurrentTime();
        String generateOtp = generateOtp();
        int count = 0;
        do {
            System.out.println("Please input OTP - " + generateOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getcurrentTime();
            if (inputTime - startTime > 60000) {
                throw new OtpExpiredException("Invalid otp");
            }
            if (generateOtp.equals(inputOtp)) return  true;
            System.err.println("Invalid otp : " + (3-count-1));
            count++;
        }while (count<3);
        return false;
    }
}
