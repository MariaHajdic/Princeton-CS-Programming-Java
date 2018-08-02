public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int maxContiguous = 0;
        int[][] matrix = new int[a.length+1][a.length+1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                if (a[i-1][j-1] == 1) {
                    int min = Math.min(matrix[i][j-1], matrix[i-1][j]);
                    matrix[i][j] = Math.min(min, matrix[i-1][j-1]) + 1;
                }
                if (matrix[i][j] > maxContiguous) maxContiguous = matrix[i][j];
            }
        }
        return maxContiguous;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(matrix));
    }
}