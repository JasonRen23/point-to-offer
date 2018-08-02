package chapter5;

/**
 * @author : JasonRen
 * @date : 2018-08-03 上午12:23
 * @email : zhicheng_ren@163.com
 */
public class DigitAtIndex {
    public static int digitAtIndex(int index) {
        if(index < 0)
            return -1;
        int digit = 1;
        while (true) {
            int number = countOfIntegers(digit);
            if(index < number)
                return digitAtIndex(index, digit);
            index -= digit * number;
            digit++;
        }
    }

    public static int countOfIntegers(int digit) {
        if (digit == 1)
            return 10;
        int count = (int) Math.pow(10, digit - 1);
        return count * 9;
    }
    /**
     *
     * @Description:  找到具体的那位数字
     * @param index, digit
     * @return:
     *
     */
    public static int digitAtIndex(int index, int digit) {
        int number = beginNumber(digit) + index /digit;
        int indexFromRight = digit - index % digit;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;

    }

    /**
     *
     * @Description:  返回m位数的第一位数，如0/10/100/1000
     * @param digit
     * @return
     */
    public static int beginNumber(int digit) {
        if(digit == 1)
            return 0;
        return (int) Math.pow(10, digit - 1);
    }



    public static void main(String[] args) {
        System.out.println("7 ====> " + digitAtIndex(1001));
    }
}
