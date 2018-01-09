package chapter2;

public class JumpFloorII {
    public static int jumpFloorII(int target) {
        if(target <= 0){
            return 0;
        } else if(target == 1) {
            return 1;
        } else{
            return 2 * jumpFloorII(target - 1);
        }


    }

    public static void main(String[] args) {
        int target = 2;
        System.out.println("The number of jump floor method is " + jumpFloorII(target));
    }
}
