package com.maeruiz.uagrmapp.Model.MoodleDao;

/**
 * Created by maelyruiz on 5/26/17.
 */

public class UserExtra {

    private String token;
    private User user;

    public UserExtra(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
