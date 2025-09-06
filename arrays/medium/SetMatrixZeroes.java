package arrays.medium;

import java.util.Arrays;

public class SetMatrixZeroes {

    /**
     * Better Approach: Using Extra Arrays
     * This approach uses two extra arrays to keep track of which rows and columns
     * need to be zeroed out. This avoids the chain reaction problem of the naive approach.
     * Time: O(M * N) - We iterate through the matrix twice.
     * Space: O(M + N) - For the two arrays to store the state of rows and columns.
     */
    public static void setZeroesBetter(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowsToZero = new boolean[rows];
        boolean[] colsToZero = new boolean[cols];

        // First pass: find the original zeros and mark the rows/cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero[i] = true;
                    colsToZero[j] = true;
                }
            }
        }

        // Second pass: set the marked rows and columns to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowsToZero[i] || colsToZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /**
     * Optimal Approach: Using the Matrix Itself (O(1) Space)
     * This approach cleverly uses the first row and first column of the matrix
     * as memory to store which rows and columns need to be zeroed out.
     * Time: O(M * N) - We make two passes through the matrix.
     * Space: O(1) - We only use two boolean flags, not dependent on matrix size.
     */
    public static void setZeroesOptimal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Step 1: Check if the first row and first column have any zeros
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Step 2: Use the first row/col as markers for the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: Set the inner matrix to zero based on the markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Set the first row and column to zero if needed
        if (firstRowHasZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    // Quick demo
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Original Matrix 1:");
        printMatrix(matrix1);
        setZeroesOptimal(matrix1);
        System.out.println("Modified Matrix 1 (Optimal):");
        printMatrix(matrix1);

        System.out.println("---");
        
        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        System.out.println("Original Matrix 2:");
        printMatrix(matrix2);
        setZeroesBetter(matrix2);
        System.out.println("Modified Matrix 2 (Better):");
        printMatrix(matrix2);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}