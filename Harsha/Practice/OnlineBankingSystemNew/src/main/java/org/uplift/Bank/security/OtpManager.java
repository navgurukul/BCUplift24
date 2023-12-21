package org.uplift.Bank.security;

import org.uplift.user.User;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;
public class OtpManager {
    Random random;
    Scanner scanner;
    Timer timer;



    public OtpManager(Random random,Scanner scanner,Timer timer  ) {
        this.random = random;
        this.scanner=scanner;
        this.timer=timer;
    }

    public String generateOtp() {
        //Random random = new Random();
        String otp =""+ random.nextInt(1000,10000);
        return otp;
    }


    public boolean validateOtp() throws OtpExpiredException {
        String generateOtp= generateOtp();
        long startTime = timer.getCurrentTime();
        int ctr=0;
        do{
            System.out.println("Please input otp: "+ generateOtp);
            String inputOtp= scanner.next();
            long intputTime= timer.getCurrentTime();
            if (intputTime- startTime>6000){
                throw  new OtpExpiredException(" otp has expired as it valid for one minute. try again");
            }
            if(generateOtp.equals(inputOtp)) return true;
            System.err.println("Invalid otp. Tries left: " +(3-ctr-1));
            ctr++;
        }while(ctr<3);
        return  false;
    }



}
