package collectionframework.list ;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 1) Creation
        System.out.println("== Creation ==");
        List<Integer> list = new ArrayList<>();                 // empty
        List<Integer> listWithCap = new ArrayList<>(10);        // with initial capacity
        List<Integer> copy = new ArrayList<>(Arrays.asList(1, 2, 3)); // copy from collection
        System.out.println("empty list: " + list);
        System.out.println("listWithCap: " + listWithCap + " (capacity hint only)");
        System.out.println("copy: " + copy);

        // 2) Adding Elements
        System.out.println("\n== Adding Elements ==");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 15); // insert at index and shifts other to the right
        System.out.println("after add/add(index,e): " + list);

        // 3) Accessing Elements
        System.out.println("\n== Accessing Elements ==");
        int first = list.get(0);
        System.out.println("get(0): " + first);
        list.set(0, 99);  // replaces the element
        System.out.println("after set(0,99): " + list);

        // 4) Removing Elements
        System.out.println("\n== Removing Elements ==");
        list.remove(1); // remove by index
        System.out.println("after remove index 1: " + list);
        list.remove(Integer.valueOf(30)); // remove by value (first occurrence)
        System.out.println("after remove value 30: " + list);
        // (not calling clear() yet so we can use data later)

        // 5) Searching
        System.out.println("\n== Searching ==");
        System.out.println("contains(20): " + list.contains(20));
        System.out.println("indexOf(20): " + list.indexOf(20));
        System.out.println("lastIndexOf(20): " + list.lastIndexOf(20));

        // 6) Size & Capacity
        System.out.println("\n== Size & Capacity ==");
        System.out.println("size(): " + list.size());
        System.out.println("isEmpty(): " + list.isEmpty());
        // Capacity helpers require ArrayList reference
        ArrayList<Integer> backing = new ArrayList<>(list);
        backing.ensureCapacity(100); // grow internal capacity (no visible effect in print)
        backing.trimToSize();        // shrink capacity to size
        System.out.println("ensureCapacity(100) & trimToSize() done on copy: " + backing);

        // 7) Conversion
        System.out.println("\n== Conversion ==");
        Object[] asObjects = list.toArray();
        System.out.println("toArray() -> Object[]: " + Arrays.toString(asObjects));
        Integer[] asIntegers = list.toArray(new Integer[0]);
        System.out.println("toArray(new Integer[0]) -> Integer[]: " + Arrays.toString(asIntegers));

        // 8) Iteration
        System.out.println("\n== Iteration ==");
        System.out.print("for-i: ");
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
        System.out.print("for-each: ");
        for (int x : list) System.out.print(x + " ");
        System.out.println();
        System.out.print("iterator: ");
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) System.out.print(it.next() + " ");
        System.out.println();

        // 9) Bulk Operations
        System.out.println("\n== Bulk Operations ==");
        List<Integer> other = new ArrayList<>(Arrays.asList(20, 50, 60));
        List<Integer> working = new ArrayList<>(list);
        working.addAll(other);
        System.out.println("addAll(other): " + working);
        List<Integer> removed = new ArrayList<>(working);
        removed.removeAll(Arrays.asList(50, 99));
        System.out.println("removeAll([50,99]): " + removed);
        List<Integer> retained = new ArrayList<>(working);
        retained.retainAll(Arrays.asList(20, 15));
        System.out.println("retainAll([20,15]): " + retained);
        System.out.println("containsAll([20,15]) on working: " + working.containsAll(Arrays.asList(20, 15)));

        // 10) Sorting & Shuffling
        System.out.println("\n== Sorting & Shuffling ==");
        List<Integer> sortable = new ArrayList<>(Arrays.asList(5, 2, 9, 2, 7));
        System.out.println("original: " + sortable);
        Collections.sort(sortable);
        System.out.println("Collections.sort (asc): " + sortable);
        Collections.sort(sortable, Collections.reverseOrder());
        System.out.println("reverseOrder sort (desc): " + sortable);
        Collections.shuffle(sortable);
        System.out.println("Collections.shuffle: " + sortable);

        // 11) SubList
        System.out.println("\n== subList (backed view) ==");
        List<Integer> base = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("base: " + base);
        List<Integer> view = base.subList(1, 4); // [20,30,40]
        System.out.println("subList(1,4): " + view);
        view.set(0, 21); // modifies both view and base
        System.out.println("after view.set(0,21) -> view: " + view);
        System.out.println("after view.set(0,21) -> base: " + base);

        // 12) Misc: equals & hashCode
        System.out.println("\n== equals & hashCode ==");
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> c = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("a.equals(b): " + a.equals(b)); // true
        System.out.println("a.equals(c): " + a.equals(c)); // false (order matters)
        System.out.println("a.hashCode(): " + a.hashCode());
        System.out.println("b.hashCode(): " + b.hashCode());
        System.out.println("c.hashCode(): " + c.hashCode());

        // Final: clear()
        System.out.println("\n== clear() ==");
        list.clear();
        System.out.println("after clear(): " + list + ", isEmpty: " + list.isEmpty());
    }
}
