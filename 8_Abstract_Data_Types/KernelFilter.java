import java.awt.Color;

public class KernelFilter {
    private static Picture filterPicture(Picture picture, double[] kernel) {
        Picture filteredPicture = new Picture(picture.width(), picture.height());
        int kernelHalfSide = (int) (Math.sqrt(kernel.length) / 2);

        for (int row = 0; row < filteredPicture.height(); row++) {
            for (int col = 0; col < filteredPicture.width(); col++) {
                int kernelIdx = 0;
                double[] rgb = new double[3];

                for (int kernelRow = row - kernelHalfSide; kernelRow <= row + kernelHalfSide; kernelRow++) {
                    for (int kernelCol = col - kernelHalfSide; kernelCol <= col + kernelHalfSide; kernelCol++) {
                        int i = (picture.width() == 1) ? 0 :
                            (kernelCol >= 0) ? kernelCol % picture.width() :
                            picture.width() + kernelCol % picture.width();
                        int j = (picture.height() == 1)? 0 :
                            (kernelRow >= 0) ? kernelRow % picture.height() :
                            picture.height() + kernelRow % picture.height();
                        
                        rgb[0] += picture.get(i, j).getRed() * kernel[kernelIdx];
                        rgb[1] += picture.get(i, j).getGreen() * kernel[kernelIdx];
                        rgb[2] += picture.get(i, j).getBlue() * kernel[kernelIdx];
                        
                        kernelIdx++;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    rgb[i] = Math.round(Math.min(Math.max(rgb[i], 0), 255));
                }
                Color color = new Color((int) rgb[0], (int) rgb[1], (int) rgb[2]);
                filteredPicture.set(col, row, color);
            }
        }
        return filteredPicture;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[] kernel = {1.0/16, 1.0/8, 1.0/16, 1.0/8, 1.0/4, 1.0/8, 1.0/16, 1.0/8, 1.0/16};        
        return filterPicture(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[] kernel = {0, -1, 0, -1, 5, -1, 0, -1, 0};
        return filterPicture(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[] kernel = {-1, -1, -1, -1, 8, -1, -1, -1, -1};
        return filterPicture(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[] kernel = {-2, -1, 0, -1, 1, 1, 0, 1, 2};
        return filterPicture(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[] kernel = new double[81];
        for (int i = 0; i < kernel.length; i += 10)
            kernel[i] = 1.0/9;
        return filterPicture(picture, kernel);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);

        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();
    }
}