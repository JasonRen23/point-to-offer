package feature;


//MyInteger: 与Integer有些类似，但是其对象可以变值
class MyInteger {
    private int x;    // 将x作为唯一的数据成员
    public MyInteger(int xIn) { x = xIn; } // 构造器
    public int getValue() { return x; }  // 得到值
    public void insertValue(int xIn) { x = xIn;} // 改变值
}

public class Swapping {
    // swap: 传对象引用
    static void swap(MyInteger rWrap, MyInteger sWrap) {
        // 变值过程
        int t = rWrap.getValue();
        rWrap.insertValue(sWrap.getValue());
        sWrap.insertValue(t);
    }
    public static void main(String[] args) {
        int a = 23, b = 47;
        System.out.println("Before. a:" + a + ", b: " + b);
        MyInteger aWrap = new MyInteger(a);
        MyInteger bWrap = new MyInteger(b);
        swap(aWrap, bWrap);
        a = aWrap.getValue();
        b = bWrap.getValue();
        System.out.println("After.  a:" + a + ", b: " + b);
    }
}

