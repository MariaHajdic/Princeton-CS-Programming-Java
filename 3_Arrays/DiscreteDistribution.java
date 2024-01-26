public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(args[i+1]);
        }

        int[] cumulativeSums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cumulativeSums[i] = cumulativeSums[i-1] + values[i-1];
        }

        for (int i = 0; i < m; i++) {
            int randomN = (int) (cumulativeSums[n] * Math.random());

            for (int j = 0; j < n; j++) {
                if (cumulativeSums[j+1] > randomN) {
                    System.out.print((j+1) + " ");
                    break;
                }
            }
        }
    }
}