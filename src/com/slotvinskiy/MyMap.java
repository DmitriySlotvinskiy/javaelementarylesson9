package com.slotvinskiy;

public interface MyMap<K,V> {

    interface Node {

        public String toString();

    }

    void clear();

    boolean containsKey(K key);

    public V get(K key);

    V put(K key, V value);

    int size();

    public String toString();
}

