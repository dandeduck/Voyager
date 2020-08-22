package com.navapp.navigation.destination.data;

import org.junit.Test;

public class PhoneNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void create_tooShortNumber_throwsException() {
        new PhoneNumber("12345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_tooLongNumber_throwsException() {
        new PhoneNumber("1234567890123456");
    }
}
