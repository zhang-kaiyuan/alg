package com.kaiy.linked;

import com.kaiy.common.SamplesToGenerate;

/**
 * 中点 （快慢指针）
 */
public class FindLinkedMid {

    /**
     * 奇数为中间
     * 偶数时为后中节点
     * @param head
     * @return
     */
    private static Node mid1(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node quick = head;
        while(quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (quick == null) {
                return slow;
            }
        }
        return slow;
    }

    /**
     * 奇数为中间
     * 偶数时为前中节点
     * @param head
     * @return
     */
    private static Node mid2(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node quick = head;
        while(quick.next != null) {
            quick = quick.next.next;
            if (quick == null) {
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 奇数为中间前一个
     * 偶数时为前中节点的前一个
     * @param head
     * @return
     */
    private static Node mid3(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node quick = head;
        Node pre = null;
        while(quick.next != null) {

            quick = quick.next.next;
            if (quick == null) {
                return pre;
            }
            pre = slow;
            slow = slow.next;
        }
        return pre;
    }

    /**
     * 奇数为中间的后一个
     * 偶数时为后中节点的后一个
     * @param head
     * @return
     */
    private static Node mid4(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node quick = head;
        Node after = null;
        while(quick.next != null) {

            slow = slow.next;
            after = slow.next;
            quick = quick.next.next;
            if (quick == null) {
                return after;
            }
        }
        return after;
    }

    public static void main(String[] args) {
        Node head = SamplesToGenerate.generateRandomLinked();
        Node node = head;
        int count = 0;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
            count++;
        }
        System.out.println("count: " + count);
        Node node1 = mid4(head);
        System.out.println(node1 == null ? null : node1.value);

    }

}
