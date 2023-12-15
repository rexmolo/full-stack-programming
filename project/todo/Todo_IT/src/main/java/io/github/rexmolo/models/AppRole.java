package io.github.rexmolo.models;

public enum AppRole {

    ROLE_APP_USER(1),
    ROLE_APP_ADMIN(2);

    private int role;
    private AppRole(int role){
        this.role = role;
    }

}
