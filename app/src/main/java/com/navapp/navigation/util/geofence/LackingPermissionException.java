package com.navapp.navigation.util.geofence;

public class LackingPermissionException extends Exception {
    public LackingPermissionException(String permissionName) {
        super(permissionName);
    }
}
