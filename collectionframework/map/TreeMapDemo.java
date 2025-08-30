package collectionframework.map;

import java.util.*;

public class TreeMapDemo{
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        // Insert
        map.put("Bob", 30);
        map.put("Charlie", 22);
        map.put("Alice", 25);

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

