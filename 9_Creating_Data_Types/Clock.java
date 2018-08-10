public class Clock {
    private int hours;
    private int minutes;

    private void initializeTime(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException("invalid time parameters");
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        initializeTime(h, m);
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.contains(":") || s.length() != 5)
            throw new IllegalArgumentException("invalid time parameters");
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        initializeTime(h, m);
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return this.hours < that.hours || this.hours == that.hours && this.minutes < that.minutes;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minutes != 59) {
            minutes++;
            return;
        }
        hours = (hours == 23) ? 0 : hours + 1;
        minutes = 0;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("negative value of minutes to add");
        delta = (delta + hours * 60 + minutes) % 1440; // minus excess days
        hours = delta / 60;
        minutes = delta % 60;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock intClock = new Clock(22, 54);
        Clock stringClock = new Clock("04:14");
        System.out.println(intClock.toString());
        System.out.println(stringClock.isEarlierThan(intClock));
        stringClock.tic();
        intClock.toc(89);
    }
}