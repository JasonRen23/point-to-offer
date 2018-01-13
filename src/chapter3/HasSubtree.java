package chapter3;

import dataStructure.TreeNode;

public class HasSubtree {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;

        if(root1 == null || root2 == null){
            return result;
        }

        if(root1.val == root2.val){
            result = doesTree1HaveTree2(root1, root2);
        }

        if(!result){
            result = hasSubtree(root1.left, root2);
        }

        if(!result){
            result = hasSubtree(root1.right, root2);
        }

        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val){
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        TreeNode sub1 = new TreeNode(3);
        sub1.left = new TreeNode(4);
        sub1.right = new TreeNode(5);

        TreeNode sub2 = new TreeNode(5);
        sub2.right = new TreeNode(6);



        System.out.println("The result is " + hasSubtree(null,sub1));
        System.out.println("The result is " + hasSubtree(root,null));
        System.out.println("The result is " + hasSubtree(null,null));
        System.out.println("The result is " + hasSubtree(root,sub1));
        System.out.println("The result is " + hasSubtree(root,sub2));
    }
}
