package chapter4;

import dataStructure.TreeNode;
import java.util.ArrayList;

/**
 * Created by JasonRen on 2018/1/15
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> retList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
       ArrayList<ArrayList<Integer>> retList = new ArrayList<>();
       ArrayList<Integer> path = new ArrayList<>();
       if(root == null){
            return retList;
        }

       int current = 0;
       findPath(root, target, current, path);
       return this.retList;
   }

   public void findPath(TreeNode root, int target, int current, ArrayList<Integer> path){

       current += root.val;
       path.add(root.val);

       boolean isLeaf = (root.left == null && root.right == null);
       if(current == target && isLeaf){
           this.retList.add(new ArrayList<>(path));
           path.remove(path.size() - 1);
           return;
       }

       if(current < target && root.left != null){
           findPath(root.left, target, current, path);
       }

       if(current < target && root.right != null){
           findPath(root.right, target, current, path);
       }

       path.remove(path.size() - 1);

   }


    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
       TreeNode root =  new TreeNode(10);
       root.left = new TreeNode(5);
       root.right = new TreeNode(12);
       root.left.left = new TreeNode(4);
       root.left.right = new TreeNode(7);

       System.out.println("findPath(root, 22):");
       System.out.println(new FindPath().findPath(root, 22).toString());

       System.out.println("findPath(root, 15):");
       System.out.println(new FindPath().findPath(root, 15).toString());

       System.out.println("findPath(root, 19):");
       System.out.println(new FindPath().findPath(root, 19).toString());
    }
}
