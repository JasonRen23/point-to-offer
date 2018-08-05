package chapter5;

import dataStructure.ListNode;

/**
 * @author : JasonRen
 * @date : 2018-08-06 上午1:12
 * @email : zhicheng_ren@163.com
 */
public class FindFirstCommonNode {
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;

        ListNode longerHead = head1;
        ListNode shorterHead = head2;

        int len1 = getListLen(head1);
        int len2 = getListLen(head2);

        int diff = len1 - len2;

        if (diff < 0) {
            longerHead = head2;
            shorterHead = head1;
            diff = -diff;
        }

        for (int i = 0; i < diff; i++) {
            longerHead = longerHead.next;
        }

        while (longerHead != null && shorterHead != null && longerHead != shorterHead) {
            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }

        return longerHead;
    }

    public static int getListLen(ListNode head) {
        if (head == null)
            return 0;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
        n4.next = n5;
        n5.next = n6;
        System.out.println(findFirstCommonNode(n1, n4)); // 6
    }

    private static void test2() {
        // 没有公共结点
        // 1 - 2 - 3 - 4
        //
        // 5 - 6 - 7
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n5.next = n6;
        n6.next = n7;
        System.out.println(findFirstCommonNode(n1, n5)); // null
    }
    private static void test3() {
        // 公共结点是最后一个结点
        // 1 - 2 - 3 - 4 \
        //                7
        //         5 - 6 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n7;
        n5.next = n6;
        n6.next = n7;
        System.out.println(findFirstCommonNode(n1, n5)); // 7
    }
}
