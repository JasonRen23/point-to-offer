package chapter4;

import dataStructure.TreeNode;

import static dataStructure.TreeNode.assemble;

/**
 * @author : JasonRen
 * @date : 2018-07-27 下午2:40
 * @email : zhicheng_ren@163.com
 */
public class IsSymmetrical {
    public static boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    public static boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }


    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    //                            1
    //                  2                   2
    //             4         6          6          4
    //          8     9   10   11   11     10   9     8
    public static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(11);
        TreeNode n13 = new TreeNode(10);
        TreeNode n14 = new TreeNode(9);
        TreeNode n15 = new TreeNode(8);
        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);
        System.out.println(isSymmetrical(n1));
    }

    //                            1
    //                  2                   2
    //             4         5          6          4
    //          8     9   10   11   11     10   9     8
    public static void test02() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(11);
        TreeNode n13 = new TreeNode(10);
        TreeNode n14 = new TreeNode(9);
        TreeNode n15 = new TreeNode(8);
        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);
        System.out.println(isSymmetrical(n1));
    }

    //                            7
    //                  7                   7
    //             7         7          7
    public static void test03() {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(7);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, null);
        System.out.println(isSymmetrical(n1));
    }
}
