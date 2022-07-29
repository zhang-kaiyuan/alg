package com.kaiy.tree;

import com.kaiy.common.SamplesToGenerate;
import com.kaiy.common.TreeUtil;
import com.kaiy.linked.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的序列化/反序列化
 */
public class TreeSerialize {

    public static String serialize(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        builder.append(node.value);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll.left != null) {
                builder.append(",").append(poll.left.value);
                queue.add(poll.left);
            } else {
                builder.append(",#");
            }
            if (poll.right != null) {
                builder.append(",").append(poll.right.value);
                queue.add(poll.right);
            } else {
                builder.append(",#");
            }

        }
        return builder.toString();
    }

    public static TreeNode deserialization(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        String[] split = s.split(",");
        String headStr = split[0];
        TreeNode head = new TreeNode(Integer.valueOf(headStr));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            String leftValue = split[index++];
            if (!"#".equals(leftValue)) {
                cur.left = new TreeNode(Integer.valueOf(leftValue));
                queue.add(cur.left);
            }

            String rightValue = split[index++];
            if (!"#".equals(rightValue)) {
                cur.right = new TreeNode(Integer.valueOf(rightValue));
                queue.add(cur.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode treeNode = SamplesToGenerate.generateRandomTree();
        String serialize = serialize(treeNode);
        System.out.println(serialize);
        System.out.println("===========");
        TreeNode deserialization = deserialization(serialize);
        TreeUtil.printTree(deserialization);
    }
}