package com.codecool.hashmapsoma;

import com.codecool.hashmapsoma.keyValue.KeyValue;
import java.util.LinkedList;


public class MyHashMap<K, V> {

    private int SIZE = 16;
    private LinkedList<KeyValue>[] elements = new LinkedList[SIZE];

    public MyHashMap() {
        for (int i = 0; i < SIZE; i++){
            elements[i] = new LinkedList<KeyValue>();
        }
    }

    public void add(String key, Integer value){
        int position = getHash(key) % SIZE;
        LinkedList list = elements[position];
        if(findKey(key) != null){
            throw new RuntimeException("Specified key already exists");
        }else{
        KeyValue<String, Integer> kv = new KeyValue<>(key, value);
        list.add(kv);
        }
    }

    private int getHash(String key){
        int position = 0;
        for (int i = 0; i < key.length(); i++) {
            position += (int) key.charAt(i);
        }
        return position;
    }

    private KeyValue findKey(String key){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < elements[i].size(); j++){
                if (elements[i].size() == 0){
                    throw new NullPointerException("list is empty");
                }
                if (elements[i].get(j).getKey().equals(key)){
                    return elements[i].get(j);
                }
            }
        }
        return null;
    }

    public int getValue(String key){
        if (findKey(key) == null){
            throw new NullPointerException("No such key");
        }else {
            return (int) findKey(key).getValue();
        }
    }

    public void remove(String key){
        int whichSubList = getHash(key) % SIZE;
        LinkedList<KeyValue> sublist = elements[whichSubList];
        boolean done = false;
        for (int i = 0; i < sublist.size(); i++ ){
            if (sublist.get(i).getKey().equals(key)){
                sublist.remove(i);
                done = true;
            }
        }
        if (!done){
            throw new IllegalArgumentException("No such key!");
        }
    }

    public void clearAll(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < elements[i].size(); j++){
                elements[i].remove(j);
            }
        }
    }
}
