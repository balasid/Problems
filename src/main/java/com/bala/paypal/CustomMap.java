package com.bala.paypal;

import java.util.ArrayList;
import java.util.List;

interface IMap<E, D> {
    D getData(E elm);

    D putData(E key, D value);
}

public class CustomMap<E, D> implements IMap<E, D> {
    List<Entry<E, D>> container = new ArrayList<>();

    @Override
    public D getData(E elm) {
        return null;
    }

    private int getHash(E key) {
        return (Integer) key % 4;
    }

    @Override
    public D putData(E key, D value) {
        int hash = getHash(key);

        return null;
    }

    static class Entry<E, D> {
        E key;
        D value;
        Entry<E, D> next;

        public Entry(E key, D value) {
            this.key = key;
            this.value = value;
        }
    }
}
