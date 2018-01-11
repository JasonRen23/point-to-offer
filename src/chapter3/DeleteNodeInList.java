package chapter3;

/**
 * Created by JasonRen on 2018/1/11
 */
import dataStructure.ListNode;

public class DeleteNodeInList {
    public static ListNode deleteNode(ListNode head, ListNode deleteNode){
        if(head == null || deleteNode == null){
//            throw new RuntimeException("Invalid input!");
            return head;

        }
        if(head == deleteNode){
            head = head.next;
            return head;
        }
        if(deleteNode.next != null){
            ListNode pNext = deleteNode.next;
            deleteNode.val = pNext.val;
            deleteNode.next = pNext.next;
            pNext = null;
        } else if(head == deleteNode){
            head = null;
//            deleteNode = null;
        }else{
            ListNode pNode = head;
            while(pNode.next != deleteNode && pNode.next !=null){
                pNode = pNode.next;
            }

            pNode.next = null;
//            deleteNode = null;
        }


        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) throws Exception{
        ListNode head = new ListNode(1);
        ListNode middle = head.next = new ListNode(2);
        ListNode tail = head.next.next = new ListNode(3);

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);



        head = deleteNode(head, head); // 删除头结点
        printList(head);

        ListNode node = new ListNode(12);
        head = deleteNode(head, node); // 删除的结点不在链表中
        printList(head);

        head = deleteNode(head, tail); // 删除尾结点
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);


    }
}
