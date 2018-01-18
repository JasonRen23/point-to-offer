package chapter5;

public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }

        String value = n + "";
        int[] numbers = new int[value.length()];

        for(int i = 0; i < numbers.length; ++i){
            numbers[i] = value.charAt(i) - '0';
        }

        return numberOf1(numbers, 0);
    }
    public static int numberOf1(int[] num, int digit){
        if(num == null || digit >= num.length || digit < 0){
            return 0;
        }
        int first = num[digit];

        int len = num.length - digit;

        if(len == 1 && first == 0){
            return 0;
        }

        if(len == 1 && first > 0){
            return 1;
        }

        int numberFirstDigit = 0;

        if(first > 1){
            numberFirstDigit = PowerBase10(len - 1);
        }else if(first == 1){
            numberFirstDigit = ArrayToNum(num, digit + 1) + 1;
        }

        int numOtherDigits =first * (len - 1) * PowerBase10(len - 2);

        int numRecursive = numberOf1(num, digit + 1);

        return numberFirstDigit + numOtherDigits + numRecursive;


    }

    public static int PowerBase10(int n){
        int result = 1;
        for(int i = 0; i < n; ++i){
            result *= 10;
        }
        return result;
    }

    public static int ArrayToNum(int[] num, int i){
        int result = 0;
        for(int j = i; j < num.length; ++j){
            result = result * 10 + num[j];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1)); // 1
        System.out.println(NumberOf1Between1AndN_Solution(5)); // 1
        System.out.println(NumberOf1Between1AndN_Solution(11)); // 2
        System.out.println(NumberOf1Between1AndN_Solution(55)); // 16
        System.out.println(NumberOf1Between1AndN_Solution(99)); // 20
        System.out.println(NumberOf1Between1AndN_Solution(10000)); // 4001
        System.out.println(NumberOf1Between1AndN_Solution(21345)); // 18821
        System.out.println(NumberOf1Between1AndN_Solution(0)); // 0
    }
}
