package chapter4;

import java.util.Stack;
import dataStructure.TreeNode;

/**
 * Created by JasonRen on 2018/1/13
 */
public class MirrorTree {
    public static void mirrorTreeRecursive(TreeNode root) {
        /**
         * @description: create mirror tree recursively
         * @param: [root]
         * @return: void
         */
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            mirrorTreeRecursive(root.left);
        }
        if(root.right != null){
            mirrorTreeRecursive(root.right);
        }
    }

    public static void mirrorTreeStack(TreeNode root){
        /**
         * @description: use stack to store every node in origin tree,
         * pop the node to exchange its right and left node.
         * @param: [root]
         * @return: void
         */
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode node =stack.pop();
           if(node.left !=null || node.right != null){
               TreeNode temp = node.left;
               node.left = node.right;
               node.right = temp;
           }
           if(node.left != null){
               stack.push(node.left);
           }
           if(node.right != null){
               stack.push(node.right);
           }
        }

    }

    public static void main(String[] args) {
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
        root.printPreOrder(root);
        System.out.println();
        mirrorTreeStack(root);
        root.printPreOrder(root);
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

        System.out.println("\n");
        root2.printPreOrder(root2);
        System.out.println();
        mirrorTreeRecursive(root2);
        root2.printPreOrder(root2);

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
        System.out.println("\n");
        root3.printPreOrder(root3);
        System.out.println();
        mirrorTreeRecursive(root3);
        root3.printPreOrder(root3);



    }
}
