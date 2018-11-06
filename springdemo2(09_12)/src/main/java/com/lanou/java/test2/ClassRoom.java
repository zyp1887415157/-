package com.lanou.java.test2;


import java.util.List;
import java.util.Map;

public class ClassRoom {
    String name;
    Integer num;
    List<Person> persons;
    Map<String,Person> personMap;

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", persons=" + persons +
                ", personMap=" + personMap +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }
}
