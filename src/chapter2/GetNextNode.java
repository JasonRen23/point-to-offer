package chapter2;

/**
 * @author zhicheng
 * @create 2018-07-11 下午2:37
 */


public class GetNextNode {
    public static class BinaryTreeNode {
        int val;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
        BinaryTreeNode next = null;

        BinaryTreeNode(int val){
            this.val = val;
        }
    }
    private static void assemble(BinaryTreeNode node, BinaryTreeNode left, BinaryTreeNode right, BinaryTreeNode parent){
        node.left = left;
        node.right = right;
        node.next = parent;
    }

    public static BinaryTreeNode getNext(BinaryTreeNode pNode){
        if(pNode == null)
            return pNode;
        BinaryTreeNode pNext = null;
        if(pNode.right != null){
            BinaryTreeNode pRight = pNode.right;
            while (pRight.left != null)
                pRight = pRight.left;
            pNext = pRight;
        }
        else if(pNode.next != null){
            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.next;
            while (pParent != null && pCurrent != pParent.left){
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }

    public static void main(String[] args) {
        //                            1
        //                  2                   3
        //             4         5          6          7
        //          8     9   10   11   12   13    14   15
            BinaryTreeNode n1 = new BinaryTreeNode(1); // 12
            BinaryTreeNode n2 = new BinaryTreeNode(2); // 10
            BinaryTreeNode n3 = new BinaryTreeNode(3); // 14
            BinaryTreeNode n4 = new BinaryTreeNode(4); // 9
            BinaryTreeNode n5 = new BinaryTreeNode(5); // 11
            BinaryTreeNode n6 = new BinaryTreeNode(6); // 13
            BinaryTreeNode n7 = new BinaryTreeNode(7); // 15
            BinaryTreeNode n8 = new BinaryTreeNode(8); // 4
            BinaryTreeNode n9 = new BinaryTreeNode(9); // 2
            BinaryTreeNode n10 = new BinaryTreeNode(10); // 5
            BinaryTreeNode n11 = new BinaryTreeNode(11); // 1
            BinaryTreeNode n12 = new BinaryTreeNode(12); // 6
            BinaryTreeNode n13 = new BinaryTreeNode(13); // 3
            BinaryTreeNode n14 = new BinaryTreeNode(14); // 7
            BinaryTreeNode n15 = new BinaryTreeNode(15); // null
            assemble(n1, n2, n3, null);
            assemble(n2, n4, n5, n1);
            assemble(n3, n6, n7, n1);
            assemble(n4, n8, n9, n2);
            assemble(n5, n10, n11, n2);
            assemble(n6, n12, n13, n3);
            assemble(n7, n14, n15, n3);
            assemble(n8, null, null, n4);
            assemble(n9, null, null, n4);
            assemble(n10, null, null, n5);
            assemble(n11, null, null, n5);
            assemble(n12, null, null, n6);
            assemble(n13, null, null, n6);
            assemble(n14, null, null, n7);
            assemble(n15, null, null, n7);
            System.out.println(getNext(n1).val);
            System.out.println(getNext(n2).val);
            System.out.println(getNext(n3).val);
            System.out.println(getNext(n4).val);
            System.out.println(getNext(n5).val);
            System.out.println(getNext(n6).val);
            System.out.println(getNext(n7).val);
            System.out.println(getNext(n8).val);
            System.out.println(getNext(n9).val);
            System.out.println(getNext(n10).val);
            System.out.println(getNext(n11).val);
            System.out.println(getNext(n12).val);
            System.out.println(getNext(n13).val);
            System.out.println(getNext(n14).val);
            System.out.println(getNext(n15) == null ? null : getNext(n15).val);
    }
}
