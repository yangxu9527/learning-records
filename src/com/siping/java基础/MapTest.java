package com.siping.java基础;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Yang Xu
 * @date 2020/9/29 9:51
 * @description:
 */
public class MapTest extends HashMap {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("f", 1);
        map.put("h", 2);
        MapTest mapTest = new MapTest();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        entrySet.forEach(entry -> {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ", " + value);
        });

        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
    }
}
