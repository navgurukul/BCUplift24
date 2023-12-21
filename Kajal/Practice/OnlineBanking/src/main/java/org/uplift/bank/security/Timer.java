package org.uplift.bank.security;

import java.util.Date;

public class Timer {

    public long getCurrentTime() {
        return new Date().getTime();
    }
}
