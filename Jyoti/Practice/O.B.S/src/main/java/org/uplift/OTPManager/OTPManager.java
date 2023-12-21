package org.uplift.OTPManager;
import org.uplift.exception.OtpExpiredException;

import java.util.*;
public class OTPManager {
    private Random random;
    private Timer timer;
    private Scanner scanner;
    OTPManager(Random random, Scanner scanner, Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }
    public String generateOtp() {
        return ""+ random.nextInt(1000, 100000);
    }
    public boolean validateOtp() throws OtpExpiredException {
        long  startTime = new Date().getTime();
        String generatedOtp = generateOtp();
        int ctr =0;
        do{
            System.out.println("Please Input OTP- "+ generatedOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime - startTime > 60000) throw  new OtpExpiredException("OTP has been expired as time given");
            if(generatedOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp. tries left " + (3 - ctr - 1));
            ctr++;
        }
        while(ctr <3);
        System.out.println("Please try again later");
        return false;
    }
}