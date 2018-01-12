package chapter3;


import dataStructure.ListNode;

/**
 * Created by JasonRen on 2018/1/12
 */
public class ReverseList {
    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = null; //Store the position of the new head, also the tail of the old.

        ListNode pPrev =null;
        ListNode pNode = head;
        ListNode pNext;

        while(pNode != null){
           pNext = pNode.next;
           if(pNext == null){
               newHead = pNode;
           }

            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;


        }

        return newHead;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.print("Before the reverse, the list is ");
        printList(head);
        head = ReverseList(head);
        System.out.print("After the reverse, the list is ");
        printList(head);

    }

}
