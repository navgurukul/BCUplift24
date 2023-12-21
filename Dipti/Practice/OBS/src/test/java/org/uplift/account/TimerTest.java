package org.uplift.account;

import net.bytebuddy.utility.nullability.MaybeNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.uplift.security.Timer;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private Timer timer;

    @BeforeEach
    void setup(){
        timer= new Timer();

    }


    @Test
    void getCureentTime(){
        long cd= new Date().getTime();
        long ct=timer.getCurrentTime();
        assertTrue(ct==cd);
    }



}