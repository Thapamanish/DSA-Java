package collectionframework.queue;

import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(10);  // front
        dq.addLast(20);   // back
        dq.addLast(30);

        System.out.println("Deque: " + dq); // [10, 20, 30]

        dq.removeFirst();
        System.out.println("After removeFirst: " + dq); // [20, 30]

        dq.removeLast();
        System.out.println("After removeLast: " + dq); // [20]
    }
}
