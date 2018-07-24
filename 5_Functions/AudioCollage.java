public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i] * alpha;
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0, j = a.length - 1; i < a.length && j >= 0; i++, j--)
            b[i] = a[j];
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length+b.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i];
        for (int i = a.length; i < a.length+b.length; i++)
            c[i] = b[i-a.length];
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int resultLen = Math.max(a.length, b.length);
        double[] c = new double[resultLen];
        for (int i = 0; i < Math.min(a.length, b.length); i++)
            c[i] = a[i] + b[i];
        for (int i = Math.min(a.length, b.length); i < resultLen; i++)
            c[i] = (a.length >= b.length) ? a[i] : b[i];
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int len = (int) Math.floor(a.length / alpha);
        double[] b = new double[len];
        for (int i = 0; i < len; i++)
            b[i] = a[(int) Math.floor(i * alpha)];
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        double[][] audioFiles = new double[][] {
            StdAudio.read("chimes.wav"), StdAudio.read("dialup.wav"), 
            StdAudio.read("harp.wav"), StdAudio.read("piano.wav"), 
            StdAudio.read("silence.wav"),
        };

        double[] resultAudio = merge(
            merge(
                amplify(audioFiles[0], 1.2),
                merge(audioFiles[2], mix(audioFiles[1], changeSpeed(audioFiles[3], 0.2)))
            ),
            reverse(audioFiles[4])
        );
        StdAudio.play(resultAudio);
    }
}
