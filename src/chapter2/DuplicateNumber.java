package chapter2;

/**
 * @author zhicheng
 * @create 2018-07-10 下午8:33
 */


public class DuplicateNumber {
    public static boolean duplicate(int numbers[], int length, int[] duplication){
        if(numbers == null || length < 0)
            return false;
        for(int i = 0; i < length; i++){
            if(numbers[i] < 0 || numbers[i] > length - 1)
                return false;
            while (numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    int tmp = numbers[i];
                    numbers[i] = numbers[tmp];
                    numbers[tmp] = tmp;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(duplicate(arr1, 7, duplication) + "," + duplication[0]);
    }
}
