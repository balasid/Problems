package com.bala.hackerrank;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
    Deque<Integer> deque;
    Set<Integer> set;
    int cacheSize = 3;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        deque = new LinkedList<>();
        set = new HashSet<>();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.addToCache(1);
        System.out.println(cache.deque);
        cache.addToCache(2);
        System.out.println(cache.deque);
        cache.addToCache(3);
        System.out.println(cache.deque);
        cache.addToCache(1);
        System.out.println(cache.deque);
        cache.addToCache(4);
        System.out.println(cache.deque);
        cache.addToCache(5);
        System.out.println(cache.deque);
        cache.addToCache(2);
        System.out.println(cache.deque);
        cache.addToCache(2);
        System.out.println(cache.deque);
        cache.addToCache(1);
        System.out.println("Final " + cache.deque);
    }

    void addToCache(Integer toAdd) {
        int size = deque.size();
        if (!set.contains(toAdd)) {
            if (size == cacheSize) {
                Integer lastElm = deque.removeLast();
                set.remove(lastElm);
            }
        } else {
            deque.remove(toAdd);
        }
        addData(toAdd);
    }

    private void addData(Integer toAdd) {
        deque.push(toAdd);
        set.add(toAdd);
    }
}
