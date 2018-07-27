package dataStructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        val = x;
    }
//    public TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//    public int getval() {
//        return val;
//    }
//
//    public void setval(int val) {
//        this.val = val;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(TreeNode left) {
//        this.left = left;
//    }
//
//    public TreeNode getRight() {
//        return right;
//    }
//
//    public void setRight(TreeNode right) {
//        this.right = right;
//    }

    public static void printPreOrder(TreeNode root){
        /**
         * @description: preOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            System.out.print(root.val + " ");
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
            System.out.print(root.val + " ");
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
            System.out.print(root.val + " ");
        }
    }

    public static void assemble(TreeNode node, TreeNode left, TreeNode right) {
        node.left = left;
        node.right = right;
    }

    @Override
    public String toString() {
        return val + "";
    }
}

