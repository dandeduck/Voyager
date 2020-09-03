package com.nvapp.navigation.route;

import android.net.Uri;

import com.google.maps.model.LatLng;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.route.Route;
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
    private static final String NAVIGATION_LINK =  "https://www.google.com/maps/dir/?api=1";
    private static final String ORIGIN_TEMPLATE = "&origin=%s&origin_place_id=%s";
    private static final String DESTINATION_TEMPLATE = "&destination=%s&destination_place_id=%s";
    private static final String WAYPOINT_TEMPLATE = "&waypoints=%s|%s&waypoint_place_ids=%s|%s";

    private static final String DRIVING_TRAVEL_MODE = "&travelmode=driving";
    private static final String SKIP_OVERVIEW = "&dir_action=navigate";

    private Route route;
    private String baseExpectedLinkText;

    @Before
    public void createRoute() {
        ArrayList<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination(new Location("1", "address1", new LatLng(0, 0))));
        destinations.add(new Destination(new Location("2", "address2", new LatLng(0, 0))));
        destinations.add(new Destination(new Location("3", "address3", new LatLng(0, 0))));
        destinations.add(new Destination(new Location("4", "address4", new LatLng(0, 0))));

        route = new Route(destinations);

        baseExpectedLinkText = String.format(NAVIGATION_LINK + ORIGIN_TEMPLATE + DESTINATION_TEMPLATE + WAYPOINT_TEMPLATE, "address1", "1", "address4", "4","address2", "address3", "2", "3");
    }

    @Test
    public void create_falseFlags_returnCorrectUri() {
        assertEquals(Uri.parse(baseExpectedLinkText), RouteLinkFactory.create(route, false, false));
    }
}
