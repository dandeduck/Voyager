package com.navapp.navigation.util.exceptions;

public class LackingPermissionException extends Exception {
    public LackingPermissionException(String permissionName) {
        super(permissionName);
    }
}
