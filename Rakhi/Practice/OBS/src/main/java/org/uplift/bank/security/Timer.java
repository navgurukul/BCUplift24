package org.uplift.bank.security;

import javax.xml.crypto.Data;
import java.util.Date;

public class Timer{

    public long getCurrentTime(){
        return new Date().getTime();
    }

}
