package com.lierlin.集合.Map;

import java.util.HashMap;
import java.util.Map;

public class MapForEach {

    public static void main(String[] args) {
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());

        Map<String,Integer> test =new HashMap();
 /*       for (int i = 0; i <3 ; i++) {
            test.put(i+"",i);
        }*/
        /*test.put(1+"",1);
        test.put(2+"",1);
        test.put(4+"",1);*/
        test.put("Aa",1);
        test.put("BB",2);
        for(int i =0; i<test.size();i++){
            System.out.println(test.get("第"+i+"行数据"));
            ///System.out.println("第"+i+"行数据");
        }
        System.out.println("---------------------------");
        //Set Strings = test.keySet();
        for (String key:test.keySet()){
            System.out.println(test.get(key));
        }
    }

}
