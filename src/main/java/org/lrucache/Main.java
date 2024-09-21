package org.lrucache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, Integer> lruCache = new LRUCache<>(2);
        CacheManager<Integer, Integer> cacheManager = new CacheManager<>(lruCache);

        cacheManager.put(1, 1);
        cacheManager.put(2, 2);
        System.out.println(cacheManager.get(1));
        cacheManager.put(3, 3);
        System.out.println(cacheManager.get(2));
        cacheManager.put(4, 4);
        System.out.println(cacheManager.get(1));
        System.out.println(cacheManager.get(3));
    }
}

// 4,3,
