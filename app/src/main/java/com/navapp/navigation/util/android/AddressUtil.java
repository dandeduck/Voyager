package com.navapp.navigation.util.android;

import android.location.Address;

public class AddressUtil {
    public static String city(Address address) {
        return address.getAddressLine(0); //Might need to do more processing, also may be just extend the Android Address itself
    }
}
