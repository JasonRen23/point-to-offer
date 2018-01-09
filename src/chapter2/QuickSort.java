package chapter2;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static int Partition(int[] data, int start, int end){
        if(data == null || data.length <= 0 || start < 0 || end >= data.length){
            throw new RuntimeException("Invalid parameter!");
        }

        int index = new Random().nextInt(end);
        int pivotValue = data[index];

        int storeIndex = start - 1;
        Swap(data, index, end);

        for(int i = start; i < end; ++i){
            if(data[i] < pivotValue){
                ++storeIndex;
                if(i != storeIndex){
                    Swap(data, storeIndex, i);
                }
            }
        }

        ++storeIndex;
        Swap(data, storeIndex, end);

        return storeIndex;

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
        int[] array = {4,1,7,6};
        System.out.println("Before quickSort. " + Arrays.toString(array));
        QuickSort(array, 0, array.length-1);
//        Swap(array, 0, 1);
        System.out.println("After quickSort. " + Arrays.toString(array));
    }
}
