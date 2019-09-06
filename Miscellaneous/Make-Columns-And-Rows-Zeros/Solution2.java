/**
 * Runtime Complexity O(m.n) where m is number of rows and n is number of
 * columns.
 * 
 * Memory Complexity O(m + n).
 */
class makeZeros {
    static void make_zeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zero_rows = new HashSet<Integer>();
        Set<Integer> zero_cols = new HashSet<Integer>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (!zero_rows.contains(i)) {
                        zero_rows.add(i);
                    }

                    if (!zero_cols.contains(j)) {
                        zero_cols.add(j);
                    }
                }
            }
        }

        for (int r : zero_rows) {
            for (int c = 0; c < cols; ++c) {
                matrix[r][c] = 0;
            }
        }

        for (int c : zero_cols) {
            for (int r = 0; r < rows; ++r) {
                matrix[r][c] = 0;
            }
        }
    }

    static int[][] create_random_matrix(int rows, int cols) {
        int[][] v = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int t = new Random().nextInt() % 100;
                v[i][j] = t + 1;
                if (Math.abs(t) % 100 <= 5) {
                    v[i][j] = 0;
                }
            }
        }
        return v;
    }

    static void print_matrix(int[][] m) {
        System.out.println();
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    static boolean is_row_or_col_zero(int[][] matrix, int r, int c) {
        int rows = matrix.length;
        int cols = 0;
        if (rows > 0) {
            cols = matrix[0].length;
        }

        for (int i = 0; i < cols; ++i) {
            if (matrix[r][i] == 0) {
                return true;
            }
        }

        for (int i = 0; i < rows; ++i) {
            if (matrix[i][c] == 0) {
                return true;
            }
        }

        return false;
    }

    static void verify(int[][] matrix) {
        int[][] mat_copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; ++i) {
            mat_copy[i] = matrix[i].clone();
        }

        make_zeroes(matrix);

        int rows = matrix.length;
        int cols = 0;
        if (rows > 0) {
            cols = matrix[0].length;
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (is_row_or_col_zero(mat_copy, i, j)) {
                    assert (matrix[i][j] == 0);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 45, 0, 81 }, { 6, 7, 2, 82, 8 }, { 20, 22, 49, 5, 5 }, { 0, 23, 50, 4, 92 } };
        print_matrix(matrix);
        verify(matrix);
        print_matrix(matrix);

        matrix = create_random_matrix(5, 5);
        print_matrix(matrix);
        verify(matrix);
        print_matrix(matrix);

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matrix = create_random_matrix(i, j);
                verify(matrix);
            }
        }
    }
}