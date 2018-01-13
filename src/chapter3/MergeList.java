package chapter3;

import dataStructure.ListNode;

/**
 * Created by JasonRen on 2018/1/13
 */

public class MergeList {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        
        ListNode mergeHead;

        if(list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = Merge(list1.next, list2);
        }else{
            mergeHead = list2;
            mergeHead.next = Merge(list1, list2.next);
        }

        
        return mergeHead;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        ListNode list1Head = new ListNode(1);
        list1Head.next = new ListNode(2);
        list1Head.next.next = new ListNode(3);

        ListNode list2Head = new ListNode(1);
        list2Head.next = new ListNode(2);
        list2Head.next.next = new ListNode(3);

        ListNode mergeListHead = Merge(list1Head, list2Head);

        printList(mergeListHead);

    }

}
