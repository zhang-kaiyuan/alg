package com.kaiy.common;

import com.kaiy.linked.Node;
import com.kaiy.tree.TreeNode;

public class SamplesToGenerate {

    private SamplesToGenerate() {
    }

    private static final int SAMPLE_SIZE = 10;
    private static final int SAMPLE_RANGE = 1000;
    private static final int MAX_LEVEL = 7;


    public static int[] generateRandomArray(boolean negative) {
        int size = IntUtil.randomInt(SAMPLE_SIZE);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = negative ? IntUtil.randomIntContainsNegative(SAMPLE_RANGE) :
                    IntUtil.randomInt(SAMPLE_RANGE);
        }
        return array;
    }

    public static Node generateRandomLinked() {
        Node head = new Node(IntUtil.randomIntContainsNegative(SAMPLE_RANGE));
        int size = IntUtil.randomInt(SAMPLE_SIZE);
        Node temp = head;
        for (int i = 0; i < size; i++) {
            temp.next = new Node(IntUtil.randomIntContainsNegative(SAMPLE_RANGE));
            temp = temp.next;
        }
        return head;
    }

    public static TreeNode generateRandomTree() {
        return generateTree(1, MAX_LEVEL, SAMPLE_RANGE);
    }

    private static TreeNode generateTree(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || IntUtil.halfPoint()) {
            return null;
        }
        TreeNode left = generateTree(level + 1, maxLevel, maxValue);
        TreeNode right = generateTree(level + 1, maxLevel, maxValue);
        return new TreeNode(IntUtil.randomIntContainsNegative(maxValue), left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = generateRandomTree();
        TreeUtil.printTree(treeNode);
    }

}
