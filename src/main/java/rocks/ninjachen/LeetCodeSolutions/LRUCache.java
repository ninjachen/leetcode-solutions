package rocks.ninjachen.LeetCodeSolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ninja on 3/9/16.
 */
public class LRUCache {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(1);
//        cache.set(2,1);
//        cache.get(1);
//        cache = new LRUCache(2);
//        cache.set(2,1);
//        cache.set(2,2);
//        cache.set(1,1);
//        cache.set(4,1);
        testCase1();

    }

    private static void testCase1() {
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(1,1);
        cache.get(2);
        cache.set(4,1);
        cache.get(1);
        cache.get(2);
    }
    private static void testCase2() {

    }
    private static void testCase3() {

    }


    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int used = 0;
    // first node is the least recent use, tail node is the last use one;
    Node head;
    Node tail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            System.out.println(String.format("get(%d) = %d", key, -1));
            return -1;
        } else {
            System.out.println(String.format("get(%d) = %d", key, node.value));
            // refresh the recent usage
            if (head != null) {
                // if current hit key, and current node is not last
                activity(node);
            } else {
                head = node;
                tail = node;
            }
            return node.value;
        }
    }

    public void set(int key, int value) {
        Node last = new Node(key, value);
        Node old = cache.put(key, last);
        if(head == null){
            head = last;
            tail = last;
            used++;
        }else if (old == null) {
            // key not exist
            tail.next = last;
            last.pre = tail;
            last.next = null;
            tail = last;
            if(used == capacity){
                //remove least when cache full
                cache.remove(head.key);
                head = head.next;
                head.pre = null;
            }else {
                used++;
            }
        } else {
            // key exist, refresh recent usage
            activity(old);
        }
    }

    /**
     * move node to last
     * @param node
     */
    public void activity(Node node){
        // if node is tail
        if(node.next == null) return;
        //remove old node
        if(node.pre == null){
            head = node.next;
        }else {
            node.pre.next = node.next;
        }
        node.next.pre = node.pre;
        // add node to the last position
        tail.next = node;
        node.next = null;
        node.pre = tail;

        tail = node;
    }
}