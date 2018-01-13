package chapter4;

import java.util.ArrayList;

/**
 * Created by JasonRen on 2018/1/13
 */
public class PrintMatrixClockWisely {
    public static ArrayList<Integer> printMatrixClockWisely(int [][] matrix) {
        ArrayList<Integer> printList = new ArrayList<>();
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return printList;
        }

        int beginRow = 0;
        int beginCol = 0;

        while(beginRow*2 < matrix.length && beginCol*2 < matrix[0].length){
            printMatrixInCircle(matrix, printList, beginRow, beginCol);

            ++beginRow;
            ++beginCol;
        }

        return printList;
    }

    public static void printMatrixInCircle(int [][] matrix, ArrayList<Integer> printList, int beginRow, int beginCol){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int endRow = rows - 1 - beginRow;
        int endCol = cols - 1 - beginCol;

        //print from left to right
        for(int i = beginCol; i <= endCol; ++i){
            printList.add(matrix[beginRow][i]);
        }

        //print from up to down
        if(endRow > beginRow){
            for(int i = beginRow + 1; i <= endRow; ++i){
                printList.add(matrix[i][endCol]);
            }
        }

        if(endCol > beginCol && endRow > beginRow){
            for(int i = endCol - 1; i >= beginCol; --i){
                printList.add(matrix[endRow][i]);
            }
        }

        if(endRow - 2 >= beginRow && endCol > beginCol){
            for(int i = endRow - 1; i >= beginRow + 1; --i){
                printList.add(matrix[i][beginCol]);
            }
        }



    }

    public static void main(String[] args) {
        int[][] numbers1 = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        System.out.println("The result of number1 is " + printMatrixClockWisely(numbers1));
        System.out.println();

        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };
        System.out.println("The result of number2 is " + printMatrixClockWisely(numbers2));
        System.out.println();


        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        System.out.println("The result of number3 is " + printMatrixClockWisely(numbers3));
        System.out.println();

        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        System.out.println("The result of number4 is " + printMatrixClockWisely(numbers4));
        System.out.println();


        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        System.out.println("The result of number5 is " + printMatrixClockWisely(numbers5));
        System.out.println();

        int[][] numbers6 = {
                {0, 1},
                {15, 2},
                {14, 3},
                {13, 4},
                {12, 5},
                {11, 6},
                {10, 7},
                {9, 8}
        };
        System.out.println("The result of number6 is " + printMatrixClockWisely(numbers6));
        System.out.println();


        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        System.out.println("The result of number7 is " + printMatrixClockWisely(numbers7));
        System.out.println();

        int[][] numbers8 = {
                {1}
        };
        System.out.println("The result of number8 is " + printMatrixClockWisely(numbers8));
        System.out.println();

        // 0个元素的数组
        System.out.println("The result of no number array is " + printMatrixClockWisely(new int[][]{{}}));
        System.out.println();
        // 空数组
        System.out.println("The result of null is " + printMatrixClockWisely(null));



    }
}
