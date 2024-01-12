public class RevesPuzzle {
    private static void hanoi(int n, int k, String origPole, String tempPole, String destPole) {
        if (n == 0) return;
        hanoi(n - 1, k, origPole, destPole, tempPole);
        System.out.printf("Move disc %d from %s to %s\n", n+k, origPole, destPole);
        hanoi(n - 1, k, tempPole, origPole, destPole);
    }

    private static void reves(int n, String origPole, String tempPole, String tempPole2,
        String destPole) {
        if (n == 1) {
            System.out.printf("Move disc 1 from %s to %s\n", origPole, destPole);
            return;
        }
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1)); 
        reves(k, origPole, tempPole2, destPole, tempPole);
        hanoi(n - k, k, origPole, tempPole2, destPole);
        reves(k, tempPole, origPole, tempPole2, destPole);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}