package org.uplift.security;

import javax.xml.crypto.Data;
import java.util.Random;
import java.util.Scanner;

public class OtpManager {
    private Random random;
    private Scanner scanner;
    private Timer timer;

    public OtpManager(Random random,Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner=scanner;
        this.timer=timer;
    }

    public String otpGenerate() {
        return ""+random.nextInt(1000,100000);
    }



    public boolean validateOtp() throws OtpExpireException {
        long startTime=timer.getCurrentTime();
        String generateOtp=otpGenerate();
        int ctr=0;
        do{
            System.out.println("enter the otp " +generateOtp);
            String otp= scanner.next();
            long inputtime=timer.getCurrentTime();
            if (inputtime-startTime>60000){
                throw new OtpExpireException("your otp is expire please");
            }
            if(generateOtp.equals(otp)){
                return true;
            }
            System.out.println("Invlaid otp, tries left" + (3-ctr-1));
            ctr++;
        }
        while (ctr<3);

        return false;
    }
}
