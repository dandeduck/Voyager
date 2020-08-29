package com.navapp.navigation.arrival;

public class LackingPermissionException extends Exception {
    public LackingPermissionException(String permissionName) {
        super(permissionName);
    }
}
