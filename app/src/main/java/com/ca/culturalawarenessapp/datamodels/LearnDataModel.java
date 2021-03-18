package com.ca.culturalawarenessapp.datamodels;

public class LearnDataModel {
    private int id;
    private String name;
    private String info;
    public LearnDataModel(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public LearnDataModel(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }



}
