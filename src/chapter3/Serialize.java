package chapter3;

import dataStructure.TreeNode;

import static dataStructure.TreeNode.assemble;

/**
 * @author : JasonRen
 * @date : 2018-07-27 下午3:08
 * @email : zhicheng_ren@163.com
 */
public class Serialize {
    static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("$,");
            return stringBuilder.toString();
        }

        stringBuilder.append(root.val + ",");
        stringBuilder.append(serialize(root.left));
        stringBuilder.append(serialize(root.right));
        return stringBuilder.toString();
    }


    static int index = -1;

    static TreeNode deSerialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }

        String[] arr = str.split(",");
        TreeNode root = null;
        if (!arr[index].equals("$")) {
            root = new TreeNode(Integer.valueOf(arr[index]));
            root.left = deSerialize(str);
            root.right = deSerialize(str);
        }
        return root;
    }

    public static void main(String[] args) {
        test01();
    }

    //                            1
    //                  2                   3
    //             4                   5          6
    private static void test01() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        assemble(n1, n2, n3);
        assemble(n2, n4, null);
        assemble(n3, n5, n6);
        System.out.println(serialize(n1));
        n1.printPreOrder(deSerialize(serialize(n1)));
    }
}
