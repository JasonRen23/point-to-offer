package chapter4;

public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0){
            return false;
        }

        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }
    public static boolean verifySquenceOfBST(int [] sequence, int start, int end){

        if(start >= end){
            return true;
        }

        int root = sequence[end];

        //find the left subtree end
        int i = 0;
        for(; i < end; ++i){
            if(sequence[i] > root){
                break;
            }
        }

        int leftEnd = i;

        //find the right subtree end
        int j = leftEnd;
        for(; j < end; ++j){
            if(sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        if(leftEnd > 0){
            left = verifySquenceOfBST(sequence, 0, leftEnd - 1);
        }

        boolean right = true;
        if(leftEnd < end){
            right = verifySquenceOfBST(sequence, leftEnd, end - 1);
        }

        return left && right;
    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySquenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySquenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySquenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySquenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySquenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySquenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySquenceOfBST(data7));
    }
}
