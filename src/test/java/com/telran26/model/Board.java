package com.telran26.model;

public class Board {
    String title;
    String team;

    public Board withTitle(String title) {
        this.title = title;
        return this;
    }

    public Board withTeam(String team) {
        this.team = team;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getTeam() {
        return team;
    }
}
