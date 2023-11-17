public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // number of days
        int trials = Integer.parseInt(args[1]);
        int[] peopleTotal = new int[n+2]; // how many times this # was final

        for (int i = 0; i < trials; i++) {
            boolean[] alreadyEntered = new boolean[n];
            int peopleInRoom = 0;
            boolean sameDayBirthday = false;
            while (!sameDayBirthday) {
                int birthday = (int) (n * Math.random());
                peopleInRoom++;
                sameDayBirthday = alreadyEntered[birthday];
                alreadyEntered[birthday] = true;
            }
            peopleTotal[peopleInRoom-1]++;
        }

        double fraction = 0.0;
        int idx = 0;
        while (fraction < 0.5) {
            fraction += peopleTotal[idx] / (double) trials;
            System.out.printf("%d\t%d\t%.6f\n", idx+1, peopleTotal[idx], fraction);
            idx++;
        }
    }
}
