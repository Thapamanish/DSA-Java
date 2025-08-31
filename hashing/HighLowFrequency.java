package hashing;

import java.util.*;

public class HighLowFrequency {
    /**
     * Find highest and lowest frequency elements
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static void findHighLowFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int maxElem = -1, minElem = -1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int elem = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                maxElem = elem;
            }
            if (count < minFreq) {
                minFreq = count;
                minElem = elem;
            }
        }

        System.out.println("Highest frequency element: " + maxElem + " -> " + maxFreq);
        System.out.println("Lowest frequency element: " + minElem + " -> " + minFreq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findHighLowFrequency(arr);
    }
}