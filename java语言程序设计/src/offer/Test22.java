package offer;

import java.util.Stack;

/**
 *判断一个序列是不是，给定栈的弹栈序列
 */
public class Test22 {
    public static boolean isPopOrder(int[] push, int[] pop){
        boolean isPopOrder = false;
        if (pop == null || push == null || pop.length != push.length){
            return false;
        }
        Stack<Integer> stack = new Stack();

        int popNum = 0;
        int pushNum = 0;
        while (popNum < pop.length){

            while (stack.isEmpty() || stack.peek() != pop[popNum]){

                if (pushNum >= push.length) {
                    break;
                }
                stack.push(push[pushNum]);
                pushNum++;
            }

            if (stack.peek() != pop[popNum]) {
                break;
            }
            stack.pop();
            popNum++;
        }
        if (stack.isEmpty()){
            isPopOrder = true;
        }

        return isPopOrder;
    }
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));
    }
}
