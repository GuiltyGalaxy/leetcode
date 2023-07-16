package top.L297;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tool.TreeNode;

class CodecTest {
    @Test
    public void case1() {
        Codec codec = new Codec();
        TreeNode before = TreeNode.createTree(1, 2, 3, null, null, 4, 5);
        TreeNode after = codec.deserialize(codec.serialize(before));
        Assertions.assertTrue(TreeNode.isEquals(before, after));
    }
}