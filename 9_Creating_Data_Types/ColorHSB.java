public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100)
            throw new IllegalArgumentException("invalid color");
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return String.format("(%d, %d, %d)", hue, saturation, brightness);
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        // second condition seems excess, but the tests say it is possible ¯\_(ツ)_/¯
        return saturation == 0 || brightness == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("argument can't be null");
        // min{(h1 - h2)^2, (360-|h1-h2|)^2} + (s1 - s2)^2 + (b1 - b2)^2
        return (int) (Math.min(Math.pow(this.hue-that.hue, 2), Math.pow(360 - Math.abs(this.hue-that.hue), 2))
            + Math.pow(this.saturation-that.saturation, 2) + Math.pow(this.brightness-that.brightness, 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int[] base = new int[3];
        for (int i = 0; i < 3; i++)
            base[i] = Integer.parseInt(args[i]);
        ColorHSB baseColor = new ColorHSB(base[0], base[1], base[2]);

        ColorHSB nearestColor = new ColorHSB(0, 0, 0);
        String nearestColorName = "";
        int nearestDistance = 52400; // max possible distance
        
        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int[] currentBase = new int[3];
            for (int i = 0; i < 3; i++)
                currentBase[i] = StdIn.readInt();
            ColorHSB currentColor = new ColorHSB(currentBase[0], currentBase[1], currentBase[2]);

            if (currentColor.distanceSquaredTo(baseColor) < nearestDistance) {
                nearestDistance = currentColor.distanceSquaredTo(baseColor);
                nearestColorName = colorName;
                nearestColor = currentColor;
            }
        }
        StdOut.printf("%s %s\n", nearestColorName, nearestColor.toString());
    }

}