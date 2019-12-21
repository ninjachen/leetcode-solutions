package rocks.ninjachen.leet_code_solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void testCase1() {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        assertEquals(1, cache.get(2));
        cache.put(4,1);
        assertEquals(-1, cache.get(1));
        assertEquals(1, cache.get(2));
    }

    @Test
    public void testCase2() {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }
}