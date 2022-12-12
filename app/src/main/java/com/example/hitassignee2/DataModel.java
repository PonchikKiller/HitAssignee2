package com.example.hitassignee2;


public class DataModel {

    String name;
    String description;
    int image;

    public DataModel(String name, String version, int image) {
        this.name = name;
        this.description = version;
        this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

}