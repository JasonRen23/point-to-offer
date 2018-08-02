package chapter5;

/**
 * @author : JasonRen
 * @date : 2018-08-03 上午12:52
 * @email : zhicheng_ren@163.com
 */
public class GetTranslationCount {
    public static int getTranslationCount(int number) {
        if (number < 0)
            return 0;
        String numberToString = String.valueOf(number);
        return getTranslationCount(numberToString);
    }

    public static int getTranslationCount(String number) {
        int length = number.length();
        int[] counts = new int[length];
        int count;

        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1)
                count = counts[i + 1];
            else
                count = 1;

            if (i < length - 1) {
                int digit1 = number.charAt(i) - '0';
                int digit2 = number.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2)
                        count += counts[i + 2];
                    else
                        count += 1;
                }

            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String[] args) {
        System.out.println("12258有5种翻译方式  ===> " + getTranslationCount(12258));
        System.out.println(getTranslationCount(134));
    }
}
