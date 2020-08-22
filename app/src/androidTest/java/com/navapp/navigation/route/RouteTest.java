package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.destination.data.Rate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouteTest {
    private final static double DEFAULT_DELTA = 0.001;
    private final static Destination BASE_DESTINATION = new Destination(new Location(""));
    private final static Rate FIRST_RATE = new Rate("first", 10);
    private final static Rate SECOND_RATE = new Rate("second", 20);
    private final static Rate THIRD_RATE = new Rate("third", 30);

    private Route route;

    @Before
    public void createRoute() {
        route = new Route(BASE_DESTINATION.changeRate(FIRST_RATE), BASE_DESTINATION.changeRate(SECOND_RATE), BASE_DESTINATION.changeRate(THIRD_RATE), BASE_DESTINATION);
    }

    @Test
    public void calcRateSum_returnsRateSum() {
        assertEquals(FIRST_RATE.getValue() + SECOND_RATE.getValue() + THIRD_RATE.getValue(), route.calcRateSum(), DEFAULT_DELTA);
    }
}
