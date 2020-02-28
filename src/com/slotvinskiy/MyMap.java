package com.slotvinskiy;

public interface MyMap {

    interface Node {

        public String toString();

    }

    void clear();

    boolean containsKey(String key);

    public String get(String key);

    String put(String key, String value);

    int size();

    public String toString();
}

