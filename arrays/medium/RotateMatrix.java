package arrays.medium;

import java.util.Arrays;

public class RotateMatrix {

    /**
     * Brute Force Approach: Using a New Matrix
     * This approach creates a new matrix and fills it by calculating the new
     * position for each element from the original matrix.
     * Time: O(N^2) - We must iterate through every cell.
     * Space: O(N^2) - We need an entirely new matrix to store the result.
     */
    public static int[][] rotateBruteForce(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // The key formula: new_pos(j, n-1-i) = old_pos(i, j)
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    /**
     * Optimal Approach: In-Place Rotation
     * This clever approach rotates the matrix without using extra space. It's
     * done in two steps:
     * 1. Transpose the matrix (swap elements across the diagonal).
     * 2. Reverse each row.
     * Time: O(N^2) - We iterate through the cells for transpose + reverse.
     * Space: O(1) - The rotation is done in-place.
     */
    public static void rotateOptimal(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            // We only need to go up to i to avoid swapping back
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Quick demo
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix1);

        int[][] rotatedMatrix = rotateBruteForce(matrix1);
        System.out.println("\nRotated Matrix (Brute Force):");
        printMatrix(rotatedMatrix);

        // Reset matrix for optimal solution demonstration
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotateOptimal(matrix2);
        System.out.println("\nRotated Matrix (Optimal In-Place):");
        printMatrix(matrix2);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}