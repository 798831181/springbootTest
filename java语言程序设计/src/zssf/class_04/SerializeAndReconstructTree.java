package zssf.class_04;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }
    public static String serialBypreOrder(Node head){
        if (head == null)
            return "#!";
        String res = head.value + "!";
        res += serialBypreOrder(head.left);
        res += serialBypreOrder(head.right);
        return res;

    }
    public static Node reconbyPreString(String preString){
        String[] strings = preString.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != strings.length; i++){
            queue.offer(strings[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String vaule = queue.poll();
        if (vaule.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(vaule));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);

        printTree(head);
        String pre = serialBypreOrder(head);

        System.out.println(pre);
        head = reconbyPreString(pre);
        printTree(head);

    }

}
