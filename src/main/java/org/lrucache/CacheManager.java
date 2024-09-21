package org.lrucache;

public class CacheManager<K, V> {
    Cache<K, V> cache;

    public CacheManager(Cache<K, V> cache) {
        this.cache = cache;
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }
}
