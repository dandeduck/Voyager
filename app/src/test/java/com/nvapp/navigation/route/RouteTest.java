package com.nvapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.destination.data.Rate;
import com.navapp.navigation.route.Route;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RouteTest {
    private final static double DEFAULT_DELTA = 0.001;
    private final static Destination BASE_DESTINATION = new Destination(new Location("", "", null));

    @Test
    public void calcRateSum_normal_returnsRateSum() {
        final Rate FIRST_RATE = new Rate("first", 10);
        final Rate SECOND_RATE = new Rate("second", 20);
        final Rate THIRD_RATE = new Rate("third", 30);
        Route route = new Route(BASE_DESTINATION.changeRate(FIRST_RATE), BASE_DESTINATION.changeRate(SECOND_RATE), BASE_DESTINATION.changeRate(THIRD_RATE), BASE_DESTINATION);

        assertEquals(FIRST_RATE.getValue() + SECOND_RATE.getValue() + THIRD_RATE.getValue(), route.calcRateSum(), DEFAULT_DELTA);
    }
}
