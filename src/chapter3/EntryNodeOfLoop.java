package chapter3;

import dataStructure.ListNode;

/**
 * @author : JasonRen
 * @date : 2018-07-27 上午1:34
 * @email : zhicheng_ren@163.com
 */
public class EntryNodeOfLoop {
    public static ListNode meetingNode(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        //链表中无环
        if(fast == null || fast.next == null) {
            return null;
        }

        //fast重新指向第一个结点
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }
    // 1->2->3->4->5->6
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(meetingNode(n1));
    }
    // 1->2->3->4->5->6
    //       ^        |
    //       |        |
    //       +--------+
    private static void test02() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        System.out.println(meetingNode(n1));
    }
    // 1->2->3->4->5->6 <-+
    //                |   |
    //                +---+
    private static void test03() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n6;
        System.out.println(meetingNode(n1));
    }
}

