package chapter3;

import java.util.Arrays;

/**
 * Created by JasonRen on 2018/1/11
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        if(array == null || array.length <= 1)
            return;

        int len = array.length;
        int k = 0;
        for(int i = 0; i < len; ++i){
            if(!isEven(array[i])){
                int j = i;
                while(j > k){
                    Swap(array, j, j - 1);
                    j--;
                }
                k++;
            }
        }
    }


    public static boolean isEven(int num){
        /**
         * @description: decide the number is even or not
         * @param: [num]
         * @return: boolean
         */
        return (num & 0x1) == 0;
    }

    public static boolean isNegative(int num){
        return num < 0;
    }



    public static void Swap(int[] data, int index1, int index2){
        /**
         * @description: swap the data[index1] and data[index2]
         * @param: [data, index1, index2]
         * @return: void
         */
        int tmp = data[index1];
        data[index1]= data[index2];
        data[index2] = tmp;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, -3, 4, -5};
        reOrderArray(array);
        System.out.println("The array after reorder is " + Arrays.toString(array));
    }
}
