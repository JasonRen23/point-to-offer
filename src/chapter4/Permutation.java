package chapter4;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        if(str == null || str.length() < 1){
            return ret;
        }
        permutationRecursive(str.toCharArray(), 0, ret);
        Collections.sort(ret); //sort the list by dictionary order
        return ret;
    }
    public static void permutationRecursive(char[] str, int begin, ArrayList<String> list){
        if(begin == str.length - 1){
            String var = String.valueOf(str);
            if(!list.contains(var))
                list.add(var);
        }else {
            for(int i = begin; i < str.length; ++i){
                swap(str, i, begin); //go to next level
                permutationRecursive(str, begin+1, list);
                swap(str, i, begin);//back to the last level
            }
        }

    }
    public static void swap(char[] str, int index1, int index2){
        char temp = str[index1];
        str[index1] = str[index2];
        str[index2] = temp;
    }

    public static void main(String[] args) {
        String str="abc";
        System.out.println(permutation(str).toString());
    }
}
