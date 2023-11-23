public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0.0, (double) width);
        StdDraw.setYscale(0.0, (double) height);

        while(!StdIn.isEmpty()) {
            String region = StdIn.readString();
            int numberOfVertices = StdIn.readInt();
            double[] xCoordinates = new double[numberOfVertices];
            double[] yCoordinates = new double[numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                xCoordinates[i] = StdIn.readDouble();
                yCoordinates[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xCoordinates, yCoordinates);
        }
    }
}
