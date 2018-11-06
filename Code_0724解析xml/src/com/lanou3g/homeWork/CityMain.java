package com.lanou3g.homeWork;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Date;

public class CityMain {

    public static void main(String[] args) throws FileNotFoundException {
        Reader r = new FileReader("ChineseCity.txt");
        Data d = new Gson().fromJson(r,Data.class);

    }
}
