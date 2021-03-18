package com.ca.culturalawarenessapp.datamodels;
/*
    Author : Rushabh Picha
 */
public class Category {
    public static final int Asian = 1;
    public static final int African = 2;
    public static final int American = 3;

    private int id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return getName();
    }
}
