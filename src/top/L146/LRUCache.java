package top.L146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //map是用來記錄key,val
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    //DLinkedNode是用來記錄目前常用排序情況
    //head, tail都是假指標，用來指向目前的head與tail
    private DLinkedNode head, tail;
    private int count;
    private int capacity;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    /**
     * 新增的節點會加在目前head的下一個
     */
    private void addNode(DLinkedNode node) {
        //設定node
        node.pre = head;
        node.post = head.post;
        //設定head
        head.post.pre = node;
        head.post = node;
    }

    /**
     * 移除指定node
     */
    private void removeNode(DLinkedNode node) {
        //紀錄前後指標
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        //將指標跳過該node達到移除功能
        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        //先移除他原本在的位子
        this.removeNode(node);
        //新增到head
        this.addNode(node);
    }

    /**
     * 移除最後一個節點
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        //將該key移到頂點
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            //生成新節點
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            count++;
            //超過容量則移除最後一個節點
            if (count > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            //更新數值並移到頂點
            node.value = value;
            moveToHead(node);
        }
    }

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

}