package arrays.easy;

public class SecondLargestElement {
    // Returns second largest distinct element in array.
    // Throws IllegalArgumentException if not found.
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements.");
        }

        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                // strictly smaller than largest but bigger than secondLargest
                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found.");
        }

        return secondLargest;
    }

    // Quick demo
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 20, 15};
        System.out.println("Second Largest: " + findSecondLargest(arr)); // prints 15
    }
}