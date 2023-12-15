package io.github.rexmolo.models;

import io.github.rexmolo.utils.Verify;

import java.util.Objects;

public class AppUser {

    private String userName;
    private String password;
    private AppRole role;

    public AppUser(String userName, String password, AppRole role) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setRole(role);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        Verify.arguments("userName", userName);
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Verify.arguments("password", password);
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userName, appUser.userName) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
}
