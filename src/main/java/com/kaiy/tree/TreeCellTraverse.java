package com.kaiy.tree;

import com.kaiy.common.SamplesToGenerate;
import com.kaiy.common.TreeUtil;

import java.util.*;

/**
 * 按层遍历
 */
public class TreeCellTraverse {

    public static List<Integer> traverse(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        // 注意这边队列用的方法 不要用错了
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode cur;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            result.add(cur.value);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = SamplesToGenerate.generateRandomTree();
        TreeUtil.printTree(treeNode);
        System.out.println("===============");
        List<Integer> traverse = traverse(treeNode);
        System.out.println(traverse);
    }
}
