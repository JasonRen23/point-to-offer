package chapter2;

import dataStructure.TreeNode;

/**
 * Created by JasonRen on 2018/1/5
 */
public class ReConstructBinaryTree {
    public  static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    public  static TreeNode reConstructBinaryTree(int [] pre,int ps, int pe, int [] in, int is, int ie){
        /**
         * @description: recursive to construct the tree
         * @param: [pre, ps, pe, in, is, ie]
         * @param pre      前序遍历数组
         * @param ps       前序遍历的开始位置
         * @param pe       前序遍历的结束位置
         * @param in       中序遍历数组
         * @param is       中序遍历的开始位置
         * @param ie       中序遍历的结束位置
         * @return: dataStructure.TreeNode
         */
        if(ps > pe){
            return null;
        }

        // compute the number of nodes in left subtree and right subtree
        int leftNum = is;


        while(leftNum <= ie && in[leftNum] != pre[ps]){
            ++leftNum ;
        }
        if(leftNum > ie){
//            throw new RuntimeException("Invalid input!");
              return null;
        }
        // the root of this subtree
        TreeNode root = new TreeNode(pre[ps]);
        root.right = null;root.left = null;
        //the number of nodes in left subtree is leftNum-is+1
        //the range of the left subtree in preOrder is [ps+1, ps+leftNum-is]
        //the range of the left subtree in inOrder is [is, leftNum-1]
        root.left = reConstructBinaryTree(pre, ps+1,ps+leftNum-is, in, is, leftNum-1);
        //the number of nodes in right subtree is ie-index
        //the range of the right subtree in preOrder is [ps+leftNum-is+1, pe]
        //the range of the right subtree in inOrder is [leftNum+1, ie]
        root.right = reConstructBinaryTree(pre, ps+leftNum-is+1, pe, in, leftNum+1, ie);

        return root;
    }
    public static void printPreOrder(TreeNode root){
        /**
         * @description: preOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            System.out.print(root.val);
            printPreOrder(root.left);
            printPreOrder(root.right);

        }
    }
    public static void printInOrder(TreeNode root){
        /**
         * @description: inOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.val);
            printInOrder(root.right);

        }
    }

    public static void printPostOrder(TreeNode root){
        /**
         * @description: postOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.val);
        }
    }

    // 普通二叉树  
    //              1  
    //           /     \  
    //          2       3  
    //         /       / \  
    //        4       5   6  
    //         \         /  
    //          7       8  
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printPreOrder(root);
    }

    // 所有结点都没有右子结点  
    //            1  
    //           /  
    //          2  
    //         /  
    //        3  
    //       /  
    //      4  
    //     /  
    //    5  
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printPostOrder(root);
    }

    // 所有结点都没有左子结点  
    //            1  
    //             \  
    //              2  
    //               \  
    //                3  
    //                 \  
    //                  4  
    //                   \  
    //                    5  
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printPostOrder(root);
    }

    // 树中只有一个结点  
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printPostOrder(root);
    }

    // 完全二叉树  
    //              1  
    //           /     \  
    //          2       3  
    //         / \     / \  
    //        4   5   6   7  
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printPostOrder(root);
    }

    // 输入空指针  
    private static void test6() {
        reConstructBinaryTree(null, null);
    }

    // 输入的两个序列不匹配  
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printPostOrder(root);
    }


    public static void main(String[] args) {

        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();

    }
}
