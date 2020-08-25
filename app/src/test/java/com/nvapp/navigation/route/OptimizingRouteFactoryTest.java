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
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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

        mock_callBackOrderedRouteIds(Arrays.asList("1", "2", "3", "4", "5", "6"), "0", Arrays.asList("2", "1", "5", "4", "3"), "6");

        OptimizingRouteFactory optimizingRouteFactory = new OptimizingRouteFactory(routePlanner);
        final Route EXPECTED_ROUTE = new Route(ORDERED_DESTINATIONS_WITH_END);

        PendingResult.Callback<Route> callback = new PendingResult.Callback<Route>() {
            @Override
            public void onResult(Route result) {
                assertEquals(EXPECTED_ROUTE, result);
            }

            @Override
            public void onFailure(Throwable e) {
            }
        };

        optimizingRouteFactory.callbackCreate(START, UNORDERED_DESTINATIONS, END, callback);
    }

    private void mock_callBackOrderedRouteIds(List<String> callbackValue, String originId, List<String> waypointIds, String destinationId) {
        doAnswer(invocation -> {
            PendingResult.Callback<List<String>> callback = invocation.getArgument(3);
            callback.onResult(callbackValue);
            return null;
        }).when(routePlanner).callbackOrderedRouteIds(eq(originId), eq(waypointIds), eq(destinationId), any());
    }
}
