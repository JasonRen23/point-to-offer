package chapter5;

import java.util.Scanner;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午9:58
 * @email : zhicheng_ren@163.com
 */
public class LongestNotRepeatSubString {
    private static int getLongSubstr(String str) {
        int curLength = 0;
        int maxLength = 0;

        int[] pos = new int[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int prevIndex = pos[str.charAt(i) - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLength)
                ++curLength;
            else {
                curLength = i - prevIndex;
            }

            pos[str.charAt(i) - 'a'] = i;

            if (curLength > maxLength)
                maxLength = curLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            System.out.println("The result is " + getLongSubstr(str));
        }
    }
}
