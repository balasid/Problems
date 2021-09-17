package com.bala.hackerrank;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUMap {
    int size;
    Map<Integer, Integer> map;
    Deque<Integer> stack;

    public LRUMap(int size) {
        this.size = size;
        map = new HashMap<>(size);
        stack = new LinkedList<>();
    }

    public void addToCache(Integer key, Integer value) {
        Integer integer = map.get(key);
        if (integer != null) {
            stack.remove(integer);
        } else {
            Integer last = stack.removeLast();
            map.put(key, value);
        }
        stack.push(key);
    }


}
