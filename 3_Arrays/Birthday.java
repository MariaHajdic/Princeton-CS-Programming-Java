public class Birthday {
    public static void main(String[] args) {
        int days = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] peopleTotal = new int[days+2]; // how many times this # was final

        for (int i = 0; i < trials; i++) {
            boolean[] personAlreadyEntered = new boolean[days];
            int peopleInRoom = 0;
            while (true) {
                int birthday = (int) (days * Math.random());
                peopleInRoom++;
                if (personAlreadyEntered[birthday]) break;
                personAlreadyEntered[birthday] = true;
            }
            peopleTotal[peopleInRoom]++;
        }

        double fraction = 0.0;
        int idx = 1;
        while (fraction < 0.5) {
            fraction += peopleTotal[idx] / (double) trials;
            System.out.printf("%d\t%d\t%.6f\n", idx, peopleTotal[idx], fraction);
            idx++;
        }
    }
}
