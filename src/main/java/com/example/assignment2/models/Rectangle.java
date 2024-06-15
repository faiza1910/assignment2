package com.example.assignment2.models;

public class Rectangle {
    private int id;
    private String name;
    private int width;
    private int height;
    private String color;
    public Rectangle() {
    }
    public Rectangle(int id, String name, int width, int height, String color) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
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
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    } 
}
