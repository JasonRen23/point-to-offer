package sort;

import java.util.Random;

public class QuickSort {
    public int Partition(int[] data, int start, int end){
        if(data == null || data.length <= 0 || start < 0 || end > data.length - 1){
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

        return  storeIndex;
    }

    public static void Swap(int[] data, int index1, int index2){
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
