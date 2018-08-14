import java.util.Arrays;

public class BarChartRacer {
    public static void main(String args[]) {
        String fileName = args[0];
        int barsPerChart = Integer.parseInt(args[1]);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        In scanner = new In(fileName);
        String title = scanner.readLine();
        String xAxis = scanner.readLine();
        String source = scanner.readLine();

        BarChart chart = new BarChart(title, xAxis, source);
        // StdAudio.playInBackground("soundtrackA.wav");
        while(scanner.hasNextLine()) {
            scanner.readLine(); // skip empty line
            int numberOfCities = Integer.parseInt(scanner.readLine());
            Bar[] bars = new Bar[numberOfCities];

            String year = "";
            for (int i = 0; i < numberOfCities; i++) {
                String[] entry = scanner.readLine().split(",");
                year = entry[0].substring(0, 4);
                bars[i] = new Bar(entry[1], Integer.parseInt(entry[3]), entry[4]);
            }
            
            Arrays.sort(bars);
            for (int i = bars.length - 1; i > bars.length - 1 - barsPerChart; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            
            StdDraw.clear();
            chart.setCaption(year);
            chart.draw();
            StdDraw.show();
            StdDraw.pause(250); // in milliseconds
            chart.reset();
        }
    }
}