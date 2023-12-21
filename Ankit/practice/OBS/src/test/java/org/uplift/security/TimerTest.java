package org.uplift.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private Timer timer;

    @BeforeEach
    void setUp() {
        timer = new Timer();
    }

    @Test
    void getCurrentTime() {
        long currentTime = new Date().getTime();
        long ans = timer.getCurrentTime();
        assertEquals(currentTime, ans);
    }
}