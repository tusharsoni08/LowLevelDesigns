package org.lrucache;

import java.util.*;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;

    public Node() {}
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache<K, V> implements Cache<K, V> {
    Map<K, Node<K, V>> map;
    Node<K, V> head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();

        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void put(K key, V value) {
        if(!map.containsKey(key)) {
            if(this.capacity == map.size()) {
                Node<K, V> toBeRemove = tail.prev;
                map.remove(toBeRemove.key);
                removeExistingNode(toBeRemove);
            }
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            addNodeToFront(newNode);
        } else {
            Node<K, V> existingNode = map.get(key);
            existingNode.value = value;
            removeExistingNode(existingNode);
            addNodeToFront(existingNode);
        }
    }

    @Override
    public V get(K key) {
        if(!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        removeExistingNode(node);
        addNodeToFront(node);
        return node.value;
    }

    private void addNodeToFront(Node<K, V> node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeExistingNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}

/*

[H]   [T]
   [N]
K1=V1
K2=V2

[K2,K1]





 */
