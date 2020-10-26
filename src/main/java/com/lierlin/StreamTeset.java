package com.lierlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.stream.Stream;

public class StreamTeset {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("lierlin");
        arrayList.add("lidalin");
        arrayList.add("lichunxia");
        arrayList.add("lidegong");
    Stream<String> stream = arrayList.stream();
    //stream.forEach(s->System.out.println(s));
    System.out.println("____________________");
    stream.forEach(System.out::println);

    }
}
