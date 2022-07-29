package com.kaiy.tree.dp;

import com.kaiy.tree.AbstractTree;
import com.kaiy.tree.TreeNode;

/**
 * 判断是否是平衡二叉树
 */
public class JudgeBalancedBinaryTree extends AbstractTree {


    public static boolean isBalance(TreeNode head) {
        return process(head).balance;
    }

    public static class Info {
        boolean balance;
        int height;

        public Info(boolean balance, int height) {
            this.balance = balance;
            this.height = height;
        }
    }

    private static Info process(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean balance = leftInfo.balance && rightInfo.balance && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(balance, height);
    }


    public static boolean isBalance1(TreeNode head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(TreeNode head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public static void main(String[] args) {
        treeLogarithmic(JudgeBalancedBinaryTree::isBalance, JudgeBalancedBinaryTree::isBalance1);
    }

}
