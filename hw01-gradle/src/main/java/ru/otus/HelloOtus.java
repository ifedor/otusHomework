package ru.otus;

import com.google.common.collect.Lists;

public class HelloOtus {
    public static void main(String[] args) {
        System.out.println(
                String.join(" ", Lists.newArrayList("hello", "otus"))
        );
    }
}
