package org.uplift.bank.security;

import org.uplift.exception.OTPExpiredException;

import java.util.Random;
import java.util.Scanner;

public class OTPManager {
    private Random random;
    private Scanner scanner;
    private Timer timer;

    public OTPManager(Random random, Scanner scanner,Timer timer){
        this.random = random;
        this.scanner = scanner;
        this.timer = timer;
    }
    public String generateOtp() {
        return ""+random.nextInt(1000,100000);
    }

    public boolean validateOTP() throws OTPExpiredException {
        String generateOtp = generateOtp();
        long startTime = timer.getCurrentTime();
        int ctr = 0;
        do{
            System.out.println("Please input OTP : = " + generateOtp);
            String inputOtp = scanner.next();
            long inputTime = timer.getCurrentTime();
            if(inputTime - startTime > 60000){
                throw new OTPExpiredException("Time is expired.");
            }
            if(generateOtp.equals(inputOtp))return true;
            System.err.println("Invalid otp , Tries left " + (3-ctr-1));
            ctr++;
        }
        while(ctr<3);
        return false;



    }
}












//    public boolean verifyUser(User sourceUser, Account source, String password) throws InvalidPinException {
//        int count =0;
//        for (int i=0;i<3;i++){
//            if(sourceUser.getPassword().equals(password)){
//                String otp = "" + random.nextInt(100000,1000000000);
//
//
//            }
//            else{
//                count+=1;
//                if(count==3){
//                    throw new InvalidPinException("due to three attempts , your account is blocked.");
//                }
//            }
//        }
//        return false;
//
//    }