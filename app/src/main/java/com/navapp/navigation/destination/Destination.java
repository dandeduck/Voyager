package com.navapp.navigation.destination;

import com.navapp.navigation.destination.data.Place;
import com.navapp.navigation.destination.data.PhoneNumber;
import com.navapp.navigation.destination.data.Rate;

public class Destination {
    private final Place place;
    private final Rate rate;
    private final PhoneNumber phoneNumber;
    private final String comment;
    private boolean isDelivered;

    public Destination(Place place) {
        this(place, Rate.empty());
    }

    public Destination(Place place, Rate rate) {
        this(place, rate, PhoneNumber.empty());
    }

    public Destination(Place place, Rate rate, PhoneNumber phoneNumber) {
        this(place, rate, phoneNumber, "");
    }

    public Destination(Place place, Rate rate, PhoneNumber phoneNumber, String comment) {
        this(place, rate, phoneNumber, comment, false);
    }

    private Destination(Place place, Rate rate, PhoneNumber phoneNumber, String comment, boolean isDelivered) {
        this.place = place;
        this.rate = rate;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.isDelivered = isDelivered;
    }

    public Destination changeRate(Rate newRate) {
        return new Destination(place, newRate, phoneNumber, comment, isDelivered);
    }

    public String getPlaceId() {
        return place.getId();
    }

    public Place getPlace() {
        return place;
    }

    public Rate getRate() {
        return rate;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered() {
        isDelivered = true;
    }

    public void setUnDelivered() {
        isDelivered = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;

        Destination that = (Destination) o;
        return isDelivered == that.isDelivered &&
                place.equals(that.place) &&
                rate.equals(that.rate) &&
                phoneNumber.equals(that.phoneNumber) &&
                comment.equals(that.comment);
    }

    @Override
    public String toString() {
        return String.format("place: %s \n rate: %s \n number: %s \n comment: %s \n delivered? %b", place, rate, phoneNumber, comment, isDelivered);
    }
}
