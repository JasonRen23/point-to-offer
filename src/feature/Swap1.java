package feature;

public class Swap1 {
    public static void Swap1(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }
    public  static  void main(String args[]){
        Integer a,b;
        a = new Integer(10);
        b = new Integer(20);
        Swap1.Swap1(a, b);
        System.out.println("a is " + a);
        System.out.println("b is " + b);
    }
}
