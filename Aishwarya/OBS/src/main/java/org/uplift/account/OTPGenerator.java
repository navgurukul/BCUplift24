package org.uplift.account;

import java.util.Random;

public class OTPGenerator {
    private Random random;

    public OTPGenerator(Random random){
        this.random = random;
    }

    public String generateOTP(){
        String otp = "" + random.nextInt( 100000, 900000 );
        return otp;
    }


}
