package chapter2;

public class RectCover {
    public static int rectCover(int target) {
        if(target <= 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;

        int coverMinus_1 = 1;
        int coverMinus_2 = 2;

        while(target-- != 1){
            coverMinus_2 += coverMinus_1;
            coverMinus_1 = coverMinus_2 - coverMinus_1;
        }
        return coverMinus_1;
    }

    public static void main(String[] args) {
        int target = 3;
        System.out.println("The number of rectCover method is " + rectCover(target));
    }
}
