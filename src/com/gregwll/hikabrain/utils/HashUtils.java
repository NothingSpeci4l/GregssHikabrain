package com.gregwll.hikabrain.utils;

import java.util.HashMap;
import java.util.Map;

public class HashUtils {
    public static <K, V> K getKey(HashMap<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
