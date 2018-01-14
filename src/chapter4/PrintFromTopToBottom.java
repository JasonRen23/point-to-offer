package chapter4;

import dataStructure.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> printList = new ArrayList<>();
        if(root == null){
            return printList;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(queue.size() > 0){
            TreeNode pNode = queue.poll();
            printList.add(pNode.val);

            if(pNode.left != null){
                queue.offer(pNode.left);
            }

            if(pNode.right != null){
                queue.offer(pNode.right);
            }
        }

        return printList;

    }

    public static void main(String[] args) throws RuntimeException{
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(printFromTopToBottom(root));
        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(5);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.left.left = new TreeNode(9);

        System.out.println();
        System.out.println(printFromTopToBottom(root2));
        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode(0);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(4);
        root3.right.right.right = new TreeNode(6);
        root3.right.right.right.right = new TreeNode(8);
        System.out.println();
        System.out.println(printFromTopToBottom(root3));
        // 1
        TreeNode root4 = new TreeNode(1);
        System.out.println();
        System.out.println(printFromTopToBottom(root4));
        // null
        System.out.println();
        System.out.println(printFromTopToBottom(null));
    }
}
