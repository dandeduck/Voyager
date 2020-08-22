package com.navapp.navigation.destination.data;

import android.net.Uri;
import android.telephony.PhoneNumberUtils;

import java.util.Objects;

public class PhoneNumber {
    private static final int MIN_PHONE_NUMBER_LENGTH = 6;
    private static final int MAX_PHONE_NUMBER_LENGTH = 15;
    private static final String EMPTY_PHONE_NUMBER = "0000000";

    private final String number;

    public static PhoneNumber empty() {
        return new PhoneNumber(EMPTY_PHONE_NUMBER);
    }

    public PhoneNumber(String number) {
        this.number = PhoneNumberUtils.normalizeNumber(number);

        if(number.length() < MIN_PHONE_NUMBER_LENGTH || number.length() > MAX_PHONE_NUMBER_LENGTH)
            throw new IllegalArgumentException("Invalid number");
    }

    public Uri getCallUri() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot call an empty phone number");
        return Uri.parse("tel:"+number);
    }

    public boolean isEmpty() {
        return number.equals(EMPTY_PHONE_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return number.equals(that.number);
    }
}
