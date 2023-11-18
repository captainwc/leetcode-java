package shuaikai.leetcode.datastructure;

import org.junit.Assert;
import org.junit.Test;
import shuaikai.datastructure.tree.BST;
import shuaikai.datastructure.tree.TreeNode;

public class TreeTest {
    @Test
    public void treeNodePrintTest() {
        TreeNode lvl31 = new TreeNode(10);
        TreeNode lvl32 = new TreeNode(20);
        TreeNode lvl21 = new TreeNode(30, lvl31, lvl32);
        TreeNode lvl11 = new TreeNode(40, null, lvl21);

        Assert.assertEquals("llv1.string()", "(null,40,((null,10,null),30,(null,20,null)))", lvl11.toString());
    }

    @Test
    public void bstTest() {
        BST bst = new BST();
        bst.insertS(4).insertS(5).insertS(1).insertS(4).insertS(3).insertS(2);
        Assert.assertEquals("[1,2,3,4,5]", bst.inorderTravsal());

        bst.removeS(4).removeS(1).removeS(4);
        Assert.assertEquals("[2,3,5]", bst.inorderTravsal());
    }
}
