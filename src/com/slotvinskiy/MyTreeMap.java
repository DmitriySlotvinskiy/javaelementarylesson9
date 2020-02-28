package com.slotvinskiy;

import java.util.Comparator;

public class MyTreeMap<K,V> implements MyMap<K,V> {

    private final Comparator<? super K> comparator;

    private int size = 0;
    private Node root = null;

    public MyTreeMap() {
        comparator = null;
    }

    public MyTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    private class Node {

        private K key;
        private V val;
        private Node left;
        private Node right;
        private Node parent;

        public Node(K key, V value) {
            this.key = key;
            val = value;
        }

        @Override
        public String toString() {
            return key + "=" + val;
        }

    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    public V get(K key) {
        return getNode(key) != null ? getNode(key).val : null;
    }

    @Override
    public V put(K putKey, V putValue) {
        if (isEmpty()) {                            // если дерево пустое
            root = new Node(putKey, putValue);
            size++;
            return null;
        }
        Node current = root;
        while (true) {
            if (isEquals(putKey, current.key)) {        // если вставляемый ключ уже есть в дереве
                V temp = current.val;
                current.val = putValue;
                return temp;
            } else if (compare(putKey, current.key) > 0) {                //putKey > currentKey
                if (current.right != null) {
                    current = current.right;
                    continue;
                } else {
                    current.right = new Node(putKey, putValue);
                    current.right.parent = current;
                    size++;
                    return null;
                }
            } else {                                                //putKey < currentKey
                if (current.left != null) {
                    current = current.left;
                    continue;
                } else {
                    current.left = new Node(putKey, putValue);
                    current.left.parent = current;
                    size++;
                    return null;
                }
            }
        }
    }

    private boolean isEquals(K putKey, K key) {
        return putKey.equals(key);
    }

    private Node getNode(K key) {
        if (isEmpty()) {
            return null;
        }
        Node current = root;
        while (true) {
            if (isEquals(key, current.key)) {                   //найдено совпадение
                return current;
            } else if (compare(key, current.key) > 0) {        //key > current.key
                if (current.right != null) {
                    current = current.right;
                    continue;
                } else {
                    return null;
                }
            } else {                                            //key < current.key
                if (current.left != null) {
                    current = current.left;
                    continue;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        printNode(root, sb);
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    private void printNode(Node node, StringBuilder sb) {
        if (node.left != null) {
            printNode(node.left, sb);
        }
        sb.append(node).append(", ");
        if (node.right != null) {
            printNode(node.right, sb);
        }
    }

    final int compare(Object k1, Object k2) {
        return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
                : comparator.compare((K)k1, (K)k2);
    }
}

