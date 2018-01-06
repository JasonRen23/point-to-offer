package chapter2;

import java.util.ArrayList;

import dataStructure.ListNode;

public class PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> valList = new ArrayList<>();
        if(listNode == null){
            return valList;
        }

        while(listNode != null){
            valList.add(listNode.val);
            listNode = listNode.next;
        }

        return reverseArray(valList);

    }

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> list){
        int len = list.size();
        for(int i = 0; i < len/2; ++i){
            int tmp = list.get(i);
            list.set(i, list.get(len-1-i));
            list.set(len-1-i, tmp);
        }
        return list;
    }
    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode, ArrayList<Integer> list) {
        if(listNode == null){
            return list;
        }
        if(listNode != null){
            if(listNode.next != null){
                printListFromTailToHead_2(listNode.next, list);
            }
            list.add(listNode.val);
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node_one = new ListNode(1);
        ListNode node_two = new ListNode(2);
        ListNode node_three = new ListNode(3);
        ListNode node_four = new ListNode(4);
        head.setNext(node_one);
        node_one.setNext(node_two);
        node_two.setNext(node_three);
        node_three.setNext(node_four);
        node_four.setNext(null);
        System.out.println("Method One: " + printListFromTailToHead_1(head));
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Method Two: " + printListFromTailToHead_2(head, list));


    }
}
