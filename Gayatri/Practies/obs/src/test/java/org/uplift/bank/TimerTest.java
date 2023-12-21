package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.security.Timer;

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
        long answer = timer.getCurrentTime();
        assertTrue(answer==ct);
    }
}