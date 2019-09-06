/**
 * Runtime Complexity Linear, O(m+n) where 'm' is number of rows and 'n' is
 * number of columns.
 * 
 * Memory Complexity Constant, O(1). 从右上角开始比较 只用m+n
 */
class searchMatrix {
    public static IntPair search_in_matrix(int matrix[][], int value) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == value) {
                return new IntPair(i, j);
            } else if (matrix[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }
        return new IntPair(-1, -1);
    }
}