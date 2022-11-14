package top.L138;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 這題目麻煩的點在於random在copy的時候也要採用新的
     * 所以沒辦法直接用
     * node.random = head.random
     * 要先建立所有node的map再去給random指標
     * O(N)
     */
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node,Node> map = new HashMap<>();

        //複製原node list
        Node node = head;
        while (node!=null){
            map.put(node,new Node(node.val));
            node = node.next;
        }

        //給新的node值
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}