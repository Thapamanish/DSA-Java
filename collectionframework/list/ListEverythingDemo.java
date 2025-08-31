package collectionframework.list;

import java.util.*;
import java.util.stream.Collectors;

public class ListEverythingDemo {
    public static void main(String[] args) {
        // --------------------------------------------
        // 1) Creation
        // --------------------------------------------
        System.out.println("== 1) Creation ==");

        List<Integer> empty = new ArrayList<>();                         // empty
        List<Integer> withCap = new ArrayList<>(8);                      // capacity hint
        List<Integer> fromCollection = new ArrayList<>(Arrays.asList(1, 2, 3)); // copy of collection

        // Arrays.asList is fixed-size list -> wrap in new ArrayList to make it resizable
        List<Integer> fromArraysAsList = new ArrayList<>(Arrays.asList(10, 20, 30));

        // List.of is immutable -> wrap in new ArrayList for mutability
        List<Integer> fromListOf = new ArrayList<>(List.of(7, 8, 9));

        System.out.println("empty: " + empty);
        System.out.println("withCap (capacity hint only): " + withCap);
        System.out.println("fromCollection: " + fromCollection);
        System.out.println("fromArraysAsList: " + fromArraysAsList);
        System.out.println("fromListOf: " + fromListOf);

        // --------------------------------------------
        // 2) Adding Elements
        // --------------------------------------------
        System.out.println("\n== 2) Adding Elements ==");
        List<Integer> list = new ArrayList<>();
        list.add(10);               // append
        list.add(20);
        list.add(30);
        list.add(1, 15);            // insert at index (shifts right)
        System.out.println("after add & add(index,e): " + list);

        // addAll (append) and addAll(index, coll)
        list.addAll(Arrays.asList(40, 50));
        System.out.println("after addAll([40,50]): " + list);
        list.addAll(2, Arrays.asList(11, 12));
        System.out.println("after addAll(index=2, [11,12]): " + list);

        // --------------------------------------------
        // 3) Access / Update
        // --------------------------------------------
        System.out.println("\n== 3) Access / Update ==");
        System.out.println("get(0): " + list.get(0));
        list.set(0, 99);
        System.out.println("after set(0,99): " + list);

        // --------------------------------------------
        // 4) Removing Elements
        // --------------------------------------------
        System.out.println("\n== 4) Removing Elements ==");
        // remove by index
        Integer removedByIndex = list.remove(1);
        System.out.println("remove(1) -> " + removedByIndex + ", list: " + list);

        // remove by value (be explicit to avoid int vs Integer ambiguity)
        boolean removedVal = list.remove(Integer.valueOf(30));
        System.out.println("remove(Integer.valueOf(30)) -> " + removedVal + ", list: " + list);

        // removeIf (predicate)
        list.removeIf(x -> x < 12); // remove < 12
        System.out.println("removeIf(x < 12): " + list);

        // --------------------------------------------
        // 5) Searching
        // --------------------------------------------
        System.out.println("\n== 5) Searching ==");
        System.out.println("contains(20): " + list.contains(20));
        System.out.println("indexOf(20): " + list.indexOf(20));
        System.out.println("lastIndexOf(20): " + list.lastIndexOf(20));
        System.out.println("containsAll([15, 20]): " + list.containsAll(Arrays.asList(15, 20)));

        // --------------------------------------------
        // 6) Size & Capacity
        // --------------------------------------------
        System.out.println("\n== 6) Size & Capacity ==");
        System.out.println("size(): " + list.size() + ", isEmpty(): " + list.isEmpty());
        ArrayList<Integer> capacityDemo = new ArrayList<>(list);
        capacityDemo.ensureCapacity(100); // (no visible change in printing)
        capacityDemo.trimToSize();
        System.out.println("ensureCapacity(100) & trimToSize() done on copy: " + capacityDemo);

        // --------------------------------------------
        // 7) Conversion
        // --------------------------------------------
        System.out.println("\n== 7) Conversion ==");
        Object[] objArr = list.toArray();
        System.out.println("toArray() -> Object[]: " + Arrays.toString(objArr));
        Integer[] intArr = list.toArray(new Integer[0]);
        System.out.println("toArray(new Integer[0]) -> Integer[]: " + Arrays.toString(intArr));

        // --------------------------------------------
        // 8) Iteration patterns
        // --------------------------------------------
        System.out.println("\n== 8) Iteration ==");
        System.out.print("for-i: ");
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.println();

        System.out.print("for-each: ");
        for (int x : list) System.out.print(x + " ");
        System.out.println();

        System.out.print("iterator: ");
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Integer x = it.next();
            System.out.print(x + " ");
        }
        System.out.println();

        // Iterator remove example (remove all 20s safely during iteration)
        List<Integer> iterRemoveDemo = new ArrayList<>(Arrays.asList(20, 15, 20, 50));
        for (Iterator<Integer> it = iterRemoveDemo.iterator(); it.hasNext();) {
            if (Objects.equals(it.next(), 20)) it.remove();
        }
        System.out.println("iterator.remove() -> removed all 20s: " + iterRemoveDemo);

        // ListIterator (bi-directional + set)
        List<Integer> liDemo = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListIterator<Integer> lit = liDemo.listIterator();
        while (lit.hasNext()) {
            int idx = lit.nextIndex();
            int val = lit.next();
            lit.set(val * 10); // replace current
            System.out.println("ListIterator set at index " + idx + " -> " + liDemo);
        }
        // Walk backward
        System.out.print("ListIterator backward: ");
        while (lit.hasPrevious()) System.out.print(lit.previous() + " ");
        System.out.println();

        // --------------------------------------------
        // 9) Bulk operations
        // --------------------------------------------
        System.out.println("\n== 9) Bulk Operations ==");
        List<Integer> base = new ArrayList<>(Arrays.asList(10, 15, 20, 50));
        List<Integer> other = Arrays.asList(20, 50, 60);
        List<Integer> working = new ArrayList<>(base);
        working.addAll(other);
        System.out.println("addAll(other): " + working);
        List<Integer> removed = new ArrayList<>(working);
        removed.removeAll(Arrays.asList(50, 99));
        System.out.println("removeAll([50,99]): " + removed);
        List<Integer> retained = new ArrayList<>(working);
        retained.retainAll(Arrays.asList(20, 15));
        System.out.println("retainAll([20,15]): " + retained);
        System.out.println("containsAll([20,15]) on working: " + working.containsAll(Arrays.asList(20, 15)));

        // --------------------------------------------
        // 10) Sorting, Shuffling, Utilities
        // --------------------------------------------
        System.out.println("\n== 10) Sorting, Shuffling, Utilities ==");
        List<Integer> sortable = new ArrayList<>(Arrays.asList(5, 2, 9, 2, 7, 4, 6));
        System.out.println("original: " + sortable);

        Collections.sort(sortable); // ascending
        System.out.println("Collections.sort (asc): " + sortable);

        Collections.sort(sortable, Collections.reverseOrder()); // descending
        System.out.println("reverseOrder sort (desc): " + sortable);

        // Custom Comparator: even numbers first, then ascending
        Collections.sort(sortable, (a, b) -> {
            int pa = a % 2, pb = b % 2;
            if (pa != pb) return Integer.compare(pa, pb); // even(0) before odd(1)
            return Integer.compare(a, b);
        });
        System.out.println("custom comparator (even first, asc): " + sortable);

        Collections.shuffle(sortable);
        System.out.println("Collections.shuffle: " + sortable);

        // swap
        if (sortable.size() >= 2) {
            Collections.swap(sortable, 0, sortable.size() - 1);
            System.out.println("Collections.swap(first,last): " + sortable);
        }

        // fill (replace all)
        List<Integer> fillDemo = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Collections.fill(fillDemo, 42);
        System.out.println("Collections.fill(42): " + fillDemo);

        // copy (dest must have size >= src.size())
        List<Integer> src = Arrays.asList(9, 9, 9);
        List<Integer> dest = new ArrayList<>(Arrays.asList(0, 0, 0, 0)); // size 4 >= 3
        Collections.copy(dest, src);
        System.out.println("Collections.copy(dest, src): " + dest);

        // min/max/frequency
        List<Integer> mmf = Arrays.asList(3, 1, 2, 2, 5, 2);
        System.out.println("min: " + Collections.min(mmf) + ", max: " + Collections.max(mmf));
        System.out.println("frequency of 2: " + Collections.frequency(mmf, 2));

        // binarySearch (list must be sorted in the same order as the comparator)
        List<Integer> bin = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 5, 8));
        int pos = Collections.binarySearch(bin, 3);
        System.out.println("binarySearch([1,2,2,3,5,8], 3) -> index " + pos);

        // --------------------------------------------
        // 11) SubList (backed view)
        // --------------------------------------------
        System.out.println("\n== 11) subList (backed view) ==");
        List<Integer> subBase = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        List<Integer> view = subBase.subList(1, 4); // [20,30,40]
        System.out.println("base: " + subBase);
        System.out.println("view subList(1,4): " + view);
        view.set(0, 21); // reflects in both
        System.out.println("after view.set(0,21) -> view: " + view);
        System.out.println("after view.set(0,21) -> base: " + subBase);

        // Avoid structural modifications on base while view exists (can throw ConcurrentModificationException)

        // --------------------------------------------
        // 12) Equality & Hashing
        // --------------------------------------------
        System.out.println("\n== 12) equals & hashCode ==");
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> c = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println("a.equals(b): " + a.equals(b)); // true
        System.out.println("a.equals(c): " + a.equals(c)); // false (order matters)
        System.out.println("a.hashCode(): " + a.hashCode());

        // --------------------------------------------
        // 13) Streams (map/filter/collect/etc.)
        // --------------------------------------------
        System.out.println("\n== 13) Streams ==");
        List<Integer> streamBase = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squared = streamBase.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("squared: " + squared);

        List<Integer> evens = streamBase.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("evens: " + evens);

        List<Integer> distinctSorted = Arrays.asList(5, 3, 3, 4, 1, 5).stream()
                .distinct().sorted().collect(Collectors.toList());
        System.out.println("distinct().sorted(): " + distinctSorted);

        // replaceAll (in-place transform)
        List<Integer> repl = new ArrayList<>(Arrays.asList(1, 2, 3));
        repl.replaceAll(x -> x * 10);
        System.out.println("replaceAll(x->x*10): " + repl);

        // forEach
        System.out.print("forEach print: ");
        repl.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // --------------------------------------------
        // 14) Spliterator & parallelStream
        // --------------------------------------------
        System.out.println("\n== 14) Spliterator & parallelStream ==");
        List<Integer> spList = Arrays.asList(1, 2, 3, 4, 5);
        Spliterator<Integer> sp = spList.spliterator();
        System.out.print("spliterator forEachRemaining: ");
        sp.forEachRemaining(x -> System.out.print(x + " "));
        System.out.println();

        System.out.print("parallelStream example (order not guaranteed): ");
        spList.parallelStream().forEach(x -> System.out.print(x + " "));
        System.out.println();

        // --------------------------------------------
        // 15) Final cleanup: clear
        // --------------------------------------------
        System.out.println("\n== 15) clear() ==");
        list.clear();
        System.out.println("after clear(): " + list + ", isEmpty: " + list.isEmpty());

        System.out.println("\n== DONE ==");
    }
}
