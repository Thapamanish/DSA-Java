package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Optimal Approach: Four Pointers (Boundary Simulation)
     * This approach simulates the spiral traversal by maintaining four boundary
     * pointers: top, bottom, left, and right. We traverse one layer of the
     * matrix at a time and then shrink the boundaries inward.
     * Time: O(M * N) - We visit each element exactly once.
     * Space: O(M * N) - To store the result list. O(1) if not counting the result.
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (across the top row)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // 2. Traverse Down (along the right column)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Shrink the right boundary in

            // 3. Traverse Left (across the bottom row)
            // Check if there's still a valid row to traverse
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // 4. Traverse Up (along the left column)
            // Check if there's still a valid column to traverse
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Shrink the left boundary in
            }
        }

        return result;
    }

    // Quick demo
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%-4d", val);
            }
            System.out.println();
        }

        List<Integer> spiralResult = spiralOrder(matrix);
        System.out.println("\nSpiral Order Traversal:");
        System.out.println(spiralResult);
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}