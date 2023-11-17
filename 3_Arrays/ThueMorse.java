public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] sequence = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (Integer.bitCount(i) % 2 != 0) sequence[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((sequence[i] == sequence[j]) ? "+" : "-");
                System.out.print((j < n - 1) ? "  " : "\n");
            }
        }
    }
}
