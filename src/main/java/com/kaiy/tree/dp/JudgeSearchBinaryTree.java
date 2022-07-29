package com.kaiy.tree.dp;

import com.kaiy.tree.AbstractTree;
import com.kaiy.tree.TreeNode;

import java.util.ArrayList;

/**
 * 判断是否是搜索二叉树
 */
public class JudgeSearchBinaryTree extends AbstractTree {

    public static boolean isSearch(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isSearch;
    }

    public static class Info {
        boolean isSearch;
        int maxValue;
        int minValue;

        public Info(boolean isSearch, int maxValue, int minValue) {
            this.isSearch = isSearch;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }

    private static Info process(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int leftMaxValue = leftInfo == null ? node.value : Math.max(node.value, leftInfo.maxValue);
        int rightMaxValue = rightInfo == null ? node.value : Math.max(node.value, rightInfo.maxValue);
        int maxValue = Math.max(leftMaxValue, rightMaxValue);

        int leftMinValue = leftInfo == null ? node.value : Math.min(node.value, leftInfo.minValue);
        int rightMinValue = rightInfo == null ? node.value : Math.min(node.value, rightInfo.minValue);
        int minValue = Math.min(leftMinValue, rightMinValue);

        boolean isSearch = true;
        if ((leftInfo != null && !leftInfo.isSearch) || (rightInfo != null && !rightInfo.isSearch)) {
            isSearch = false;
        } else if (leftInfo != null && leftInfo.maxValue >= node.value) {
            isSearch = false;
        } else if (rightInfo != null && rightInfo.minValue <= node.value) {
            isSearch = false;
        }

        return new Info(isSearch, maxValue, minValue);
    }

    public static boolean isSearch1(TreeNode head) {
        if (head == null) {
            return true;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static void main(String[] args) {
        treeLogarithmic(JudgeSearchBinaryTree::isSearch, JudgeSearchBinaryTree::isSearch1);
    }

}
