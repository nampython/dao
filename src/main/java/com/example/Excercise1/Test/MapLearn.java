package com.example.Excercise1.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapLearn {
    public static void main(String[] args) {
        Map<Object, Object>  map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.entrySet()
                .stream()
                .forEach(System.out::println);
    }
}
