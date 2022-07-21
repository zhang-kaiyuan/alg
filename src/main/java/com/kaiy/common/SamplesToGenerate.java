package com.kaiy.common;

import com.kaiy.linked.Node;

public class SamplesToGenerate {

    private SamplesToGenerate() {
    }

    private static final int SAMPLE_SIZE = 10;
    private static final int SAMPLE_RANGE = 1000;

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

    public static void main(String[] args) {
        Node node = generateRandomLinked();
        int count = 0;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
            count++;
        }
        System.out.println("count: " + count);
    }

}
