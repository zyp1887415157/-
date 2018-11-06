package com.lanou.java.Test2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Component
public class Person {
    @Value("黎明")
    private String name;
    @Resource(name = "dog")
    private Animal animal;

    public void playwith(){
        System.out.println(this.name+"在跟他玩");
        animal.show();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", animal=" + animal +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
