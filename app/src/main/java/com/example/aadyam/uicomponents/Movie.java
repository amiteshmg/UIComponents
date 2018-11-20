package com.example.aadyam.uicomponents;

public class Movie {
    private String name;
    private String description;
    private int poster;

    public Movie() {
    }

    public Movie(String name, String description,int poster) {
        this.name = name;
        this.description = description;
        this.poster=poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void getDescription(String description) {
        this.description = description;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
