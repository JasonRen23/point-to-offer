package chapter2;

public class NumberOf1 {
    public static int numberOf1(int n) {
        int count = 0;
        while(n != 0){
            n = (n - 1) & n;
            ++ count;
        }
        return count;
    }

    public static int numberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((flag & n) != 0) {
                ++count;
            }
            flag <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0X7FFF_FFFF;
        System.out.println("Method one. " + n + "的二进制表示中1的个数为：" + numberOf1(n));
        n = 0X8000_0000;
        System.out.println("Method one. " + n + "的二进制表示中1的个数为：" + numberOf1(n));
        n = 0XFFFF_FFFF;
        System.out.println("Method one. " + n + "的二进制表示中1的个数为：" + numberOf1(n));

        n = 0X7FFF_FFFF;
        System.out.println("Method two. " + n + "的二进制表示中1的个数为：" + numberOf1_2(n));
        n = 0X8000_0000;
        System.out.println("Method two. " + n + "的二进制表示中1的个数为：" + numberOf1_2(n));
        n = 0XFFFF_FFFF;
        System.out.println("Method two. " + n + "的二进制表示中1的个数为：" + numberOf1_2(n));
      
    }
}
