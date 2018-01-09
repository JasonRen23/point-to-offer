package chapter2;

public class JumpFloor {
    public static int jumpFloor(int target) {
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int jumpMinus_1 = 1;
        int jumpMinus_2 = 2;

        while(target-- != 1){
            jumpMinus_2 += jumpMinus_1;
            jumpMinus_1 = jumpMinus_2 - jumpMinus_1;
        }
        return jumpMinus_1;
    }

    public static void main(String[] args) {
        int target = 4;
        System.out.println("The number of jump floor method is " + jumpFloor(target));
    }
}
