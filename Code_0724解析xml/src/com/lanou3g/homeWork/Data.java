package com.lanou3g.homeWork;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("城市代码")
    private List<Province> provinces;

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
}
