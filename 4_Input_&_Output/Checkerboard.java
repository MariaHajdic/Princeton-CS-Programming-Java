public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean startBlue = true;

        StdDraw.setScale(0, n);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdDraw.setPenColor(startBlue ? StdDraw.BLUE : StdDraw.LIGHT_GRAY);
                startBlue = !startBlue;
                StdDraw.filledSquare((double) i + 0.5, (double) j + 0.5, 0.5);
            }
            startBlue = n % 2 != 0 ? startBlue : !startBlue;
        }
    }
}
