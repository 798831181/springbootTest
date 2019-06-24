package offer;

import java.util.Stack;

public class Q21 {


    //定义一个数据栈
    Stack<Integer> dataStack = new Stack<>();
    //定义一个存放最小数的最小栈
    Stack<Integer> minStack = new Stack<>();
    private int minNode;
    public void push(int node) {
        if (minStack.size() == 0 || minNode < node){
            minNode = node;
            minStack.push(node);
        }else {
                minStack.push(node);
                minNode = node;
        }

        dataStack.push(node);

    }

    public void pop() {
        if (dataStack.size() > 0 && minStack.size() > 0){
            dataStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {

        return minStack.peek();
    }
    //test
    public static void main(String[] args) {
        Q21 test = new Q21();
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(1);
        System.out.println("弹出元素1之前栈中的最小元素：");
        System.out.println(test.min());
        for (int i = 0; i < 3; i++){
            test.pop();
        }
        System.out.println("弹出三个元素之后栈中的最小元素：");
        System.out.println(test.min());
    }
}
