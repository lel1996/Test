package com.lierlin.����.Map;

import java.util.HashMap;
import java.util.Map;
/*h = key.hashCode()) ^ (h >>> 16*/
public class DebugMap {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("lierlin","�����");
        int h; String key="lierlin";
        int i = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(i);
        System.out.println((key.hashCode()^(key.hashCode() >>>16))&15);




    }
}
