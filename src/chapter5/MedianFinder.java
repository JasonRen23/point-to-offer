package google_intern;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> small, large;
    private boolean even = true;
    public MedianFinder() {
        small = new PriorityQueue<>();                           //small = new PriorityQueue<>(new MinHeapComparator())
        large = new PriorityQueue<>(Collections.reverseOrder());// large = new PriorityQueue<>(new MaxHeapComparator());
    }

    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even){
            return (small.peek() + large.peek()) / 2.0;
        }else{
            return small.peek();
        }
    }
    static class MinHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            if(o1 > o2){
                return 1;
            }else{
                return -1;
            }
        }
    }
    static class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            if(o1 < o2){
                return 1;
            }else{
                return -1;
            }
        }
    }


    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("findMedian() -> " + mf.findMedian());
        mf.addNum(3);
        System.out.println("findMedian() -> " + mf.findMedian());
        mf.addNum(4);
        System.out.println("findMedian() -> " + mf.findMedian());
    }

}
