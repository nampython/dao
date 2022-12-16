package com.example.Excercise1.utils;

import org.springframework.stereotype.Component;

public interface StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public abstract boolean isEmpty(String str);
    public abstract boolean isNotEmpty(String str);
    public abstract boolean isBlank(String str);
    public abstract String strip(String str, String stripChars);
    public abstract String stripStart(String str, String stripChars);
    public abstract String stripEnd(String str, String stripChars);

}
