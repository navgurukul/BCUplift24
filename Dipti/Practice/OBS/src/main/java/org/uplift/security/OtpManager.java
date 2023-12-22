package org.uplift.security;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class OtpManager {
  private Random random;
   private Scanner scanner;

   private Timer timer;


    public OtpManager(Random random,Scanner scanner,Timer timer) {
        this.random = random;
        this.scanner = scanner;
        this.timer=timer;
    }

    public String  generateOtp(){
        return  "" + random.nextInt(1000,100000);

    }

    public boolean validateOtp()throws OtpExpiredException{

        String generateOtp=generateOtp();
        long startTime= timer.getCurrentTime();
        int ctr=0;
        do{
            System.out.println("please input otp" + generateOtp);
            String inputOtp=scanner.next();
            long inputTime=timer.getCurrentTime();
            if (inputTime-startTime >60000){
                throw new OtpExpiredException("time is expired");
            }
          if( generateOtp.equals(inputOtp))return true;
            System.err.println("invalid otp: tries left "+ (3-ctr-1));
            ctr++;
        }while(ctr <3) ;
        return false;
    }

}
