package collectionframework.queue;                                                                                                                                      package collectionframework.queue                                                                                                                                                                                                                                                                                               n                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            67ramework.Queue;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("PriorityQueue: " + pq); // order not guaranteed
        System.out.println("Peek (smallest): " + pq.peek()); // 10
        System.out.println("Poll: " + pq.poll()); // removes 10
        System.out.println("After poll: " + pq); // [20, 30]

        // Max-heap: provide custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        System.out.println("MaxHeap peek: " + maxHeap.peek()); // 30
    }
}

