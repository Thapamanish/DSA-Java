package collectionframework.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapEverythingDemo {

    // Helper model to show correct equals/hashCode for using custom keys in hash-based maps
    static final class Key {
        final int id;
        final String name;
        Key(int id, String name) { this.id = id; this.name = name; }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key k = (Key) o;
            return id == k.id && Objects.equals(name, k.name);
        }
        @Override public int hashCode() { return Objects.hash(id, name); }
        @Override public String toString() { return "Key(" + id + "," + name + ")"; }
    }

    public static void main(String[] args) {
        // ------------------------------------------------------------
        // 1) Creation
        // ------------------------------------------------------------
        System.out.println("== 1) Creation ==");
        Map<String, Integer> hmap = new HashMap<>();
        Map<String, Integer> lhmap = new LinkedHashMap<>(); // insertion-ordered (by default)
        Map<String, Integer> tmap = new TreeMap<>();        // sorted by key

        // copy from other map
        Map<String, Integer> copy = new HashMap<>(Map.of("a", 1, "b", 2));
        System.out.println("copy: " + copy);

        // ------------------------------------------------------------
        // 2) put / putIfAbsent / putAll
        // ------------------------------------------------------------
        System.out.println("\n== 2) put / putIfAbsent / putAll ==");
        hmap.put("x", 10);
        hmap.put("y", 20);
        hmap.put("x", 99); // update
        System.out.println("HashMap after puts: " + hmap);

        hmap.putIfAbsent("y", 200); // key exists -> no change
        hmap.putIfAbsent("z", 30);
        System.out.println("putIfAbsent(y,z): " + hmap);

        lhmap.putAll(hmap);
        System.out.println("LinkedHashMap after putAll(hmap): " + lhmap);

        // ------------------------------------------------------------
        // 3) get / getOrDefault / contains
        // ------------------------------------------------------------
        System.out.println("\n== 3) get / getOrDefault / contains ==");
        System.out.println("hmap.get(\"x\"): " + hmap.get("x"));
        System.out.println("hmap.getOrDefault(\"nope\", -1): " + hmap.getOrDefault("nope", -1));
        System.out.println("containsKey(\"y\"): " + hmap.containsKey("y"));
        System.out.println("containsValue(99): " + hmap.containsValue(99));

        // ------------------------------------------------------------
        // 4) remove / remove(key,val) / clear
        // ------------------------------------------------------------
        System.out.println("\n== 4) remove / remove(key,val) / clear ==");
        System.out.println("remove(\"z\"): " + hmap.remove("z")); // returns old val or null
        System.out.println("remove(\"x\", 100) -> " + hmap.remove("x", 100));
        System.out.println("remove(\"x\", 99) -> " + hmap.remove("x", 99));
        System.out.println("hmap now: " + hmap);

        // ------------------------------------------------------------
        // 5) Iteration patterns
        // ------------------------------------------------------------
        System.out.println("\n== 5) Iteration patterns ==");
        System.out.print("keys: ");
        for (String k : lhmap.keySet()) System.out.print(k + " ");
        System.out.println();

        System.out.print("values: ");
        for (int v : lhmap.values()) System.out.print(v + " ");
        System.out.println();

        System.out.println("entries:");
        for (Map.Entry<String,Integer> e : lhmap.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }

        // safe removal while iterating entries
        Map<String,Integer> iterDemo = new HashMap<>(Map.of("a",1,"b",2,"c",3,"d",4));
        for (Iterator<Map.Entry<String,Integer>> it = iterDemo.entrySet().iterator(); it.hasNext();) {
            if (it.next().getValue() % 2 == 0) it.remove(); // remove even values
        }
        System.out.println("iterator.remove (removed evens): " + iterDemo);

        // ------------------------------------------------------------
        // 6) Defaulting & bulk updates: merge / compute / replace*
        // ------------------------------------------------------------
        System.out.println("\n== 6) merge / compute / replace* ==");
        Map<String,Integer> scores = new HashMap<>();
        scores.merge("alice", 10, Integer::sum); // alice -> 10
        scores.merge("alice", 5, Integer::sum);  // alice -> 15
        System.out.println("merge sum: " + scores);

        scores.compute("bob", (k,v) -> v == null ? 1 : v + 1); // bob -> 1
        scores.computeIfAbsent("carol", k -> 100); // carol -> 100
        scores.computeIfPresent("carol", (k,v) -> v + 23); // carol -> 123
        System.out.println("compute* : " + scores);

        scores.replace("carol", 123, 111); // conditional replace
        scores.replace("bob", 9);          // replace if present
        scores.replaceAll((k,v) -> v * 2);
        System.out.println("replace* : " + scores);

        // ------------------------------------------------------------
        // 7) LinkedHashMap access-order (LRU pattern)
        // ------------------------------------------------------------
        System.out.println("\n== 7) LinkedHashMap access-order (LRU) ==");
        // third boolean 'true' => access-order
        LinkedHashMap<Integer, Integer> lru = new LinkedHashMap<>(4, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > 3; // cap at 3 entries
            }
        };
        lru.put(1, 11); lru.put(2, 22); lru.put(3, 33);
        System.out.println("LRU initial: " + lru);
        lru.get(1); // access key 1 -> becomes most-recent
        lru.put(4, 44); // capacity exceeded -> evict eldest (key 2)
        System.out.println("LRU after access(1) + put(4): " + lru);

        // ------------------------------------------------------------
        // 8) TreeMap basics + NavigableMap operations
        // ------------------------------------------------------------
        System.out.println("\n== 8) TreeMap + NavigableMap ==");
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(10, "ten"); tm.put(30, "thirty"); tm.put(20, "twenty"); tm.put(40, "forty");
        System.out.println("TreeMap: " + tm); // keys sorted

        System.out.println("firstKey: " + tm.firstKey() + ", lastKey: " + tm.lastKey());
        System.out.println("ceilingKey(25): " + tm.ceilingKey(25));
        System.out.println("floorKey(25):   " + tm.floorKey(25));
        System.out.println("higherKey(20):  " + tm.higherKey(20));
        System.out.println("lowerKey(20):   " + tm.lowerKey(20));
        System.out.println("headMap(30):    " + tm.headMap(30));          // < 30
        System.out.println("headMap(30,true): " + tm.headMap(30, true));  // ≤ 30
        System.out.println("tailMap(20):    " + tm.tailMap(20));          // ≥ 20
        System.out.println("tailMap(20,false): " + tm.tailMap(20, false));// > 20
        System.out.println("subMap(15,true,35,false): " + tm.subMap(15, true, 35, false));
        System.out.println("descendingMap(): " + tm.descendingMap());

        // ------------------------------------------------------------
        // 9) Null handling
        // ------------------------------------------------------------
        System.out.println("\n== 9) Null handling ==");
        Map<String,Integer> hmNull = new HashMap<>();
        hmNull.put(null, 1);      // HashMap allows one null key
        hmNull.put("ok", null);   // and multiple null values
        System.out.println("HashMap nulls: " + hmNull);

        try {
            TreeMap<String,Integer> tmNull = new TreeMap<>();
            // tmNull.put(null, 5); // would throw NullPointerException
            tmNull.put("a", 10);
            System.out.println("TreeMap (no null keys): " + tmNull);
        } catch (NullPointerException npe) {
            System.out.println("TreeMap cannot accept null keys: " + npe.getMessage());
        }

        // ------------------------------------------------------------
        // 10) Custom keys in hash-based maps (equals/hashCode)
        // ------------------------------------------------------------
        System.out.println("\n== 10) Custom keys (equals/hashCode) ==");
        Map<Key, String> keyMap = new HashMap<>();
        keyMap.put(new Key(1, "A"), "first");
        keyMap.put(new Key(1, "A"), "duplicateValue"); // replaces previous due to equal key
        keyMap.put(new Key(2, "B"), "second");
        System.out.println("HashMap with custom Key: " + keyMap);

        // ------------------------------------------------------------
        // 11) Sorting entries (by key or value)
        // ------------------------------------------------------------
        System.out.println("\n== 11) Sorting entries ==");
        Map<String,Integer> unsorted = Map.of("c",3,"a",1,"b",2);
        // by key (TreeMap easiest)
        Map<String,Integer> byKey = new TreeMap<>(unsorted);
        System.out.println("Sorted by key (TreeMap): " + byKey);

        // by value (create list of entries, sort, then collect)
        List<Map.Entry<String,Integer>> entries = new ArrayList<>(unsorted.entrySet());
        entries.sort(Comparator.comparingInt(Map.Entry::getValue).reversed());
        Map<String,Integer> byValueDesc = entries.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (a,b)->a, LinkedHashMap::new));
        System.out.println("Sorted by value desc: " + byValueDesc);

        // ------------------------------------------------------------
        // 12) Convert map <-> lists
        // ------------------------------------------------------------
        System.out.println("\n== 12) Convert map <-> lists ==");
        List<String> keys = new ArrayList<>(byKey.keySet());
        List<Integer> vals = new ArrayList<>(byKey.values());
        System.out.println("keys: " + keys);
        System.out.println("values: " + vals);

        // ------------------------------------------------------------
        // 13) Classic patterns (DSA)
        // ------------------------------------------------------------
        System.out.println("\n== 13) DSA patterns ==");
        // (a) Frequency counter
        int[] arr = {1,2,2,3,3,3,4};
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);
        System.out.println("Frequency: " + freq);

        // (b) Two-sum (index pair)
        int[] nums = {2,7,11,15};
        int target = 9;
        Map<Integer,Integer> seen = new HashMap<>();
        int[] ans = {-1,-1};
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) { ans = new int[]{seen.get(need), i}; break; }
            seen.put(nums[i], i);
        }
        System.out.println("Two-sum indices: " + Arrays.toString(ans));

        // ------------------------------------------------------------
        // 14) equals / hashCode semantics for maps
        // ------------------------------------------------------------
        System.out.println("\n== 14) equals / hashCode for maps ==");
        Map<String,Integer> m1 = new HashMap<>(Map.of("a",1,"b",2));
        Map<String,Integer> m2 = new LinkedHashMap<>(Map.of("b",2,"a",1)); // different order
        System.out.println("m1.equals(m2): " + m1.equals(m2)); // true (order doesn't matter)
        System.out.println("m1.hashCode()==m2.hashCode(): " + (m1.hashCode()==m2.hashCode()));

        System.out.println("\n== DONE ==");
    }
}