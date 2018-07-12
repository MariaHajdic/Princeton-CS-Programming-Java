public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            String symbol;
            for (int j = 0; j < n; j++) {
                symbol = (Math.abs(j - i) > width) ? "0" : "*";
                if (j < n - 1) symbol += "  ";
                System.out.print(symbol);
            }
            System.out.print("\n");
        }
    }
}
