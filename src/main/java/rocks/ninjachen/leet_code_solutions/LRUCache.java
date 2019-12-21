package rocks.ninjachen.leet_code_solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ninja on 3/9/16.
 */
class LRUCache {
    int capacity;
    int count;
    Node head;
    Node tail;
    Map<Integer, Node> cache = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node old = cache.get(key);
        if (old != null) {
            activity(old);
        }
        return old == null ? -1 : old.value;
    }

    public void put(int key, int value) {
        boolean contains = cache.containsKey(key);
        Node node;
        if (contains) {
            node = cache.get(key);
            node.value = value;
        } else {
            node = new Node(key, value);
            cache.put(key, node);
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            if (contains) {
                activity(node);
            } else {
                // node not exist, just append node to tail
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
        // check capacity
        if (!contains)
            count++;
        if (count > capacity) {
            // remove the oldest header
            cache.remove(head.key);
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    public void activity(Node node) {
        if (tail == node) {
            // already at the tail, do nothing
        } else if (node.prev == null) {
            // node is header
            head = node.next;
            node.next.prev = null;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        } else {
            // node in middle, move old node to tail
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public static class Node {
        public int key, value;
        public Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */