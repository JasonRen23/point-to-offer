package chapter2;

/**
 * Created by JasonRen on 2018/1/5
 */
public class ReplaceSpaces {
    public static String replaceSpace(StringBuffer str){
        int originLength = str.length();
        int spaceCount = 0;
        //if the str is not common, return
        if(str == null || originLength <= 0){
            return str.toString();
        }
        //compute the count of space
        for(int i  = 0; i < originLength; ++i){
            if(str.charAt(i) == ' '){
                spaceCount += 1;
            }
        }
        //add %20 length to originLength
        int newLength = originLength + spaceCount*2;
        // if there is no space, return
        if (newLength == str.length() ){
            return str.toString();
        }
        for(int i  = 0; i < spaceCount*2; ++i){
               str.append('a');
        }

        //replace the space
        int indexOfOriginal = originLength - 1;
        int indexOfNew = newLength - 1;
        while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
            if(str.charAt(indexOfOriginal) == ' '){
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'%');
            }else{
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
            --indexOfOriginal;
        }




        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy.");
        System.out.println(replaceSpace(str));

    }

}
