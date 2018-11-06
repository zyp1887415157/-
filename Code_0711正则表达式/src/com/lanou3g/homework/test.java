package com.lanou3g.homework;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String s1 = "name=张三,age=15,height=1.8 name=李四,age=20,height=1.6 name=王五,age=22,height=1.78";
        String[] split = s1.split(" ");
        Person [] persons = new Person[split.length];
        for (int i =0;i<split.length;i++){
                String s = split[i];
                Person person = new Person();
                String [] split1 = s.split("[=,]");
            System.out.println(Arrays.toString(split1));
            person.setName(split1[1]);
            person.setAge(Integer.parseInt(split1[3]));
            person.setHeight(Double.parseDouble(split1[5]));
            persons[i] = person;
        }
        for (int i = 0;i<persons.length;i++){
            System.out.println(persons[i].getName()+persons[i].getAge()+persons[i].getHeight());
        }
    }

}
