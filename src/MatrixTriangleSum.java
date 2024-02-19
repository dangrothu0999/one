

import java.util.Scanner;
import java.util.stream.IntStream;

public class MatrixTriangleSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the matrix dimensions
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Input the matrix elements
        System.out.println("Enter the matrix elements:");
        int[][] matrix = IntStream.range(0, rows)
                .mapToObj(row -> IntStream.range(0, cols)
                        .map(col -> scanner.nextInt())
                        .toArray())
                .toArray(int[][]::new);

        // Calculate and print the sum of upper, lower, and diagonal triangles
        int upperTriangleSum = calculateUpperTriangleSum(matrix);
        int lowerTriangleSum = calculateLowerTriangleSum(matrix);
        int diagonalTriangleSum = calculateDiagonalTriangleSum(matrix);

        System.out.println("Sum of the upper triangle: " + upperTriangleSum);
        System.out.println("Sum of the lower triangle: " + lowerTriangleSum);
        System.out.println("Sum of the diagonal triangle: " + diagonalTriangleSum);

        scanner.close();
    }

    // Function to calculate the sum of the upper triangle of a matrix
     static int calculateUpperTriangleSum(int[][] matrix) {
       return IntStream.range(0, matrix.length)
                .flatMap(i -> IntStream.range(i, matrix[i].length))
                .map(i -> matrix[i / matrix.length][i % matrix.length])
                .sum();
    }

    // Function to calculate the sum of the lower triangle of a matrix
     static int calculateLowerTriangleSum(int[][] matrix) {
       return IntStream.range(0, matrix.length)
                .flatMap(i -> IntStream.range(0, i + 1))
                .map(i -> matrix[i / matrix.length][i % matrix.length])
                .sum();
    }

    // Function to calculate the sum of the diagonal triangle of a matrix
     static int calculateDiagonalTriangleSum(int[][] matrix) {
       return IntStream.range(0, Math.min(matrix.length, 3))
                .map(i -> 	matrix[i][i])
				.sum();
    }
}

