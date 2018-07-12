package chapter2;

/**
 * @author zhicheng
 * @create 2018-07-12 下午3:48
 */


public class MaxProductAfterCutting {
    public static int maxProductAfterCutting_1(int length){
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;
        int[] products = new int[length + 1];
        for (int i = 0; i < 4; i++) {
            products[i] = i;
        }
        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 0; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if(max < product)
                    max = product;
                products[i] = max;
            }

        }
        max = products[length];

        return max;
    }

    public static int maxProductAfterCuttring_2(int length){
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;

        //尽可能多剪长度为3的绳子
        int timesOf3 = length / 3;

        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        if(length - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
    }

    public static void main(String[] args) {
        System.out.println("[Solution1]: The max product after cutting is " + maxProductAfterCutting_1(8));
        System.out.println("[Solution1]: The max product after cutting is " + maxProductAfterCuttring_2(8));

    }
}
