package chapter5;


import java.util.Random;

/**
 * Created by JasonRen on 2018/1/17
 */

public class MoreThanHalfNum {
    public static int moreThanHalfNum_Solution(int [] array) {
        int ret;
        if(array == null || array.length <= 0){
            return 0;
        }
        if(array.length <= 2){
          return array[0];
        }
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = Partition(array, start, end);
        while(index != middle){
            if(index > middle){
                end = index - 1;
                index = Partition(array, start, end);
            }else{
                start = index + 1;
                index = Partition(array, start, end);
            }

        }
        ret = array[middle];
//        System.out.println(CheckMoreThanHalf(array, ret));
        if(!CheckMoreThanHalf(array, ret)){
            ret = 0;
        }

        return ret;
    }

    public static int Partition(int[] data, int start, int end){
        if(data == null || data.length <= 0 || start < 0 || end > data.length - 1){
            throw new RuntimeException("Invalid parameter!");
        }

        int index = new Random().nextInt(end);
        int pivotValue = data[index];

        int storeIndex = start - 1;
        Swap(data, index, end);

        for(int i = start; i < end; ++i){
            if(data[i] <= pivotValue){
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

    public static boolean CheckMoreThanHalf(int[] data, int num){
        int times = 0;
        for(int i = 0; i < data.length; ++i){
            if(data[i] == num){
                ++times;
            }

        }
//        System.out.println("ret: "+num+" times:"+times);
        boolean isMoreThanHalf = true;
        if(times*2 <= data.length){
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }


    public static void main(String[] args) throws Exception{
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum_Solution(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum_Solution(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum_Solution(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum_Solution(numbers4));

        // 输入空指针
        System.out.println(moreThanHalfNum_Solution(null));
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(moreThanHalfNum_Solution(numbers5));

    }
}