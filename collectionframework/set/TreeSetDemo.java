package collectionframework.set;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(30);
        set.add(10);
        set.add(10); // duplicate ignored
        set.add(20);

        System.out.println("TreeSet: " + set); // order not guaranteed

        System.out.println("Contains 20? " + set.contains(20));
        set.remove(20);
        System.out.println("After removal: " + set);

    }
}
