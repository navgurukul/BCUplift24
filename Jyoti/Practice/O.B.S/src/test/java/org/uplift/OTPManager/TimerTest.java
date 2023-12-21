package org.uplift.OTPManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private Timer timer;
    @BeforeEach
    void setUp(){
        timer = new Timer();
    }

    @Test
    void getCurrentTime(){
        long ct = new Date().getTime();
        long ans = timer.getCurrentTime();
        assertTrue(ans == ct);
    }

}