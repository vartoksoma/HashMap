package com.codecool.hashmapsoma;


public class Main {

    public static void main(String[] args) {

        MyHashMap<String, Integer> hm = new MyHashMap<>();
        hm.add("mivane", 56);
        hm.add("mivan", 11);
        hm.add("mi", 1);
        System.out.println(hm.getValue("mi"));
        hm.clearAll();
        hm.getValue("mivane");
        hm.getValue("mi");
    }
}
