package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OptimizingRouteFactoryTest {
    private RoutePlanner routePlanner;

    @Before
    public void initializePlanner() {
        routePlanner = new RoutePlanner(null) {
            @Override
            public List<String> callbackOrderedRouteIds(String originId, List<String> waypointIds, String destinationId) {
                List<String> ordered = new ArrayList<>(waypointIds);
                Collections.sort(ordered);
                ordered.add(destinationId);

                return ordered;
            }
        };
    }

    @Test
    public void create_normal_returnsOrderedDestinations() throws Exception {
        final Location START = new Location("0");
        final Location END = new Location("6");
        final List<Destination> UNORDERED_DESTINATIONS = new ArrayList<>(Arrays.asList(
                new Destination(new Location("2")),
                new Destination(new Location("1")),
                new Destination(new Location("5")),
                new Destination(new Location("4")),
                new Destination(new Location("3"))));
        final List<Destination> ORDERED_DESTINATIONS_WITH_END = new ArrayList<>(Arrays.asList(
                new Destination(new Location("1")),
                new Destination(new Location("2")),
                new Destination(new Location("3")),
                new Destination(new Location("4")),
                new Destination(new Location("5")),
                new Destination(END)));

        OptimizingRouteFactory optimizingRouteFactory = new OptimizingRouteFactory(routePlanner);

        final Route ACTUAL_ROUTE = optimizingRouteFactory.create(START, UNORDERED_DESTINATIONS, END);
        final Route EXPECTED_ROUTE = new Route(ORDERED_DESTINATIONS_WITH_END);

        assertEquals(EXPECTED_ROUTE, ACTUAL_ROUTE);
    }
}
