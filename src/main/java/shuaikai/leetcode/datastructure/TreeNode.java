package shuaikai.leetcode.datastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum COLOR {
    RED,
    BLACK
}

public class TreeNode {
    public int val;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode parent;
    public COLOR color;

    public static final Logger LOGGER = LoggerFactory.getLogger(TreeNode.class);

    public TreeNode(int val) {
        this(val, null, null, null, COLOR.RED);
    }

    public TreeNode(int val, TreeNode parent) {
        this(val, null, null, parent, COLOR.RED);
    }

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
        this(val, leftChild, rightChild, null, COLOR.RED);
    }

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild, TreeNode parent, COLOR color) {
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
        this.color = color;
    }

    public boolean isLeftChild() {
        return this.equals(this.parent.leftChild);
    }

    public boolean isLeafNode() {
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isRed() {
        return this.color == COLOR.RED;
    }

    public void removeMe() {
        if (!isRoot()) {
            if (isLeftChild()) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else {
            LOGGER.trace("Maybe you shouldn't remove a root.");
        }
    }

    public void replaceMe(TreeNode node) {
        if (isRoot()) {
            node.parent = null;
            LOGGER.trace("Why you replace a root rather than create a new Tree?");
        } else {
            node.parent = this.parent;
            if (isLeftChild()) {
                this.parent.leftChild = node;
            } else {
                this.parent.rightChild = node;
            }
        }
    }

    // only change the content, won't change the position.
    public void changeMe(TreeNode node) {
        this.val = node.val;
        this.color = node.color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        if (leftChild != null)
            builder.append(leftChild.toString());
        else
            builder.append("null");
        builder.append(",");
        builder.append(String.valueOf(val));
        builder.append(",");
        if (rightChild != null)
            builder.append(rightChild.toString());
        else
            builder.append("null");
        builder.append(")");
        return builder.toString();
    }
}
