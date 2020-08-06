package com.navapp.navigation.destination.data;

import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;

public class PhoneNumber {
    private static final int MIN_PHONE_NUMBER_LENGTH = 6;
    private static final int MAX_PHONE_NUMBER_LENGTH = 15;

    private final String number;

    public static PhoneNumber empty() {
        return new PhoneNumber("0000000");
    }

    public PhoneNumber(String number) {
        this.number = PhoneNumberUtils.normalizeNumber(number);

        if(number.length() < MIN_PHONE_NUMBER_LENGTH || number.length() > MAX_PHONE_NUMBER_LENGTH)
            throw new IllegalArgumentException("Invalid number");
    }

    public Intent callIntent() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));

        return intent;
    }
}
