package com.kaiy.tree;

import com.kaiy.common.SamplesToGenerate;
import com.kaiy.common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最宽层的层数
 */
public class Widest {

    public static int widest(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode curEnd = node;
        TreeNode nextEnd = null;
        int maxWid = 1;
        int curWid = 0;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                curWid += 1;
                nextEnd = cur.left;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                curWid += 1;
                nextEnd = cur.right;
                queue.add(cur.right);
            }
            if (cur == curEnd) {
                maxWid = Math.max(maxWid, curWid);
                curWid = 0;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return maxWid;
    }

    public static void main(String[] args) {
        TreeNode treeNode = SamplesToGenerate.generateRandomTree();
        TreeUtil.printTree(treeNode);
        System.out.println("===========");
        System.out.println(widest(treeNode));
    }
}
