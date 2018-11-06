package com.lanou3g.homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Province> provinceList = new ArrayList<>();
        try (FileReader fileReader = new FileReader("area.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("  ") && !line.startsWith("    ")) {
                    String trim = line.trim();
                    String[] split = trim.split(" ");
                    City city = new City();
                    city.setName(split[0]);
                    city.setId(Integer.parseInt(split[1]));
                    Province province = provinceList.get(provinceList.size() - 1);
                    List<City> cityList1 = province.getCityList();
                    List<Area> areaList = new ArrayList<>();
                    city.setAreaList(areaList);
                    cityList1.add(city);
                } else if (line.startsWith("    ")) {
                    String trim = line.trim();
                    String[] split = trim.split(" ");
                    Area area = new Area();
                    area.setName(split[0]);
                    area.setId(Integer.parseInt(split[1]));
                    Province province = provinceList.get(provinceList.size() - 1);
                    List<City> cityList = province.getCityList();
                    City city1 = cityList.get(cityList.size() - 1);
                    List<Area> areaList = city1.getAreaList();
                    areaList.add(area);
                } else {
                    String[] split = line.split(" ");
                    Province province = new Province();
                    province.setName(split[0]);
                    province.setId(Integer.parseInt(split[1]));

                    provinceList.add(province);
                    List<City> cityList1 = new ArrayList<>();
                    province.setCityList(cityList1);
                }
            }
            System.out.println(provinceList);
            for (Province province : provinceList) {
                String name = province.getName();
                int id = province.getId();
                System.out.println(name + " " + id);
                List<City> cityList = province.getCityList();
                for (City city : cityList) {
                    String name1 = city.getName();
                    int id1 = city.getId();
                    System.out.println("  " + name1 + " " + id1);
                    List<Area> areaList = city.getAreaList();
                    for (Area area : areaList) {
                        String name2 = area.getName();
                        int id2 = area.getId();
                        System.out.println("    " + name2 + " " + id2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
