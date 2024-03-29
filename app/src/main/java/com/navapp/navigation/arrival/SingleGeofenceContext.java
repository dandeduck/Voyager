package com.navapp.navigation.arrival;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.maps.model.LatLng;

import java.io.Closeable;
import java.util.Collections;

public class SingleGeofenceContext implements Closeable {
    private static final String FENCE_NAME = "destination";
    private final GeofencingClient client;
    private final LatLng destination;
    private final float detectionRadius;

    public SingleGeofenceContext(Context context, LatLng destination, float detectionRadius, OnFailureListener onFailureListener) throws PermissionMissingException {
        client = LocationServices.getGeofencingClient(context);
        this.destination = destination;
        this.detectionRadius = detectionRadius;

        addFence(context, onFailureListener);
    }

    @Override
    public void close() {
        client.removeGeofences(Collections.singletonList("destination"));
    }

    private void addFence(Context context, OnFailureListener onFailureListener) throws PermissionMissingException {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            throw new PermissionMissingException(Manifest.permission.ACCESS_FINE_LOCATION);

        GeofencingRequest geofencingRequest = getGeofencingRequest(getGeofence());
        PendingIntent geofencePendingIntent = getGeofencePendingIntent(context);

        client.addGeofences(geofencingRequest, geofencePendingIntent).addOnFailureListener(onFailureListener);
    }

    private Geofence getGeofence() {
        return new Geofence.Builder()
                .setRequestId(FENCE_NAME)
                .setCircularRegion(destination.lat, destination.lng, detectionRadius)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
                .build();
    }

    private GeofencingRequest getGeofencingRequest(Geofence geofence) {
        return new GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofences(Collections.singletonList(geofence))
                .build();
    }

    private PendingIntent getGeofencePendingIntent(Context context) {
        Intent intent = new Intent(context, UponArrival.class);

        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
