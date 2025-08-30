package collectionframework.map;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        // 1) Creation
        System.out.println("== Creation ==");
        Map<String, Integer> map = new HashMap<>();                  // empty
        Map<String, Integer> withCap = new HashMap<>(20);            // with initial capacity
        Map<String, Integer> copy = new HashMap<>(Map.of("a", 1, "b", 2));
        System.out.println("empty: " + map);
        System.out.println("withCap: " + withCap);
        System.out.println("copy: " + copy);

        // 2) Adding & Updating
        System.out.println("\n== Adding & Updating ==");
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 22);
        map.put("Alice", 26); // overwrite
        System.out.println("map after put: " + map);
        map.putIfAbsent("David", 40);
        map.putIfAbsent("Alice", 99); // won't overwrite
        System.out.println("map after putIfAbsent: " + map);
        map.putAll(copy);
        System.out.println("map after putAll(copy): " + map);

        // 3) Accessing Values
        System.out.println("\n== Accessing Values ==");
        System.out.println("get(\"Alice\"): " + map.get("Alice"));
        System.out.println("getOrDefault(\"Zoe\", -1): " + map.getOrDefault("Zoe", -1));
        System.out.println("containsKey(\"Bob\"): " + map.containsKey("Bob"));
        System.out.println("containsValue(22): " + map.containsValue(22));

        // 4) Removing
        System.out.println("\n== Removing ==");
        map.remove("Charlie");
        System.out.println("after remove(\"Charlie\"): " + map);
        map.remove("Alice", 99); // won't remove (wrong value)
        map.remove("Alice", 26); // correct value, removed
        System.out.println("after conditional remove: " + map);

        // 5) Iteration
        System.out.println("\n== Iteration ==");
        System.out.println("keys:");
        for (String key : map.keySet()) {
            System.out.println("  " + key);
        }
        System.out.println("values:");
        for (Integer val : map.values()) {
            System.out.println("  " + val);
        }
        System.out.println("entries:");
        for (Map.Entry<String,Integer> e : map.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }

        // 6) Bulk & Defaults
        System.out.println("\n== Bulk & Defaults ==");
        System.out.println("isEmpty(): " + map.isEmpty());
        System.out.println("size(): " + map.size());
        map.merge("Bob", 5, Integer::sum); // Bob=30+5=35
        System.out.println("after merge Bob+5: " + map);
        map.compute("b", (k,v) -> (v==null)?100:v+10); // compute new value
        System.out.println("after compute on key 'b': " + map);
        map.computeIfAbsent("Eve", k -> 50);
        System.out.println("after computeIfAbsent(Eve,50): " + map);
        map.computeIfPresent("Eve", (k,v) -> v+5);
        System.out.println("after computeIfPresent(Eve+5): " + map);
        map.replace("Eve", 100); // unconditional replace
        System.out.println("after replace(Eve,100): " + map);
        map.replace("Eve", 100, 200); // conditional replace
        System.out.println("after conditional replace(Eve,100->200): " + map);

        // 7) Equality & Hashing
        System.out.println("\n== Equality & Hashing ==");
        Map<String,Integer> m1 = new HashMap<>(Map.of("x",1,"y",2));
        Map<String,Integer> m2 = new HashMap<>(Map.of("x",1,"y",2));
        Map<String,Integer> m3 = new HashMap<>(Map.of("y",2,"x",1));
        System.out.println("m1: " + m1);
        System.out.println("m2: " + m2);
        System.out.println("m3: " + m3);
        System.out.println("m1.equals(m2): " + m1.equals(m2)); // true
        System.out.println("m1.equals(m3): " + m1.equals(m3)); // true (order irrelevant)
        System.out.println("m1.hashCode(): " + m1.hashCode());

        // 8) Common Pattern: Frequency Counter
        System.out.println("\n== Common Pattern: Frequency Counter ==");
        int[] arr = {1,2,2,3,1,4,2};
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        System.out.println("frequency map: " + freq);

        // 9) Clear
        System.out.println("\n== Clear ==");
        map.clear();
        System.out.println("after clear(): " + map + ", isEmpty: " + map.isEmpty());
    }
}


