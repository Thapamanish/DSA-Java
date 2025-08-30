package collectionframework.set;

import java.util.*;

public class LinkedListBasics {
    public static void main(String[] args){
        // ArrayList demo
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList: " + arrayList);
        System.out.println("ArrayList get(1): " + arrayList.get(1)); // O(1)

        // LinkedList demo
        List<Integer> linkedList = new LinkedList<>();
           linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("LinkedList get(1): " + linkedList.get(1)); // O(n)

        // Insert at head
        arrayList.add(0, 5);   // shifts → O(n)
        linkedList.add(0, 5);  // O(1)
        System.out.println("ArrayList after add at head: " + arrayList);
        System.out.println("LinkedList after add at head: " + linkedList);


    }
    
}
