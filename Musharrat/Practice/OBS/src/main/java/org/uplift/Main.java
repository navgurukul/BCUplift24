package org.uplift;

import org.uplift.banking.security.OtpManager;
import org.uplift.banking.security.Timer;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the third time that I changed code");
        OtpManager otpManager = new OtpManager(new Random(), new Scanner(System.in), new Timer());
    }
}