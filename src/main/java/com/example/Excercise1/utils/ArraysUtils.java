package com.example.Excercise1.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class ArraysUtils {
    /**
     *
     * @param arr
     * @return
     * @param <T>
     */
    public static <T> List<T> fromArraysToList(T[] arr) {
        if (arr == null) {
            throw new NullPointerException("");
        }
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    /**
     *
     * @param arr
     * @param mapperFunction
     * @return
     * @param <T>
     * @param <G>
     */
    public static <T, G> List<G> fromArraysToList(T[] arr, Function<T, G> mapperFunction) {
        if (arr == null) {
            throw new NullPointerException("");
        }
        return Arrays.stream(arr)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }
}
