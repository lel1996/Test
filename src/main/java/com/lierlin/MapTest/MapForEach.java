package com.lierlin.MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapForEach {

    public static void main(String[] args) {
        Map<String,Integer> test =new HashMap();
        for (int i = 0; i <3 ; i++) {
            test.put("��"+i+"������",i);
        }
        for(int i =0; i<test.size();i++){
            System.out.println(test.get("��"+i+"������"));
            ///System.out.println("��"+i+"������");
        }
        System.out.println("---------------------------");
        //Set Strings = test.keySet();
        for (String key:test.keySet()){
            System.out.println(test.get(key));
        }
    }
}
