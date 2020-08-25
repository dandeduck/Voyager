package com.nvapp.navigation.route;

import com.google.maps.PendingResult;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.route.OptimizingRouteFactory;
import com.navapp.navigation.route.Route;
import com.navapp.navigation.route.RoutePlanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class OptimizingRouteFactoryTest {
    private RoutePlanner routePlanner;

    @Before
    public void initializePlanner() {
        routePlanner = mock(RoutePlanner.class);
    }

    @Test
    public void create_normal_returnsOrderedDestinations() {
        final Location START = new Location("0");
        final Location END = new Location("6");
        final List<Destination> UNORDERED_DESTINATIONS = Arrays.asList(
                new Destination(new Location("2")),
                new Destination(new Location("1")),
                new Destination(new Location("5")),
                new Destination(new Location("4")),
                new Destination(new Location("3")));
        final List<Destination> ORDERED_DESTINATIONS_WITH_END = Arrays.asList(
                new Destination(new Location("1")),
                new Destination(new Location("2")),
                new Destination(new Location("3")),
                new Destination(new Location("4")),
                new Destination(new Location("5")),
                new Destination(END));

        addCreate_normal_returnsOrderedDestinationsAnswer();
        OptimizingRouteFactory optimizingRouteFactory = new OptimizingRouteFactory(routePlanner);

        final Route EXPECTED_ROUTE = new Route(ORDERED_DESTINATIONS_WITH_END);
        optimizingRouteFactory.callbackCreate(START, UNORDERED_DESTINATIONS, END, new PendingResult.Callback<Route>() {
            @Override
            public void onResult(Route result) {
                assertEquals(EXPECTED_ROUTE, result);
            }

            @Override
            public void onFailure(Throwable e) {
            }
        });
    }

    private void addCreate_normal_returnsOrderedDestinationsAnswer() {
        doAnswer(invocation -> {
            List<String> waypointIds = invocation.getArgument(1);
            String endId = invocation.getArgument(2);
            PendingResult.Callback<List<String>> callback = invocation.getArgument(3);

            List<String> ordered = new ArrayList<>(waypointIds);
            Collections.sort(ordered);
            ordered.add(endId);
            callback.onResult(ordered);

            return null;
        }).when(routePlanner).callbackOrderedRouteIds("0", Arrays.asList("2", "1", "5", "4", "3"), "6", new PendingResult.Callback<List<String>>() { //I realize that this
            @Override
            public void onResult(List<String> result) {
                assertEquals(result, Arrays.asList("1", "2", "3", "4", "5")); //and this, is bad design, but uhhh
            }

            @Override
            public void onFailure(Throwable e) {
            }
        });
    }
}
