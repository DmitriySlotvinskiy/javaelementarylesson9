package com.slotvinskiy;

import java.util.Map;
import java.util.TreeMap;

public class TestMyTreeMap {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap();
        map.put("5", "Five");
        map.put("8", "Eight");
        map.put("3", "Three");
        map.put("1", "newOne");
        map.put("2", "Two");
        map.put("7", "Seven");
        map.put("9", "Nine");
        map.put("4", "Four");

        MyMap<String, String> myMap = new MyTreeMap();
        myMap.put("5", "Five");
        myMap.put("8", "Eight");
        myMap.put("3", "Three");
        myMap.put("1", "newOne");
        myMap.put("2", "Two");
        myMap.put("7", "Seven");
        myMap.put("9", "Nine");
        myMap.put("4", "Four");

        System.out.println(myMap.containsKey("3") + " " + map.containsKey("3"));
        System.out.println(myMap.get("3") + " " + map.get("3"));
        System.out.println(myMap.containsKey("2") + " " + map.containsKey("2"));
        System.out.println(myMap.get("2") + " " + map.get("2"));
        System.out.println(myMap.containsKey("0") + " " + map.containsKey("0"));
        System.out.println(myMap.get("0") + " " + map.get("0"));

        System.out.println(myMap);
        System.out.println(map);
        System.out.println("Size is " + myMap.size());
        System.out.println("Size is " + map.size());
        myMap.clear();
        map.clear();
        System.out.println("Size after myMap.clear() is " + myMap.size());
        System.out.println("Size after map.clear() is " + map.size());
    }
}
