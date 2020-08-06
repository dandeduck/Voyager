package com.navapp.navigation.destination;

import com.navapp.navigation.destination.data.Address;
import com.navapp.navigation.destination.data.PhoneNumber;
import com.navapp.navigation.destination.data.Rate;

public class DestinationBuilder {
    private Address address;
    private Rate rate;
    private PhoneNumber phoneNumber;
    private String comment;

    public DestinationBuilder() {
        address = Address.empty();
        rate = Rate.empty();
        phoneNumber = PhoneNumber.empty();
        comment = "";
    }

    public DestinationBuilder address(Address address) {
        this.address = address;

        return this;
    }

    public DestinationBuilder rate(Rate rate) {
        this.rate = rate;

        return this;
    }

    public DestinationBuilder phoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;

        return this;
    }


    public DestinationBuilder comment(String comment) {
        this.comment = comment;

        return this;
    }

    public Destination build() {
        return new Destination(address, rate, phoneNumber, comment);
    }
}
