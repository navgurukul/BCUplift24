package org.uplift.bank.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    Timer timer;
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