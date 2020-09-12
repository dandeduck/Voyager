package com.nvapp.navigation.route;

import com.google.maps.model.LatLng;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Place;
import com.navapp.navigation.route.Route;
import com.navapp.navigation.route.RouteLinkBuilder;
import com.navapp.navigation.route.RouteLinkFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RouteLinkFactoryTest {
    private Route route;
    private RouteLinkBuilder linkBuilder;

    @Before
    public void createRouteAndRouteLinkBuilder() {
        ArrayList<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination(new Place("1", "address1", new LatLng(0, 0))));
        destinations.add(new Destination(new Place("2", "address2", new LatLng(0, 0))));
        destinations.add(new Destination(new Place("3", "address3", new LatLng(0, 0))));
        destinations.add(new Destination(new Place("4", "address4", new LatLng(0, 0))));

        route = new Route(destinations);

        linkBuilder = new RouteLinkBuilder()
                .origin(route)
                .destination(route)
                .waypoints(route);
    }

    @Test
    public void create_falseFlags_returnCorrectUri() {
        assertEquals(linkBuilder.build(), RouteLinkFactory.create(route, false, false));
    }

    @Test
    public void create_trueChooseDriving_returnCorrectUri() {
        assertEquals(linkBuilder.onlyDriving().build(), RouteLinkFactory.create(route, true, false));
    }

    @Test
    public void create_trueSkipOverview_returnCorrectUri() {
        assertEquals(linkBuilder.skipOverview().build(), RouteLinkFactory.create(route, false, true));
    }
}
