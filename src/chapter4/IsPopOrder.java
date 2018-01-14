package chapter4;

import java.util.Stack;

public class IsPopOrder {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length <= 0 || popA.length <= 0 || pushA.length != popA.length){
            return false;
        }
        boolean retFlag = false;
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> dataStack = new Stack<>();

        while(popIndex < popA.length){
            while(dataStack.isEmpty() || dataStack.peek() != popA[popIndex]){
                if(pushIndex >= pushA.length){
                    break;
                }
                dataStack.push(pushA[pushIndex++]);
            }

            if(dataStack.peek() != popA[popIndex]){
                break;
            }

            dataStack.pop();
            ++popIndex;


        }

        if(dataStack.isEmpty()){
            retFlag = true;
        }



        return retFlag;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));
    }

}
