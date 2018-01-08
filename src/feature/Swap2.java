package feature;

public class Swap2 {
    public static void main(String args[]){
        Swap2 sw = new Swap2(1,2);
        System.out.println("Before.  i: " + sw.i + ", j: " + sw.j);
        sw.swap();
        System.out.println("After.   i: " + sw.i + ", j: " + sw.j);
    }
    int i,j;
    public Swap2(int i, int j){
        this.i = i;
        this.j = j;
    }

    public  void swap(){
        int temp;
        temp = i;
        i = j;
        j = temp;
    }
}
