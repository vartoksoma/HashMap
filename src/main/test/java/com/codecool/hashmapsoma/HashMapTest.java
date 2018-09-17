package com.codecool.hashmapsoma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class HashMapTest {

    @Test
    void testAdd(){
        MyHashMap<String, Integer> hm = new MyHashMap<>();
        hm.add("mivane", 52);
        assertEquals(52, hm.getValue("mivane"));
    }

    @Test
    void testRemove(){
        MyHashMap<String, Integer>hm = new MyHashMap<>();
        hm.add("mivane", 52);
        hm.remove("mivane");
        assertThrows(NullPointerException.class, () -> hm.getValue("key"));
    }

    @Test
    void testClearAll(){
        MyHashMap<String, Integer> hm = new MyHashMap<>();
        hm.add("s", 1);
        hm.add("a", 2);
        hm.clearAll();
        assertThrows(NullPointerException.class, () -> hm.getValue("a"));
    }
}
