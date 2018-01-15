package chapter4;

/**
 * Created by JasonRen on 2018/1/15
 */

class  RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label){
        this.label = label;
    }
}

public class RandomListNodeClone{
    public static RandomListNode randomListNodeClone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }
    public static void CloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }
    public static void ConnectRandomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = pNode.next;
            if(pNode.random != null){
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }
    public static RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;

        if(pNode != null){
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while(pNode != null){
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

    public static void printList(RandomListNode head){
        while(head != null){
            System.out.print(head.label + "->");
            head= head.next;
        }
        System.out.println("null");
    }

    public static boolean isSame(RandomListNode head1, RandomListNode head2){
        while(head1 !=null && head2 != null){
            if(head1 == head2){
                head1 = head1.next;
                head2 = head2.next;
            }else{
                return false;
            }
        }
        return head1 == null && head2 == null;
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------

        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next;
        head.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;

        RandomListNode temp = head;
        printList(head);
        RandomListNode newHead = randomListNodeClone(head);
        printList(head);
        printList(newHead);
        System.out.println(isSame(temp, head));
        System.out.println(isSame(head, newHead));
        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        RandomListNode head2 = new RandomListNode(1);
        head2.next = new RandomListNode(2);
        head2.next.next = new RandomListNode(3);
        head2.next.next.next = new RandomListNode(4);
        head2.next.next.next.next = new RandomListNode(5);
        head2.next.random = head2.next.next.next.next;
        head2.next.next.next.random = head2.next;
        head.next.next.random = head.next.next;

        System.out.println();
        temp = head2;
        printList(head2);
        RandomListNode newHead2 = randomListNodeClone(head2);
        printList(head2);
        printList(newHead2);
        System.out.println(isSame(temp, head2));
        System.out.println(isSame(head2, newHead2));

    }
}
