package org.uplift.account;

import org.uplift.exception.InvalidOtpException;

import java.security.SecureRandom;

//public class Otp {
//    String chars = "0123456789";
//    public String generateOtp(int length){
//
//        SecureRandom randomOtp = new SecureRandom();
//        StringBuilder otp = new StringBuilder(length);
//
//        for(int i=0; i<length; i++){
//            int index = randomOtp.nextInt(chars.length());
//            otp.append(chars.charAt(index));
//        }
//        return otp.toString();
//    }
//
////    public boolean verifyOTP(String userOTP,String generatedOTP){
////        int userInput = 0;
////        while(userInput>=3){
////
////        }
////    }
//
//    public static boolean validateOTP(String enteredOTP, String generatedOTP) throws InvalidOtpException {
//
//        if(!enteredOTP.equals(generatedOTP)){
//            throw new InvalidOtpException("The OTP you have entered is invalid!!!!!!");
//        }
//
//        return false;
//    }
//}
