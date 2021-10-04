package com.bala.hackerrank;

import java.util.*;

public class LRUMap {
    int size;
    Map<Integer, Integer> map;
    Deque<Integer> stack;

    public LRUMap(int size) {
        this.size = size;
        map = new LinkedHashMap<>(size);
        stack = new LinkedList<>();
    }

    public static void main(String[] args) {
        LRUMap lruMap = new LRUMap(3);
        lruMap.addToCache(1, 1);
        lruMap.addToCache(2, 2);
        lruMap.addToCache(3, 3);
        lruMap.addToCache(4, 4);
        System.out.println(lruMap.stack);
    }

    public void addToCache(Integer key, Integer value) {
        Integer integer = map.get(key);
        if (integer != null) {
            stack.remove(integer);
        } else {
            if (stack.size() == size) {
                Integer last = stack.removeLast();
                map.remove(last);
            }
        }
        stack.push(key);
        map.put(key, value);
        System.out.println(map);
    }

    public Integer getFromCache(Integer key) {
        return map.get(key);
    }

}