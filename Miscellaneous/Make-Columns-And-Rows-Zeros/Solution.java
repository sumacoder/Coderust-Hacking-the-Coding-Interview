import java.util.*;

/**
 * solution 2 use 2 set, so when do the make zero step no need to loop through
 * whole matrix, just each row and each column
 */
class Solution {
    static int[][] make_zeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[] { i, j });
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            changeToZero(matrix, list.get(i)[0], list.get(i)[1]);
        }
        return matrix;
    }

    static void changeToZero(int[][] matrix, int x, int y) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            matrix[x][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            matrix[i][y] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 45, 0, 81 }, { 6, 7, 2, 82, 8 },
                // {20, 22, 49, 5, 5},
                // {0, 23, 50, 4, 92}
        };
        make_zeroes(matrix);
        // for (int n : matrix[0]) {
        // System.out.println(n);
        // }

    }

}