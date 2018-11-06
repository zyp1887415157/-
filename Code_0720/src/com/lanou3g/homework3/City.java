package com.lanou3g.homework3;

import java.util.List;

public class City {
    private int id;
    private String name;
    private List<Area> areaList;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", areaList=" + areaList +
                '}';
    }

    public City(int id, String name, List<Area> areaList) {
        this.id = id;
        this.name = name;
        this.areaList = areaList;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public City setAreaList(List<Area> areaList) {
        this.areaList = areaList;
        return this;
    }

    public int getId() {
        return id;
    }

    public City setId(int id) {
        this.id = id;
        return this;
    }
}
