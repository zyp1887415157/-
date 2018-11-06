package com.lanou3g;

import com.lanou3g.compare.MyCollections;
import com.lanou3g.compare.MyComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("张三", 18, 70, 170);
        persons[1] = new Person("李四", 20, 50, 188);
        persons[2] = new Person("王五", 16, 66, 165);
        persons[3] = new Person("赵六", 32, 82, 183);
        persons[4] = new Person("田七", 26, 73, 185);

        MyCollections.sort(persons, new MyComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getWeight()>o2.getWeight()){
                    return 1;
                }else if (o1.getWeight()<o2.getWeight()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(persons));


        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog("小白",14,20);
        dogs[1] = new Dog("小黑",13,25);   
        MyCollections.sort(dogs, new MyComparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1.getAge()>o2.getAge()){
                    return 1;
                }else if (o1.getAge()<o2.getAge()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(dogs));
    }
}
