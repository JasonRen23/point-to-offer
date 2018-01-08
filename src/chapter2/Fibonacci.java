package chapter2;

public class Fibonacci {
    public static int fibonacci_1(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci_1(n - 1) + fibonacci_1(n - 2);
    }

    public static int fibonacci_2(int n){
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;

        int fibMinus_1 = 0;
        int fibMinus_2 = 1;

        while(n-- != 0){
            fibMinus_2 += fibMinus_1;
            fibMinus_1 = fibMinus_2 - fibMinus_1;
        }
        return fibMinus_1;
    }

    public static void main(String[] args) {
        int n = 39;
        long startTime=System.currentTimeMillis();
        int result_1 = fibonacci_1(n);
        long endTime=System.currentTimeMillis();
        long runTime_1 = endTime - startTime;

        startTime=System.currentTimeMillis();
        int result_2 = fibonacci_2(n);
        endTime=System.currentTimeMillis();
        long runTime_2 = endTime - startTime;

        System.out.println("The " + n +" order Fibonacci number is " + result_1 + ",spend " + runTime_1 + " ms");
        System.out.println("The " + n +" order Fibonacci number is " + result_2 + ",spend " + runTime_2 + " ms");
    }
}
