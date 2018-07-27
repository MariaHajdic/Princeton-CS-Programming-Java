public class TrinomialDP {
    private static long[][] computedCoefficients;

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        k = Math.abs(k);
        if (computedCoefficients[n][k] == -1) computedCoefficients[n][k]
            = trinomial(n-1, k-1) + trinomial(n-1, k) + trinomial(n-1, k+1);
        return computedCoefficients[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k =Integer.parseInt(args[1]);

        long[][] computedCoefficients = new long[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                computedCoefficients[i][j] = -1;
                if (j == i) computedCoefficients[i][j] = 1;
                if (j > i) computedCoefficients[i][j] = 0;
            }
        }
        System.out.println(trinomial(n, k));
    }
}