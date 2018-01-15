package chapter4;

import dataStructure.TreeNode;

/**
 * Created by JasonRen on 2018/1/15
 */
public class ConvertTreeToList {
    public static TreeNode convert(TreeNode pRootOfTree){
        // 用于保存处理过程中的双向链表的尾结点
        TreeNode[] lastNode = new TreeNode[1];
        convertNode(pRootOfTree, lastNode);

        // 找到双向链表的头结点
        TreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    /**
     * 链表表转换操作
     *
     * @param node     当前的根结点
     * @param lastNode 已经处理好的双向链表的尾结点，使用一个长度为1的数组，类似C++中的二级指针
     */
    public static void convertNode(TreeNode node, TreeNode[] lastNode) {
        // 结点不为空
        if (node != null) {

            // 如果有左子树就先处理左子树
            if (node.left != null) {
                convertNode(node.left, lastNode);
            }

            // 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
            node.left = lastNode[0];

            // 如果左子树转换成的双向链表不为空，设置尾结点的后继
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }

            // 记录当前结点为尾结点
            lastNode[0] = node;

            // 处理右子树
            if (node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }

    public static void printList(TreeNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.right;
        }
        System.out.println("null");
    }

    public static void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
//        System.out.println("null");
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        System.out.print("Before convert: ");
        printTree(root);
        System.out.println("null");
        TreeNode head = convert(root);
        System.out.print("After convert: ");
        printList(head);

    }
}
