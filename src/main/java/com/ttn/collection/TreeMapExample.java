package com.ttn.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1, 1);
        map.put(10, 1);
        map.put(5, 1);
        map.put(3, 1);


        System.out.println(map);
        System.out.println(map.ceilingEntry(2));
        System.out.println(map.floorEntry(2));


        Comparator<MyClass> c = (a, b) -> {
            return Integer.compare(a.getAge(), b.getAge());
        };

        TreeMap<MyClass, Integer> map2 = new TreeMap<>(c);
        TreeMap<MyClass, Integer> map1 = new TreeMap<>(new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });


    }

    class MyClass {
        int age;
        int value;

        public MyClass(int age, int value) {
            this.age = age;
            this.value = value;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
