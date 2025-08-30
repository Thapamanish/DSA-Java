package collectionframework.map;

import java.util.*;

public class LinkedHashMapDemo{
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        // Insert
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 22);

        // Overwrite value
        map.put("Alice", 26);

        System.out.println("Map: " + map);
        System.out.println("Map: " + map);

        // Access
        System.out.println("Alice's age: " + map.get("Alice")); // 26
        System.out.println("Contains Bob? " + map.containsKey("Bob"));

        // Remove
        map.remove("Bob");
        System.out.println("After removing Bob: " + map);

        // Iterate 
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

