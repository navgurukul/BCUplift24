package org.uplift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.UserDoesNotExistException;
import org.uplift.user.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {
    private Security security;
    @BeforeEach
    void setUp(){
        security = new Security();
        Security.getUserPasswordMap().put("Ankit_27", "ankit@123");

    }
    @Test

    void verifyUser(){
        try {
            assertTrue(security.verifyUser("Ankit_27", "Ankit@123"));
        }catch(UserDoesNotExistException ude){
            System.out.println(ude.getMessage());
        }
    }

}