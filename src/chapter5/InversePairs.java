package chapter5;

public class InversePairs {
    public static int InversePairs(int[] array){
        if(array == null || array.length < 1){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; ++i){
            copy[i] = array[i];
        }

        int count = InversePairsCore(array, copy, 0, array.length - 1);

        return count;
    }
    public static int InversePairsCore(int[] data, int[] copy, int start, int end){
        if(start == end){
            copy[start] = data[start];
            return 0;
        }

        int len = (end - start) / 2;
        int left = InversePairsCore(copy, data, start, start + len);
        int right = InversePairsCore(copy, data, start + len + 1, end);

        int i = start + len;

        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + len + 1){
            if(data[i] > data[j]){
                copy[indexCopy--] = data[i--];
                count += j - start - len;
            }
            else {
                copy[indexCopy--] = data[j--];
            }
        }
        for(; i >= start; --i){
            copy[indexCopy--] = data[i];
        }
        for(; j >= start + len + 1; --j){
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(InversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(InversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(InversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(InversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(InversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(InversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(InversePairs(data7)); // 3
    }
}
