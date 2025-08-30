package collectionframework.queue;

import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Queue: " + q);
        System.out.println("Front: " + q.peek()); // 10
        System.out.println("Removed: " + q.poll()); // removes 10
        System.out.println("After removal: " + q); // [20, 30]
    }
}

