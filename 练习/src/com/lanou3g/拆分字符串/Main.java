package com.lanou3g.拆分字符串;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "name=张三,age=15,height=1.8 name=李四,age=20,height=1.6 name=王五,age=22,height=1.78";
        String[] split = s.split(" ");
        Person[] persons = new Person[split.length];


        for (int i =0;i<split.length;i++){
            Person p = new Person();
            String s1 = split[i];
            String[] split1 = s1.split("[=,]");
            p.setName(split1[1]);
            p.setAge(Integer.parseInt(split1[3]));
            p.setHeight(Float.parseFloat(split1[5]));
            persons[i]=p;
        }
        for (int i = 0;i<persons.length;i++) {
            System.out.println(persons[i].getName()+" "+persons[i].getAge()+" "+persons[i].getHeight());
        }

        int i = 0;
        for (String s1 : split) {
            String[] split1 = s1.split(",");
            Person person = new Person();
            for (String s2 : split1) {
                String[] split2 = s2.split("=");
                if (split2[0].equals("name")){
                    person.setName(split2[1]);
                }else if (split2[0].equals("age")){
                    person.setAge(Integer.parseInt(split2[1]));
                }else if (split2[0].equals("height")){
                    person.setHeight(Float.parseFloat(split2[1]));
                }
            }
            persons[i]=person;
            i++;
        }
        for (Person person : persons) {
            System.out.println(person);
        }
    }




}
