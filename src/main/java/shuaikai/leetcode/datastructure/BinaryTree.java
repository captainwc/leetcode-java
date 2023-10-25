package shuaikai.leetcode.datastructure;

import java.util.Stack;

public abstract class BinaryTree {

    public TreeNode root;

    public int size;

    public BinaryTree() {
        this.root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String inorderTravsal() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Stack<TreeNode> st = new Stack<>();
        TreeNode pNode = root;

        while (!st.empty() || pNode != null) {
            if (pNode != null) {
                st.push(pNode);
                pNode = pNode.leftChild;
            } else {
                pNode = st.pop();
                builder.append(String.valueOf(pNode.val) + ",");
                pNode = pNode.rightChild;
            }
        }
        return builder.deleteCharAt(builder.length() - 1).append("]").toString();
    }
}