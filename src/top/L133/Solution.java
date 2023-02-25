package top.L133;

import java.util.Arrays;

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        //有限制最多100個node
        //visited用來記錄node是否已被找過
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        dfs(node, copy, visited);
        return copy;
    }

    public void dfs(Node node, Node copy, Node[] visited) {
        visited[copy.val] = copy;
        for (Node n : node.neighbors) {
            if (visited[n.val] == null) {
                //新node
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                //繼續找
                dfs(n, newNode, visited);
            } else {
                //已被找過的node就單純加到neighbors即可
                copy.neighbors.add(visited[n.val]);
            }
        }
    }
}