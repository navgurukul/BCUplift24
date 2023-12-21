package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;


import org.uplift.bank.Timer;

import static org.junit.Assert.assertTrue;

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
        assertTrue(answer == ct);
    }

}