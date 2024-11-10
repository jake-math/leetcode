package solutions.grind75.week7;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode post;
    }

    private Map<Integer, ListNode> 
        cache = new HashMap<>();

    ListNode head;
    ListNode tail;
    
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new ListNode();
        tail = new ListNode();

        head.pre = null;
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        ListNode node = cache.get(key);

        if (node == null) {
            return -1;
        }

        this.moveToHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = cache.get(key);

        if (node == null) {
            ListNode toAdd = new ListNode();
            toAdd.val = value;
            toAdd.key = key;

            this.cache.put(key, toAdd);
            this.addNode(toAdd);

            size++;

            if (size > capacity) {
                ListNode tail = this.popTail();
                this.cache.remove(tail.key);
                size--;
            }
        } else {
            node.val = value;
            this.moveToHead(node);
        }
    }

    private void addNode(ListNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode (ListNode node) {
        ListNode pre = node.pre;
        ListNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(ListNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private ListNode popTail() {
        ListNode result = tail.pre;
        this.removeNode(result);
        return result;
    }
}
