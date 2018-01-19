package chapter5;

import java.util.HashMap;

/**
 * Created by JasonRen on 2018/1/19
 */
public class FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str){
        if(str == null || str.length() < 1){
            return -1;
        }

        char[] charArray = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();


        for(int i = 0; i < charArray.length; ++i){
            if(!map.containsKey(charArray[i])){
                map.put(charArray[i], 1);
            }else {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            }
        }


        for(int j = 0; j < charArray.length; ++j){
            if(map.get(charArray[j]) == 1){
                return j;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println("The first not repeating char position is " + FirstNotRepeatingChar(str));
    }
}
