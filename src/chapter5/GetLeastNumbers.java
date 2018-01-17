package chapter5;

import java.util.ArrayList;
import java.util.Collections;
import dataStructure.MaxHeap;

import sort.QuickSort;
/**
 * Created by JasonRen on 2018/1/17
 */

public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if(input == null || k > input.length || input.length <=0 || k <0){
            return ret;
        }
        int start = 0;
        int end = input.length - 1;
        int index = new QuickSort().Partition(input, start, end);
        while(index != k - 1){
            if(index > k - 1){
                end = index - 1;
                index = new QuickSort().Partition(input, start, end);
            }else {
                start = index + 1;
                index = new QuickSort().Partition(input, start, end);
            }
        }
        for(int i = 0; i < k; ++i){
            ret.add(input[i]);
        }
        Collections.sort(ret);

        return ret;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution_2(int[] input, int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if(input == null || k > input.length || input.length <=0 || k <0){
            return ret;
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for(int i : input){
            if(maxHeap.size() < k){
                maxHeap.add(i);
            }else {
                int max = maxHeap.first();
                if(max > 1){
                    maxHeap.delteTop();
                    maxHeap.add(i);
                }
            }
        }
        for(int i = 0; maxHeap.hasNext(); i++){
            ret.add(maxHeap.next());
        }

        return ret;
    }


    public static void main(String[] args) {
        int[] data = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution_2(data,4).toString());
    }



}
