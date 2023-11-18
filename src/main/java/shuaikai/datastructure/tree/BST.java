package shuaikai.datastructure.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BST extends BinaryTree {
    public static final Logger LOGGER = LoggerFactory.getLogger(BST.class);

    public BST() {
        super();
    }

    public TreeNode find(int val) {
        TreeNode p = root;
        while (p != null) {
            if (p.val > val) {
                p = p.leftChild;
            } else if (p.val < val) {
                p = p.rightChild;
            } else {
                return p;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        if (isEmpty()) {
            root = new TreeNode(val);
            size++;
            return true;
        }
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null) {
            if (p.val == val) {
                return false;
            } else if (p.val > val) {
                pre = p;
                p = p.leftChild;
            } else {
                pre = p;
                p = p.rightChild;
            }
        }
        TreeNode node = new TreeNode(val, pre);
        if (pre.val > val) {
            pre.leftChild = node;
        } else {
            pre.rightChild = node;
        }
        size++;
        return true;
    }

    // streamy operation
    public BST insertS(int val) {
        if (!insert(val)) {
            LOGGER.trace("BST InsertS error: Value {} exits!", val);
        }
        return this;
    }

    // private TreeNode firstChild(TreeNode node) {
    //     TreeNode pNode = node;
    //     while (pNode.leftChild != null) {
    //         pNode = pNode.leftChild;
    //     }
    //     return pNode;
    // }

    private TreeNode lastChild(TreeNode node) {
        TreeNode pNode = node;
        while (pNode.rightChild != null) {
            pNode = pNode.rightChild;
        }
        return pNode;
    }

    // private TreeNode successor(TreeNode node) {
    //     return firstChild(node.rightChild);
    // }

    private TreeNode predecessor(TreeNode node) {
        return lastChild(node.leftChild);
    }

    public boolean remove(int val) {
        TreeNode pos = find(val);
        if (pos == null) {
            return false;
        }
        remove(pos);
        return true;
    }

    public BST removeS(int val) {
        if (!remove(val)) {
            LOGGER.trace("BST removeS error: Value {} doesn't exits!", val);
        }
        return this;
    }

    private void remove(TreeNode pos) {
        // 1. leafNode: remove directly
        // 2. one child: replace parent using the only child
        // 3. double child: replace parent with the predecessor or successor, then
        // remove p/s
        if (pos.isLeafNode()) {
            pos.removeMe();
        } else if (pos.leftChild == null) {
            pos.replaceMe(pos.rightChild);
        } else if (pos.rightChild == null) {
            pos.replaceMe(pos.leftChild);
        } else {
            TreeNode prev = predecessor(pos);
            pos.changeMe(prev);
            remove(prev);
        }
    }
}
