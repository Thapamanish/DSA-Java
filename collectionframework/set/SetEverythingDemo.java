package collectionframework.set;

import java.util.*;

public class SetEverythingDemo {

    // Helper model to show equals/hashCode impact in sets
    static final class Point {
        final int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        // Proper equals & hashCode => HashSet treats duplicates correctly
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        @Override public int hashCode() { return Objects.hash(x, y); }
        @Override public String toString() { return "(" + x + "," + y + ")"; }
    }

    public static void main(String[] args) {
        // ------------------------------------------------------------
        // 1) Creation
        // ------------------------------------------------------------
        System.out.println("== 1) Creation ==");
        Set<Integer> hs = new HashSet<>();            // no order
        Set<Integer> lhs = new LinkedHashSet<>();     // insertion order
        Set<Integer> ts = new TreeSet<>();            // sorted (natural order)

        // ------------------------------------------------------------
        // 2) Adding & duplicates (duplicates are ignored)
        // ------------------------------------------------------------
        System.out.println("\n== 2) Add & Duplicates ==");
        hs.addAll(Arrays.asList(3, 1, 2, 2, 3, 4));
        lhs.addAll(Arrays.asList(3, 1, 2, 2, 3, 4));
        ts.addAll(Arrays.asList(3, 1, 2, 2, 3, 4));
        System.out.println("HashSet:        " + hs);
        System.out.println("LinkedHashSet:  " + lhs + "  (insertion order preserved)");
        System.out.println("TreeSet:        " + ts + "  (sorted)");

        // ------------------------------------------------------------
        // 3) Membership, size, remove
        // ------------------------------------------------------------
        System.out.println("\n== 3) Basic Ops ==");
        System.out.println("hs.contains(2): " + hs.contains(2));
        System.out.println("hs.size():      " + hs.size());
        System.out.println("hs.remove(3):   " + hs.remove(3));
        System.out.println("hs after remove:" + hs);

        // ------------------------------------------------------------
        // 4) Iteration patterns (for-each, iterator.remove)
        // ------------------------------------------------------------
        System.out.println("\n== 4) Iteration ==");
        System.out.print("for-each lhs: ");
        for (int x : lhs) System.out.print(x + " ");
        System.out.println();

        // safe removal during iteration
        Set<Integer> iterDemo = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        for (Iterator<Integer> it = iterDemo.iterator(); it.hasNext();) {
            if (it.next() % 2 == 0) it.remove(); // remove evens
        }
        System.out.println("iterator.remove -> removed evens: " + iterDemo);

        // ------------------------------------------------------------
        // 5) Bulk operations: union, intersection, difference
        // ------------------------------------------------------------
        System.out.println("\n== 5) Bulk Ops ==");
        Set<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> B = new HashSet<>(Arrays.asList(2, 3, 4));

        Set<Integer> union = new HashSet<>(A);
        union.addAll(B); // A ∪ B
        System.out.println("Union (A∪B): " + union);

        Set<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B); // A ∩ B
        System.out.println("Intersection (A∩B): " + intersection);

        Set<Integer> diff = new HashSet<>(A);
        diff.removeAll(B); // A − B
        System.out.println("Difference (A−B): " + diff);

        // ------------------------------------------------------------
        // 6) Conversions & sorting
        // ------------------------------------------------------------
        System.out.println("\n== 6) Convert & Sort ==");
        List<Integer> listFromSet = new ArrayList<>(lhs);
        Collections.sort(listFromSet); // sort a list copy
        System.out.println("List from LinkedHashSet sorted: " + listFromSet);

        // For always-sorted view, prefer TreeSet:
        Set<Integer> sorted = new TreeSet<>(lhs);
        System.out.println("TreeSet from LinkedHashSet:     " + sorted);

        // ------------------------------------------------------------
        // 7) TreeSet: custom Comparator and NavigableSet goodies
        // ------------------------------------------------------------
        System.out.println("\n== 7) TreeSet & NavigableSet ==");
        // Custom order: descending
        NavigableSet<Integer> desc = new TreeSet<>(Comparator.reverseOrder());
        desc.addAll(Arrays.asList(10, 5, 7, 7, 12));
        System.out.println("TreeSet (desc): " + desc);

        NavigableSet<Integer> nav = new TreeSet<>(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println("nav: " + nav);
        System.out.println("first: " + nav.first() + ", last: " + nav.last());
        System.out.println("ceiling(5): " + nav.ceiling(5)); // ≥ 5
        System.out.println("floor(5):   " + nav.floor(5));   // ≤ 5
        System.out.println("higher(6):  " + nav.higher(6));  // > 6
        System.out.println("lower(6):   " + nav.lower(6));   // < 6
        System.out.println("headSet(6): " + nav.headSet(6)); // < 6
        System.out.println("tailSet(6): " + nav.tailSet(6)); // ≥ 6
        System.out.println("subSet(4,10): " + nav.subSet(4, 10)); // [4,10)

        System.out.println("descendingSet(): " + nav.descendingSet());

        // ------------------------------------------------------------
        // 8) Nulls
        // ------------------------------------------------------------
        System.out.println("\n== 8) Nulls ==");
        Set<String> canHaveNull = new HashSet<>();
        canHaveNull.add(null); // HashSet/LinkedHashSet allow one null
        canHaveNull.add("hi");
        System.out.println("HashSet with null: " + canHaveNull);

        // TreeSet does NOT allow null (throws NPE). Demonstrate safely:
        Set<String> noNullsInTree = new TreeSet<>();
        try {
            // Uncomment to see it fail:
            // noNullsInTree.add(null); // will throw NullPointerException
            noNullsInTree.add("a");
            noNullsInTree.add("b");
        } catch (NullPointerException npe) {
            System.out.println("TreeSet cannot accept null: " + npe.getMessage());
        }
        System.out.println("TreeSet (strings): " + noNullsInTree);

        // ------------------------------------------------------------
        // 9) Custom objects + equals/hashCode
        // ------------------------------------------------------------
        System.out.println("\n== 9) Custom Objects & Hashing ==");
        Set<Point> pts = new HashSet<>();
        pts.add(new Point(1, 2));
        pts.add(new Point(1, 2)); // duplicate by value
        pts.add(new Point(2, 2));
        System.out.println("HashSet<Point> (duplicates collapsed): " + pts);

        // ------------------------------------------------------------
        // 10) Clear & isEmpty
        // ------------------------------------------------------------
        System.out.println("\n== 10) Clear & isEmpty ==");
        hs.clear();
        System.out.println("hs.isEmpty(): " + hs.isEmpty());

        System.out.println("\n== DONE ==");
    }
}