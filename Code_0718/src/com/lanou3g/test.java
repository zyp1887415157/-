package com.lanou3g;

import com.lanou3g.homework.Goods;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("aa",16,188,180);
        Person p2 = new Person("TOM",18,170,180);
        persons.add(p1);
        persons.add(p2);
        System.out.println(persons.size());
        Person person = persons.get(0);
        System.out.println(person);
        Person remove = persons.remove(0);
        boolean aa = persons.remove("aa");
        System.out.println(remove);
        System.out.println(aa);
        System.out.println(persons);
    }
}
