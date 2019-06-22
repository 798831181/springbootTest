package test;

import java.util.PriorityQueue;

public class TestHeap {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(0);
        priorityQueue.add(2);
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++){
            System.out.println(priorityQueue.remove());
        }
    }

}
