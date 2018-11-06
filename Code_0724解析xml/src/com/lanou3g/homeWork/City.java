package com.lanou3g.homeWork;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("市名")
    private String cityName;
    @SerializedName("编码")
    private String code;


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
