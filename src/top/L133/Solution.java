package top.L133;

import java.util.HashMap;

class Solution {

    private final HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node k : node.neighbors) {
            if (map.containsKey(k)) {
                // map中已有過相同的node則取出加入至neighbors
                newNode.neighbors.add(map.get(k));
            } else {
                // 沒對應的情況則以該node繼續往下clone，並將結果回寫至neighbors
                newNode.neighbors.add(cloneGraph(k));
            }
        }

        return newNode;
    }
}