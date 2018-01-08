package chapter2;


/**
 * Created by JasonRen on 2018/1/8
 */
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int [] array) {
        if(array.length <=0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while(array[left] >= array[right]){
            if(right - left == 1){
                return array[right];
            }

            mid = (left + right) / 2;

            if(array[mid] == array[left] && array[mid] == array[right]){
                return minInOrder(array, left, right);
            }

            if(array[mid] >= array[left]){
                left = mid;
            }

            if(array[mid] <= array[right]){
                right = mid;
            }
        }
        
        return array[mid];
    }

    public  static int minInOrder(int[] array, int left, int right){
        int ret = array[left];
        for(int i = left + 1; i <= right; ++i){
            if(array[i] < ret){
                ret = array[i];
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        System.out.println("The min number in rotate array is " + minNumberInRotateArray(array1));
        int[] array2 = {1,0,1,1,1};
        System.out.println("The min number in rotate array is " + minNumberInRotateArray(array2));
    }
}
