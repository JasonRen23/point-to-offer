package chapter3;

/**
 * Created by JasonRen on 2018/1/11
 */
public class Print1ToMaxOfNDigits {
    public static void  print1ToMaxOfNDigits(int n){
        if(n <= 0){
            throw new RuntimeException("The input number must larger than 0!");
        }
        int[] number = new int[n];
        print1ToMaxOfNDigitsRecursively(number, 0);

    }

    public static void print1ToMaxOfNDigitsRecursively(int[] number, int index){
        if(index == number.length){
            printNumber(number);
            return;
        }

        for(int i = 0; i < 10; ++i){
            number[index] = i;
            print1ToMaxOfNDigitsRecursively(number, index + 1);
        }
    }


    public static void printNumber(int[] number){
        boolean isBeginningZero = true;
        int len = number.length;

        for(int i = 0; i < len; ++i){
            if(isBeginningZero && number[i] != 0){
                isBeginningZero = false;
            }
            if(!isBeginningZero){
                System.out.print(number[i]);
//                System.out.println();
            }
        }
        if(!isBeginningZero){
            System.out.println();
        }

    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }

}
