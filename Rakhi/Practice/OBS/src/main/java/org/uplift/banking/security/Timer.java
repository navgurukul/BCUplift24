package org.uplift.banking.security;

import java.util.Date;

public class Timer{

    public long getCurrentTime(){
        return new Date().getTime();
    }

}