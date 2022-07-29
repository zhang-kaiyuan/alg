package com.kaiy.linked;

/**
 * 判断链表是否有环
 */
public class Intersect {

    private static Node hasRing(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while(fast != slow) {
            if (fast == slow) {
                return fast;
            }
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

}
