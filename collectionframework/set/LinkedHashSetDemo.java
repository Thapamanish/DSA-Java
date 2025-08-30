package collectionframework.set;

import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();

        set.add(10);
        set.add(20);
        set.add(10); // duplicate ignored
        set.add(30);

        System.out.println("LinkedHashSet: " + set); // order not guaranteed

        System.out.println("Contains 20? " + set.contains(20));
        set.remove(20);
        System.out.println("After removal: " + set);

    }
}
