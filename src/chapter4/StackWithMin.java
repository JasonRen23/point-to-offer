package chapter4;


import java.util.Stack;

/**
 * Created by JasonRen on 2018/1/14
 */
public class StackWithMin<T extends Comparable<T>>{

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    
    public void push(int node) {
        dataStack.push(node);

        if(minStack.size() == 0 || node < minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(minStack.size() > 0 && dataStack.size() > 0){
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(dataStack.size() > 0){
            return dataStack.peek();
        }
        return -1;
    }


    public int min() {
        if(minStack.size() > 0){
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println("The minimum number in stack is " + stack.min());
        stack.pop();
        System.out.println("The top number in stack is " + stack.top());
        System.out.println("The minimum number in stack is " + stack.min());
        stack.pop();

    }


}
