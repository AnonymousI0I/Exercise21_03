package assignments.Exercise08_29;

import java.util.Scanner;

public class Exercise08_29 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create 3x3 matrices
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        // Input for matrix m1
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                m1[i][j] = input.nextInt();

        // Input for matrix m2
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                m2[i][j] = input.nextInt();

        // Display result
        System.out.println(equals(m1, m2) ? "The two arrays are identical" : "The two arrays are not identical");

        input.close();
    }

    /** Return true if the two arrays are identical */
    public static boolean equals(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }
}
