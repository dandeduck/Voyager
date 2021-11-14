package com.navapp.navigation.route;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Place;

import java.util.ArrayList;
import java.util.List;

public class OptimizingRouteFactory implements RouteFactory{
    private final RoutePlanner routePlanner;

    public OptimizingRouteFactory(GeoApiContext context, List<DirectionsApi.RouteRestriction> restrictions) {
        this(new RoutePlanner(context, restrictions));
    }

    public OptimizingRouteFactory(RoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
    }

    @Override
    public void requestCreation(Place start, List<Destination> destinations, Place end, PendingResult.Callback<Route> callback){
        routePlanner.requestOrderedRouteIds(start.getId(), extractIds(destinations), end.getId(), new PendingResult.Callback<List<String>>() {
            @Override
            public void onResult(List<String> result) {
                callback.onResult(new Route(orderDestinationsByIds(destinations, result, end)));
            }

            @Override
            public void onFailure(Throwable e) {
                callback.onFailure(e);
            }
        });
    }

    private List<String> extractIds(List<Destination> destinations) {
        List<String> destinationIds = new ArrayList<>();

        for (Destination destination: destinations)
            destinationIds.add(destination.getPlaceId());

        return destinationIds;
    }

    private List<Destination> orderDestinationsByIds(List<Destination> destinations, List<String> orderedIds, Place end) {
        List<Destination> orderedDestinations = new ArrayList<>();

        for (int i = 0; i < orderedIds.size()-1; ++i)
            orderedDestinations.add(correspondingDestination(destinations, orderedIds.get(i)));

        orderedDestinations.add(new Destination(end));

        return orderedDestinations;
    }

    private Destination correspondingDestination(List<Destination> destinations, String id) {
        for (int i = 0; i < destinations.size(); ++i)
            if(isEqualId(destinations.get(i), id))
                return destinations.remove(i);
        throw new IllegalArgumentException("No destination with given place id");
    }

    private boolean isEqualId(Destination destination, String id) {
        return destination.getPlaceId().equals(id);
    }
}
