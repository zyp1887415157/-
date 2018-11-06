package com.lanou.java.test1;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Dog {
    String name;
    int age;
    private Person host;
    private List<String> list;
    private List<Person> personList;
    private Set<String> set;
    private Set<Person> personSet;
    private Map<String, String> map;
    private Map<String, Person> personMap;
    private Properties properties;

    public Dog() {
    }

    public Dog(String name, int age, Person host, List<String> list) {
        this.name = name;
        this.age = age;
        this.host = host;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", host=" + host +
                ", list=" + list +
                ", personList=" + personList +
                ", set=" + set +
                ", personSet=" + personSet +
                ", map=" + map +
                ", personMap=" + personMap +
                ", properties=" + properties +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
