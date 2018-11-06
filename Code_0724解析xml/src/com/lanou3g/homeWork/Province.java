package com.lanou3g.homeWork;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Province {

    @SerializedName("省")
    private String name;
    @SerializedName("市")
    private List<City> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
