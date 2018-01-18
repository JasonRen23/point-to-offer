package chapter5;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import sort.QuickSort;

/**
 * Created by JasonRen on 2018/1/17
 */

public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if(input == null || k > input.length || input.length <=0 || k <= 0){
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

        return ret;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution_2(int[] input, int k){
        /**
         * @description: use the priorityqueue to realize the maxHeap, time complexity is O(nlogk)
         * @param: [input, k]
         * @return: java.util.ArrayList<java.lang.Integer>
         */
        ArrayList<Integer> ret = new ArrayList<>();
        if(input == null || k > input.length || input.length <=0 || k <0){
            return ret;
        }

        //PriorityQueue is actually a heap
        //Capacity is k, the comparator is need to override, if not it will use Comparable to sort
        //which will be a minHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1; // or o2.compareTo(o1);
            }

        });
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        for(int i : input){
            if(maxHeap.size() != k){
                maxHeap.offer(i);
            }else {
                int max = maxHeap.peek();
                if(max > i){
                    maxHeap.poll();
                    maxHeap.offer(i);
                }
            }
        }
        for(Integer integer : maxHeap){
            ret.add(integer);
        }

        return ret;
    }


    public static void main(String[] args) {
        int[] data = {4,5,1,6,2,7,3,8};
        System.out.println("The first method: " + GetLeastNumbers_Solution(data,4).toString());
        System.out.println("The second method: " + GetLeastNumbers_Solution_2(data,4).toString());
    }



}
