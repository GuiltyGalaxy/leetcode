package top.L146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //map是用來記錄key,val
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    //DLinkedNode是用來記錄目前常用排序情況
    //head, tail都是假指標，用來指向目前的head與tail
    private DLinkedNode head, tail;
    private int currSize;
    private int maxSize;

    public LRUCache(int maxSize) {
        this.currSize = 0;
        this.maxSize = maxSize;

        head = new DLinkedNode();
        head.prev = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(DLinkedNode node) {
        //新增的節點會在最前面
        //設定node
        node.prev = head;
        node.next = head.next;
        //設定head
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        //紀錄前後指標
        DLinkedNode pre = node.prev;
        DLinkedNode post = node.next;
        //將指標跳過該node達到移除功能
        pre.next = post;
        post.prev = pre;
    }

    private void moveToHead(DLinkedNode node) {
        //先移除他原本在的位子
        removeNode(node);
        //新增到head
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode tmp = tail.prev;
        removeNode(tmp);
        return tmp;
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

            currSize++;
            //超過容量則移除最後一個節點
            if (currSize > maxSize) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                currSize--;
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
        DLinkedNode prev;
        DLinkedNode next;
    }

}