import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] b = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];

        System.out.println("Matrix A:");
        printMatrix(a);

        System.out.println("Matrix B:");
        printMatrix(b);

        // Matrix addition
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Sum of Matrix A and B:");
        printMatrix(sum);

        // Transpose of Matrix A
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = a[i][j];
            }
        }

        System.out.println("Transpose of Matrix A:");
        printMatrix(transpose);

        scanner.close();
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}