package com.nvapp.navigation.route;

import com.google.maps.model.LatLng;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Place;
import com.navapp.navigation.destination.data.Rate;
import com.navapp.navigation.route.Route;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RouteTest {
    private static final double DEFAULT_DELTA = 0.001;
    private static final Destination BASE_DESTINATION = new Destination(new Place("", "", new LatLng(0, 0)));
    private static final Rate FIRST_RATE = new Rate("first", 10);
    private static final Rate SECOND_RATE = new Rate("second", 20);
    private static final Rate THIRD_RATE = new Rate("third", 30);

    private Route route;

    @Before
    public void createRoute() {
        route = new Route(BASE_DESTINATION.changeRate(FIRST_RATE), BASE_DESTINATION.changeRate(SECOND_RATE), BASE_DESTINATION.changeRate(THIRD_RATE));
    }

    @Test
    public void calcRateSum_normal_returnsRateSum() {
        assertEquals(FIRST_RATE.getValue() + SECOND_RATE.getValue() + THIRD_RATE.getValue(), route.calcRateSum(), DEFAULT_DELTA);
    }

    @Test
    public void getOrigin_normal_returnsFirstDestination() {
        assertEquals(BASE_DESTINATION.changeRate(FIRST_RATE), route.getOrigin());
    }

    @Test
    public void getDestination_normal_returnsLastDestination() {
        assertEquals(BASE_DESTINATION.changeRate(THIRD_RATE), route.getDestination());
    }

    @Test
    public void getWaypoints_normal_returnsDestinationsBetweenFirstAndLast() {
        assertEquals(Collections.singletonList(BASE_DESTINATION.changeRate(SECOND_RATE)), route.getWaypoints());
    }
}
