package com.example.migration.endpoints.backend;

public class Reward {

    public Reward(String trophy, int points) {
        this.trophy = trophy;
        this.points = points;
    }

    private String trophy;
    private int points;

    public String getTrophy() {
        return trophy;
    }

    public int getPoints() {
        return points;
    }
}
