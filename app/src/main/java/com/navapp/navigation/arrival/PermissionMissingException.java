package com.navapp.navigation.arrival;

public class PermissionMissingException extends Exception {
    public PermissionMissingException(String permissionName) {
        super(permissionName);
    }
}
