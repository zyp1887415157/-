package com.lanou3g;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Goods g = new Goods();
        g.setName("手机");
        g.setPrice(1999);
        g.setUnit("台");

        //转成Map
        /*
        name = 手机
        price= 1999
        unit= 台
         */

        Map<String,Object> map = beanToMap(g);
        System.out.println(map);

    }

    private static Map<String, Object> beanToMap(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String,Object> goodsMap = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object o = field.get(obj);
            goodsMap.put(name,o);
        }
        return goodsMap;
    }

    public static class Goods{
        private String name;
        private float price;
        private String unit;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
