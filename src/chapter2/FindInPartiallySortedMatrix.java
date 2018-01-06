package chapter2;


/**
 * Created by JasonRen on 2018/1/5
 */
public class FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrix(int target, int [][] array){
        int rows = array.length;
        int cols = array[0].length;
        if(array==null||array.length==0||(array.length==1&&array[0].length==0)) return false;
        int row = 0;
        int col = cols - 1;
        while(row < rows && col >= 0){
            if(array[row][col] == target){
                return true;

            }
            if(array[row][col] > target){
                -- col;
            }else{
                ++ row;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{4,7,10,13},{6,8,11,15}};
        System.out.println("Result is " + findInPartiallySortedMatrix(7, array));

    }
}
