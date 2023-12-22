package org.example.bankingprovider.security;

import java.util.Date;

public class Timer {

    public long getCurrentTime() {
        return new Date().getTime();
    }
}
