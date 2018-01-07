package chapter2;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static int Partition(int[] data, int start, int end){
        if(data == null || data.length <= 0 || start < 0 || end >= data.length){
            throw new RuntimeException("Invalid parameter!");
        }

        int index = new Random().nextInt(end + 1);
//        System.out.println(index);
        Swap(data, index, end);

        int small = start - 1;
        for(index = start; index < end; ++ index){
            if(data[index] < data[end]){
                ++small;
                if(small != index){
                    Swap(data, index, small);
                }
            }
        }

        ++small;
        Swap(data, small, end);
        return small;

    }

    public static void Swap(int[] data, int index1, int index2){
        int tmp = data[index1];
        data[index1]= data[index2];
        data[index2] = tmp;

    }

    public static void QuickSort(int[] data, int start, int end){
        if(start == end){
            return;
        }

        int index = Partition(data, start, end);
        if(index > start)
            QuickSort(data, start, index-1);
        if(index < end)
            QuickSort(data, index+1, end);
    }

    public static void main(String[] args) {
        int[] array = {4,1,7,2,3,5};
        System.out.println(Arrays.toString(array));
        QuickSort(array, 0, array.length-1);
//        Swap(array, 0, 1);
        System.out.println(Arrays.toString(array));
    }
}
