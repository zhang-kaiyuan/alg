package com.kaiy.tree.dp;

import com.kaiy.tree.AbstractTree;
import com.kaiy.tree.NTreeNode;

/**
 * 最大快乐值
 * 1.一颗多叉树 每个节点都有value
 * 2.统计一个节点后不能再统计它的父节点和子节点
 * 3.统计一棵树能获得的最大value
 */
public class MaxHappy extends AbstractTree {

    public int maxHappy(NTreeNode head) {
        Info info = process(head);
        return Math.max(info.inMaxHappy, info.outMaxHappy);
    }

    public static class Info {
        int inMaxHappy;
        int outMaxHappy;

        public Info(int inMaxHappy, int outMaxHappy) {
            this.inMaxHappy = inMaxHappy;
            this.outMaxHappy = outMaxHappy;
        }
    }

    public Info process(NTreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        int inMaxHappy = node.value;
        int outMaxHappy = 0;
        for (NTreeNode item : node.children) {
            Info infoTemp = process(item);
            inMaxHappy += infoTemp.outMaxHappy;
            outMaxHappy += Math.max(infoTemp.inMaxHappy, infoTemp.outMaxHappy);
        }

        return new Info(inMaxHappy, outMaxHappy);
    }

    public static void main(String[] args) {

    }
}
