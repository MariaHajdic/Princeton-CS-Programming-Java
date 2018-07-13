public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;
    
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (Math.abs(x) + Math.abs(y) != r) {
                double rand = Math.random();
                if (rand < 0.25) x++; // right
                else if (rand < 0.5) y++; // up
                else if (rand < 0.75) x--; // left
                else y--; // down
                steps++;
            }
            totalSteps += steps;
        }
        System.out.println("average number of steps = " + (double) totalSteps / trials);
    }
}
