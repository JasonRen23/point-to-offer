package feature;

public class TestReference {

     static class Test{
        private int id;
        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return id;
        }
    }

    public static void main(String[] args) {
        String b = "hi";
        String a = "hello";
        a = b;
        b = "love";
        System.out.println("a: " + a);

        Test test1 = new Test();
        test1.setId(1);
        Test test2 = new Test();
        test2.setId(2);

        System.out.println("before swap");
        System.out.println(test1);
        System.out.println(test2);

        swap(test1, test2);
        System.out.println("after swap");
        System.out.println(test1);
        System.out.println(test2);


    }
    public static void swap(Test a, Test b){
         Test temp;
         temp = a;
         a = b;
         b = temp;

        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }



}
