package org.uplift.Bank.security;

import java.awt.datatransfer.ClipboardOwner;
import java.util.Date;

public class Timer {
    public long getCurrentTime(){
        return new Date().getTime();
    }

}
