package collectionframework.queue;

import java.util.*;

/**
 * Queue & Deque & PriorityQueue – Everything Demo
 *
 * Sections:
 * 1) ArrayDeque as Queue (offer/poll/peek) + as Stack (push/pop/peek)
 * 2) LinkedList as Deque (addFirst/Last, pollFirst/Last, peekFirst/Last)
 * 3) PriorityQueue as Min-Heap and Max-Heap
 * 4) Iteration + safe removal with Iterator
 * 5) DSA Patterns:
 *    - BFS (graph)
 *    - Sliding window (fixed size) sum
 *    - Monotonic deque (max in each window)
 *    - Top-K using min-heap
 *    - Merge K sorted lists using min-heap
 */
public class QueueEverythingDemo {

    // Helper for Merge K Sorted Lists demo
    static final class Node {
        final int val;   // value
        final int li;    // list index
        final int idx;   // element index within that list
        Node(int val, int li, int idx) { this.val = val; this.li = li; this.idx = idx; }
        @Override public String toString() { return "(" + val + " from L" + li + "#" + idx + ")"; }
    }

    public static void main(String[] args) {
        // ------------------------------------------------------------
        // 1) ArrayDeque as Queue & Stack
        // ------------------------------------------------------------
        System.out.println("== 1) ArrayDeque (Queue & Stack) ==");
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(10); q.offer(20); q.offer(30);
        System.out.println("Queue after offers: " + q);       // [10, 20, 30]
        System.out.println("peek(): " + q.peek());             // 10
        System.out.println("poll(): " + q.poll());             // 10
        System.out.println("Queue now: " + q);                 // [20, 30]

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(1); st.push(2); st.push(3);                    // push=addFirst
        System.out.println("Stack after pushes(top first): " + st); // [3, 2, 1]
        System.out.println("stack peek(): " + st.peek());      // 3
        System.out.println("stack pop(): " + st.pop());        // 3
        System.out.println("Stack now: " + st);                // [2, 1]

        // ------------------------------------------------------------
        // 2) LinkedList as Deque
        // ------------------------------------------------------------
        System.out.println("\n== 2) LinkedList as Deque ==");
        Deque<String> d = new LinkedList<>();
        d.addFirst("b"); d.addLast("c"); d.addFirst("a");      // [a, b, c]
        System.out.println("Deque: " + d);
        System.out.println("peekFirst(): " + d.peekFirst());   // a
        System.out.println("peekLast(): " + d.peekLast());     // c
        System.out.println("pollLast(): " + d.pollLast());     // c -> [a, b]
        d.push("z");                                           // push = addFirst
        System.out.println("after push(z): " + d);             // [z, a, b]
        System.out.println("pop(): " + d.pop());               // z -> [a, b]

        // ------------------------------------------------------------
        // 3) PriorityQueue (Min-Heap and Max-Heap)
        // ------------------------------------------------------------
        System.out.println("\n== 3) PriorityQueue (Min & Max Heap) ==");
        PriorityQueue<Integer> minpq = new PriorityQueue<>(); // natural order -> min-heap
        minpq.offer(5); minpq.offer(1); minpq.offer(7); minpq.offer(3);
        System.out.println("Min-heap peek: " + minpq.peek()); // 1
        System.out.print("Min-heap ascending poll: ");
        while (!minpq.isEmpty()) System.out.print(minpq.poll() + " "); // 1 3 5 7
        System.out.println();

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
        maxpq.offer(5); maxpq.offer(1); maxpq.offer(7); maxpq.offer(3);
        System.out.println("Max-heap peek: " + maxpq.peek()); // 7
        System.out.print("Max-heap descending poll: ");
        while (!maxpq.isEmpty()) System.out.print(maxpq.poll() + " "); // 7 5 3 1
        System.out.println();

        // ------------------------------------------------------------
        // 4) Iteration & safe removal with Iterator
        // ------------------------------------------------------------
        System.out.println("\n== 4) Iteration & safe removal ==");
        Queue<Integer> qi = new ArrayDeque<>(List.of(1,2,3,4,5,6));
        Iterator<Integer> it = qi.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove(); // remove even numbers safely
        }
        System.out.println("After removing evens via iterator: " + qi); // [1,3,5]

        // ------------------------------------------------------------
        // 5) DSA Patterns
        // ------------------------------------------------------------
        System.out.println("\n== 5) DSA Patterns ==");

        // (a) BFS on an unweighted graph (adj list)
        System.out.println("-- BFS (graph) --");
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        addEdge(adj,0,1); addEdge(adj,0,2); addEdge(adj,1,3); addEdge(adj,2,4); addEdge(adj,3,5);
        System.out.println("BFS from 0: " + bfs(adj, 0)); // order example

        // (b) Sliding window (fixed size) sum
        System.out.println("-- Sliding Window Sum (k=3) --");
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println("Max sum of any size-3 window: " + maxFixedWindowSum(arr, 3));

        // (c) Monotonic deque: max in each window (O(n))
        System.out.println("-- Monotonic Deque Max in Window (k=3) --");
        System.out.println("Window maxes: " + Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

        // (d) Top-K using min-heap
        System.out.println("-- Top-K elements (k=3) via min-heap --");
        int[] tarr = {7, 10, 4, 3, 20, 15};
        System.out.println("Top 3: " + topK(tarr, 3));

        // (e) Merge K sorted lists using min-heap
        System.out.println("-- Merge K Sorted Lists --");
        List<List<Integer>> lists = List.of(
                List.of(1,4,7),
                List.of(2,5,8),
                List.of(3,6,9,12)
        );
        System.out.println("Merged: " + mergeKSortedLists(lists));

        System.out.println("\n== DONE ==");
    }

    // -------------------- helpers --------------------

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // BFS returns visitation order from src
    static List<Integer> bfs(List<List<Integer>> adj, int src) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();
        q.offer(src); vis[src] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : adj.get(u)) {
                if (!vis[v]) { vis[v] = true; q.offer(v); }
            }
        }
        return order;
    }

    // Sliding window: max sum of any size-k window
    static int maxFixedWindowSum(int[] a, int k) {
        int n = a.length, sum = 0, best = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (i >= k) sum -= a[i - k];
            if (i >= k - 1) best = Math.max(best, sum);
        }
        return best;
    }

    // Monotonic deque: max of every window of size k
    static int[] maxSlidingWindow(int[] a, int k) {
        if (k <= 0 || a.length == 0) return new int[0];
        int n = a.length, outSize = n - k + 1, oi = 0;
        int[] res = new int[outSize];
        Deque<Integer> dq = new ArrayDeque<>(); // store indices, values decreasing

        for (int i = 0; i < n; i++) {
            // 1) drop out-of-window indices
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            // 2) maintain decreasing values
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) dq.pollLast();
            dq.offerLast(i);
            // 3) record answer once first window formed
            if (i >= k - 1) res[oi++] = a[dq.peekFirst()];
        }
        return res;
    }

    // Top-K using size-k min-heap
    static List<Integer> topK(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
        for (int x : a) {
            pq.offer(x);
            if (pq.size() > k) pq.poll();
        }
        // pq now holds top-k in ascending order; extract descending for readability
        List<Integer> ans = new ArrayList<>(pq);
        ans.sort(Comparator.reverseOrder());
        return ans;
    }

    // Merge K sorted lists using min-heap
    static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        // push head of each list
        for (int li = 0; li < lists.size(); li++) {
            if (!lists.get(li).isEmpty()) {
                pq.offer(new Node(lists.get(li).get(0), li, 0));
            }
        }
        List<Integer> merged = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node nd = pq.poll();
            merged.add(nd.val);
            int nextIdx = nd.idx + 1;
            if (nextIdx < lists.get(nd.li).size()) {
                pq.offer(new Node(lists.get(nd.li).get(nextIdx), nd.li, nextIdx));
            }
        }
        return merged;
    }
}