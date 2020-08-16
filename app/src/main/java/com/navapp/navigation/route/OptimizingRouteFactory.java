package com.navapp.navigation.route;

import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.requests.RoutePlanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OptimizingRouteFactory implements RouteFactory{
    private final RoutePlanner routePlanner;

    public OptimizingRouteFactory(GeoApiContext context) {
        this(new RoutePlanner(context));
    }

    public OptimizingRouteFactory(RoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
    }

    @Override
    public Route create(Location start, List<Destination> destinations, Location end) throws InterruptedException, ApiException, IOException {
        List<String> destinationIds = extractIds(destinations);
        List<String> orderedDestinationIds = routePlanner.orderedRouteIds(start.getId(), destinationIds, end.getId());
        combineDestinationsWithNewIds(destinations, orderedDestinationIds, end);

        return new Route(destinations);
    }

    private List<String> extractIds(List<Destination> destinations) {
        List<String> destinationIds = new ArrayList<>();

        for (Destination destination: destinations)
            destinationIds.add(destination.getLocationId());

        return destinationIds;
    }

    private void combineDestinationsWithNewIds(List<Destination> destinations, List<String> orderedIds, Location end) {
        for (int i = 0; i < orderedIds.size()-1; ++i)
            replaceDestinationWithMatchingId(destinations, orderedIds.get(i));

        destinations.add(new Destination(end));
    }

    private void replaceDestinationWithMatchingId(List<Destination> destinations, String id) {
        for (int i = 0; i < destinations.size(); ++i) {
            if(isEqualId(destinations.get(i), id)) {
                Destination removed = destinations.remove(i);
                destinations.add(removed.changeLocation(id));
            }
        }
    }

    private boolean isEqualId(Destination destination, String id) {
        return destination.getLocationId().equals(id);
    }
}
