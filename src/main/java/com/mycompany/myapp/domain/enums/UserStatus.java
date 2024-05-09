package com.mycompany.myapp.domain.enums;

public enum UserStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");
    //    BLOCKED("Blocked");
    private final String statusName;

    UserStatus(String statusName) {
        this.statusName = statusName;
    }

}
