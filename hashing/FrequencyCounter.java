package hashing;

import java.util.*;

public class FrequencyCounter {
    /**
     * Count frequency using HashMap
     * Time Complexity: O(N)
     * Space Complexity: O(N) for storing frequencies
     */
    public static void countWithMap(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequencies using HashMap:");
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    /**
     * Count frequency using an array (works if arr[i] is small and non-negative)
     */
    public static void countWithArray(int[] arr, int maxVal) {
        int[] freq = new int[maxVal + 1];
        for (int num : arr) {
            freq[num]++;
        }

        System.out.println("Frequencies using array:");
        for (int i = 0; i <= maxVal; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " -> " + freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            maxVal = Math.max(maxVal, arr[i]);
        }

        countWithMap(arr);
        System.out.println();
        countWithArray(arr, maxVal);
    }
}