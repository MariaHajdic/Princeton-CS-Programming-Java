public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n < 1729) return false; // smallest positive Ramanujan number
        long nCubeRoot = (long) Math.cbrt(n);
        long firstPairSecondTerm = 0;
        for (long i = 1; i < nCubeRoot; i++) {
            double x = Math.cbrt(n - i * i * i);
            if (x == (long) x) { // faster than floor
                if (firstPairSecondTerm != 0 && firstPairSecondTerm != i) return true;
                firstPairSecondTerm = (long) x;
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}