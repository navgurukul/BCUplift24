package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.bank.security.Timer;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private Timer timer;
    @BeforeEach
    void setUP(){
        timer = new Timer();
    }

    @Test
    void gerCurrentTime(){
        long ct = new Date().getTime();
        long answer = timer.getCurrentTime();
        assertTrue(ct==answer);
    }

}