package chapter5;

import java.util.Comparator;

public class PrintMinNumber {
    public static String PrintMinNumber(int[] numbers){
        if(numbers == null || numbers.length < 1){
//            throw new IllegalArgumentException("Array must contain value!");
            return "";
        }

        CombineComparator comparator = new CombineComparator();

        QuickSort(numbers, 0, numbers.length - 1, comparator);

        StringBuilder ret = new StringBuilder();

        for(int i : numbers){
            ret.append(String.valueOf(i));
        }

        return ret.toString();


    }

    private static class CombineComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2){
            if(o1 == null || o2 == null){
                throw new IllegalArgumentException("Arg should not be null");
            }

            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        }
    }

    public static void QuickSort(int[] array, int start, int end, Comparator<String> comparator){
        if(start < end){
            int pivot = array[start];
            int left = start;
            int right = end;
            while(start < end){
                while(start < end && comparator.compare(String.valueOf(array[end]),String.valueOf(pivot)) >= 0){
                    --end;
                }

                array[start] = array[end];

                while(start < end && comparator.compare(String.valueOf(array[start]),String.valueOf(pivot)) <= 0){
                    ++start;
                }

                array[end] = array[start];
            }

            array[start] = pivot;

            QuickSort(array, left, start - 1, comparator);
            QuickSort(array, start + 1, right, comparator);

        }
    }

    public static void main(String[] args) {
        int[] data1 = {3,5,1};
        System.out.println(PrintMinNumber(data1));

        int[] data2 = {3,32,321};
        System.out.println(PrintMinNumber(data2));

        int[] data3 = {3,323,32123};
        System.out.println(PrintMinNumber(data3));

        int[] data4 = {1,11,111};
        System.out.println(PrintMinNumber(data4));

        int[] data5 = {321};
        System.out.println(PrintMinNumber(data5));


    }
}
