public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long inversionsCount = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) inversionsCount++;
        }
        return inversionsCount;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] permutation = new int[n];
        int idx = 0, descendingElement = n - 1;
        if (k >= n) {
            while (k > 0 && k >= descendingElement) {
                k -= descendingElement;
                permutation[idx++] = descendingElement--;
            }
        }
        int remainingElementPosition = (int) (n - k - 1);
        
        int ascendingElement = 0;
        for (; idx < n; idx++) {
            if (idx == remainingElementPosition)
                permutation[idx] = descendingElement;
            else permutation[idx] = ascendingElement++;
        }
        return permutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}