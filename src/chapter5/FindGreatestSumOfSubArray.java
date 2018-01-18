package chapter5;

/**
 * Created by JasonRen on 2018/1/18
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array){
        if(array == null || array.length < 1){
            throw new IllegalArgumentException("Array must contain at least one element!");
        }
        int curSum = 0;
        int ret = array[0];
        if(array.length == 1){
            return ret;
        }
        for(int i = 0; i < array.length; ++i){
            if(curSum <= 0){
                curSum = array[i];
            }else {
                curSum = curSum + array[i];
            }

            if(curSum > ret)
                ret = curSum;
        }

        return ret;
    }

  

    public static void main(String[] args) {
        int[] data1 = {1,-2,3,10,-4,7,2,-5};
        int[] data2 = {-2,-8,-1,-5,-9};
        int[] data3 = {2,8,1,5,9};
        System.out.println("The result of the data1 is: " + FindGreatestSumOfSubArray(data1));
        System.out.println("The result of the data2 is: " + FindGreatestSumOfSubArray(data2));
        System.out.println("The result of the data3 is: " + FindGreatestSumOfSubArray(data3));

    }

}
