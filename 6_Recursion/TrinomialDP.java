public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) return 0;
        long[][] coefficients = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    coefficients[i][j] = 1;
                    continue;
                }
                if (j > i) break;
                if (j == 0) coefficients[i][j] = coefficients[i-1][j] + 2 * coefficients[i-1][j+1]; // T(n,k) = T(n,-k)
                else coefficients[i][j] = coefficients[i-1][j-1] + coefficients[i-1][j] + coefficients[i-1][j+1];
            }
        }
        return coefficients[n][Math.abs(k)];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}