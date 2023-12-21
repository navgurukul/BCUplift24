package org.uplift.bank;

import java.util.Random;
import java.util.Scanner;

public class OtpGenerate {
    private Random random;
    private Scanner scanner;
    public OtpGenerate(Random random,Scanner scanner){
        this.random=random;
        this.scanner=scanner;
    }
    public String generateOtp(){
        String otp=""+random.nextInt(1000,1000000);
        return otp;
    }

    public boolean validateOtp() {
        String generateOtp=generateOtp();
        int c=0;
        do {
            System.out.println("Please enter otp"+""+generateOtp);
            String inputOtp = scanner.next();
            if(generateOtp.equals(inputOtp)) return true;
            //System.out.println(inputOtp);
            System.err.println("invalid otp tries " +""+(3-c));
            c=c+1;
        }
        while(c<3);
        return false;

    }
}















////package org.uplift.bank;
////
//package org.uplift.bank;
//
//import java.util.Random;
//
//public class OtpManager {
//
//    private Random random = new Random();
//
//    public String generateOtp() {
//        // Generate a random 4-digit OTP
//        int otp = random.nextInt(9000) + 1000;
//        return String.valueOf(otp);
//    }
//
//    public boolean validateOtp(String enteredOtp) {
//        // Validate the entered OTP
//        String generatedOtp = null;
//        return enteredOtp.equals(generatedOtp);
//    }
//
//    public boolean validateOtp() {
//        // Generate an OTP
//        String generatedOtp = generateOtp();
//
//        // Simulate user input (you can replace this with actual user input)
//        String enteredOtp = "1000";
//
//        // Validate the entered OTP
//        return validateOtp(enteredOtp);
//    }
//}
//
//
//
//
//
////import java.util.Random;
////
////public class OtpManager {
////
////    private Random random = new Random();
////
////    public String generateOtp() {
////        // Generate a random 4-digit OTP
////        int otp = random.nextInt(9000) + 1000;
////        return String.valueOf(otp);
////    }
////
////    public boolean validateOtp(String enteredOtp, String generatedOtp) {
////        // Validate the entered OTP
////        return enteredOtp.equals(generatedOtp);
////    }
////
////    public boolean validateOtp() {
////        // Generate an OTP
////        String generatedOtp = generateOtp();
////
////        // Simulate user input (you can replace this with actual user input)
////        String enteredOtp = "1000";
////
////        // Validate the entered OTP
////        return validateOtp(enteredOtp, generatedOtp);
////    }
////}
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////////package org.uplift.bank;
////////
////////public class OtpManager {
////////    public String generateOtp() {
////////    }
////////}
//////
//////package org.uplift.bank;
//////
//////import java.util.Random;
//////
//////public class OtpManager {
//////
//////    private Random random = new Random();
//////
//////    public String generateOtp() {
//////        // Generate a random 4-digit OTP
//////        int otp = random.nextInt(9000) + 1000;
//////        return String.valueOf(otp);
//////    }
//////
////////    public boolean validateOtp(){
////////        String generateOtp = generateOtp();
////////        String
////////    }
//////
//////    public boolean validateOtp() {
//////        // Generate an OTP
//////        String generatedOtp = generateOtp();
//////
//////        // Simulate user input (you can replace this with actual user input)
//////        String enteredOtp = "1000";
//////
//////        // Validate the entered OTP
//////        boolean isValid = validateOtp(enteredOtp, generatedOtp);
//////
//////        return isValid;
//////    }
