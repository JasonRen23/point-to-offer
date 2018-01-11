package chapter3;

/**
 * Created by JasonRen on 2018/1/11
 */
public class Power {
    public static double power(double base, int exponent) {
        /**
         * @description: 求base的exponent次方
         * @param: [base, exponent]
         * @return: double
         */
        if(equal(base, 0.0) && exponent < 0){
            throw new RuntimeException("Invalid input!");
        }
        int absExponent = exponent;
        if(exponent < 0){
            absExponent = -exponent;
        }
        double result  = powerWithUnsignedExponent(base, absExponent);
        if(exponent < 0){
            result = 1.0 / result;

        }
        return result;
    }

    public static double powerWithUnsignedExponent(double base, int absExponent){
        if(absExponent == 0){
            return 1;
        }
        if(absExponent == 1){
            return base;
        }

        double result = powerWithUnsignedExponent(base, absExponent >> 1);
        result *= result;
        if((absExponent & 0x1) == 1){
            result *= base;
        }

        return result;
    }

    // Because the accuracy of the computer, we need equal to decide
    public static boolean equal(double num1, double num2){
        if(Math.abs(num1 - num2) <= 1E-14){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        double base = 2;
        // from java 8 the int data type to represent
        // an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of 2^32−1
        // use the Integer class we can input 2^32−1
        int exponent = Integer.parseUnsignedInt("4294967295");
        //the exponent will still be treat as signed
        System.out.println("The result of the power is " + power(base, exponent));

//        int vInt = Integer.parseUnsignedInt("4294967295");
//        System.out.println(Integer.toUnsignedString(vInt));

        System.out.println("The result of the power is " + power(2, -4));// normal input
        System.out.println("The result of the power is " + power(2, 4));// normal input
        System.out.println("The result of the power is " + power(2, -1));// normal input
        System.out.println("The result of the power is " + power(0.0000000000000000000000001111, 0));// normal input
        System.out.println("The result of the power is " + power(0.00000000000000000000000000001, -1));//Invalid input
        System.out.println("The result of the power is " + power(0.0000000000000000000000001111, -1));//Invalid input

    }
}
