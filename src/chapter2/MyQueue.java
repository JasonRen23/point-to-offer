package chapter2;

import java.util.Stack;

/**
 * Created by JasonRen on 2018/1/7
 */
public class MyQueue<T> {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        //if the stack2 is empty, push the element from stack1 to stack2
       if(stack2.isEmpty()){
           while(!stack1.isEmpty()){
               stack2.push(stack1.pop());
           }
       }

       //if the stack2 is still empty, it shows that there are no elements in all stack
       if(stack2.isEmpty()){
           throw new RuntimeException("No more element!");
       }

       return stack2.pop();
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
