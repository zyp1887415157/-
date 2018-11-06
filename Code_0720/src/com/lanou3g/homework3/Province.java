package com.lanou3g.homework3;

import java.util.List;

public class Province {
    private int id;
    private String name;
    private List<City> cityList;


    public Province() {
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityList=" + cityList +
                '}';
    }

    public Province(int id, String name, List<City> cityList) {
        this.id = id;
        this.name = name;
        this.cityList = cityList;
    }

    public String getName() {
        return name;
    }

    public Province setName(String name) {
        this.name = name;
        return this;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public Province setCityList(List<City> cityList) {
        this.cityList = cityList;
        return this;
    }

    public int getId() {
        return id;
    }

    public Province setId(int id) {
        this.id = id;
        return this;
    }
}
