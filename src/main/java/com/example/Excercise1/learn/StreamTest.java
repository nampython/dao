package com.example.Excercise1.learn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface Sayable1 {
    public String say();
}

@FunctionalInterface
interface Sayable2 {
    public abstract int sum(int a, int b);

    public abstract int hashCode();

    default void default1() {

    }
}

public class StreamTest {

    public static void sortedByCollection(List<String> lst) {
        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        List myIntList = new LinkedList(); // 1
        myIntList.add(0); // 2
        Integer x = (Integer) myIntList.iterator().next(); // 3

    }
}
