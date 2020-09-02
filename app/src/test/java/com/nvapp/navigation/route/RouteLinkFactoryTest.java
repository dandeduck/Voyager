package com.nvapp.navigation.route;

import com.navapp.navigation.route.Route;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RouteLinkFactoryTest {
    private static final String NAVIGATION_LINK =  "https://www.google.com/maps/dir/?api=1";
    private static final String ORIGIN = "&origin=";
    private static final String ORIGIN_PLACE_ID = "&origin_place_id=";
    private static final String DESTINATION = "&destination=";
    private static final String DESTINATION_PLACE_ID = "&destination_place_id=";
    private static final String WAYPOINTS = "&waypoints=";
    private static final String WAYPOINT_PLACE_ID = "&waypoint_place_ids=";
    private static final char WAYPOINT_SEPARATOR = '|';

    private static final String DRIVING_TRAVEL_MODE = "&travelmode=driving";
    private static final String SKIP_OVERVIEW = "&dir_action=navigate";

    private Route route;

    @Before
    public void createRoute() {

    }

}
