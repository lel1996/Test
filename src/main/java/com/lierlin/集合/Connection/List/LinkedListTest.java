package com.lierlin.¼¯ºÏ.Connection.List;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list =new LinkedList();
        list.add("lierlin");
        list.add("lidalin");
        list.set(1,"li");
        System.out.println(list.element());
        System.out.println(list.get(1)+""+list.get(0));
    }


}
