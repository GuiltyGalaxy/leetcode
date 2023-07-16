package top.L297;


import tool.TreeNode;

public class Codec {

    private int offset;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // 將樹serialize成1,2,3,4,5
    private void serialize(TreeNode root, StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(',');
        }
        if (root != null) {
            sb.append(root.val);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        offset = 0;
        return doDeserialize(data);
    }

    private TreeNode doDeserialize(String data) {
        int nextComma = data.indexOf(',', offset);
        if (nextComma < 0) {
            nextComma = data.length();
        }
        String valStr = data.substring(offset, nextComma);
        offset = nextComma + 1;
        if (valStr.isEmpty()) {
            return null;
        }
        int val = Integer.parseInt(valStr);
        TreeNode n = new TreeNode(val);
        n.left = doDeserialize(data);
        n.right = doDeserialize(data);
        return n;
    }
}