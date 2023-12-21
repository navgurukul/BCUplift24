package org.uplift.bank;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.uplift.bank.security.Security;

class BankTest {
    @Mock
    Security security;
    @InjectMocks
    Bank bank;
//    @BeforeEach


//    @Test
//    void logIn(){
//        bank.logIn("userName", "password");
//
//    }
}