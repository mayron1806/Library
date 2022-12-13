package com.mayron.library.utils;

public class StringUtils {
    public static String addCharAtPosition(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }
}
