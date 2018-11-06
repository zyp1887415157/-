package com.lanou3g.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String s1 = "name=张三,age=15,height=1.8 name=李四,age=20,height=1.6 name=王五,age=22,height=1.78";
        String[] split2 = s1.split(" ");
        Person[] people = new Person[split2.length];
        int i = 0;

        for (String s : split2) {
            String [] split3 = s.split(",");
            Person person = new Person();
            for (String s2 : split3){
                String [] split4 = s2.split("=");
                System.out.println(Arrays.toString(split4));
                if (split4[0].equals("name")){
                    person.setName(split4[1]);
                }else if (split4[0].equals("age")){
                    person.setAge(Integer.parseInt(split4[1]));
                }else if (split4[0].equals("height")){
                    person.setHeight(Double.parseDouble(split4[1]));
                }
            }
            people [i] = person;
            i++;
            System.out.println(person);
        }

        for (int i1 =0;i1<split2.length;i1++){
            Person p = new Person();
            String s = split2[i1];
            String [] split3 = s.split("[=,]");
            p.setName(split3[1]);
            p.setAge(Integer.parseInt(split3[3]));
            p.setHeight(Double.parseDouble(split3[5]));
            people [i1] = p;
        }
        for (int i1 = 0;i1<people.length;i1++){
            System.out.println(people[i1].getName()+","+people[i1].getAge()+","+people[i1].getHeight());
        }
    }
}
