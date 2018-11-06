package com.lanou3g.homework3;

public class Area {
    private int id;
    private String name;


    public Area() {
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Area(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Area setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }
}
