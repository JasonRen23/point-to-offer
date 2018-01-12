package chapter3;

import dataStructure.ListNode;

/**
 * Created by JasonRen on 2018/1/12
 */
public class FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k <= 0){
            return null;
        }

        ListNode pAhead = head;
        ListNode pBehind = head;

        for(int i = 0; i < k - 1; ++i){
            if(pAhead.next != null){
                pAhead = pAhead.next;
            }else {
                return null;
            }
        }

        while(pAhead.next != null){
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }

    public static void main(String[] args) throws Exception{
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println("The kth node to tail is " + FindKthToTail(null,0));
        System.out.println("The kth node to tail is " + FindKthToTail(head,0));
        System.out.println("The kth node to tail is " + FindKthToTail(head,9));
        System.out.println("The kth node to tail is " + FindKthToTail(head,1).val);

    }
}
