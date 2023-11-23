public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] intsOccurences = new int[m+1];
        int integersCount = 0;
        while(!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            intsOccurences[x]++;
            integersCount++;
        }
        
        double H = 0.0; // Shannon entropy
        for (int i = 1; i <= m; i++) {
            if (intsOccurences[i] != 0) {
                double proportion = (double) intsOccurences[i] / (double) integersCount;
                H -= proportion * Math.log(proportion) / Math.log(2);
            }
        }
        StdOut.printf("%.4f\n", H);
    }
}
