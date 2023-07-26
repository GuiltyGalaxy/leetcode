package top.L146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //map是用來記錄key,val
    private Map<Integer, Node> cache;
    //DLinkedNode是用來記錄目前常用排序情況
    //head, tail都是假指標，用來指向目前的head與tail
    private Node head;
    private Node tail;
    private int currSize;
    private int maxSize;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        currSize = 0;
        maxSize = capacity;

        head = new Node();
        tail = new Node();

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    private void addNode(Node node) {
        //新增的節點會在最前面
        //設定node
        node.prev = head;
        node.next = head.next;
        //設定head
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        //紀錄前後指標
        Node prev = node.prev;
        Node next = node.next;
        //將指標跳過該node達到移除功能
        prev.next = next;
        next.prev = prev;
    }

    private void moveNodeToHead(Node node) {
        //先移除他原本在的位子
        removeNode(node);
        //新增到head
        addNode(node);
    }

    private Node popTail() {
        Node tmp = tail.prev;
        removeNode(tmp);
        return tmp;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //將該key移到頂點
        moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            //生成新節點
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            currSize++;
            //超過容量則移除最後一個節點
            if (currSize > maxSize) {
                Node tmp = tail.prev;
                removeNode(tmp);
                cache.remove(tmp.key);
                currSize--;
            }
        } else {
            //更新數值並移到頂點
            node.value = value;
            moveNodeToHead(node);
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

}