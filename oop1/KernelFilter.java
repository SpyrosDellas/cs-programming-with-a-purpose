/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/03/2020
 *
 * KernelFilter.java applies various kernel filters to images, such as
 * Gaussian blur, sharpen, Laplacian, emboss, and motion blur. A kernel filter
 * modifies the pixels in an image by replacing each pixel with a linear
 * combination of its neighboring pixels. The matrix that characterizes the
 * linear combination is known as the kernel.
 *
 * More specifically, to apply a kernel filter to a grayscale image, we perform
 * the following operation for each pixel p:
 * - Align the center of the kernel on pixel p.
 * - The new grayscale value of pixel p is obtained by multiplying each kernel
 *   element with the corresponding grayscale value, and adding the results.
 * To apply a kernel filter to a color image, we perform the above operation to
 * the red, green, and blue components of each pixel p separately, and combine
 * the results.
 *
 * Required behavior:
 * - Periodic boundary conditions. When applying a kernel filter to a pixel near
 * the boundary, some of its neighboring pixels may not exist. In such cases,
 * we assume the leftmost column wraps around to the rightmost column and the
 * top row wraps around to the bottom row (and vice versa).
 * - Rounding. When applying a kernel filter, the resulting RGB components may
 * become fractional if the kernel weights are fractional. We round each RGB
 * component to the nearest integer, with ties rounding up.
 * - Clamping. When applying a kernel filter, the resulting RGB components may
 * not remain between 0 and 255. If an RGB component of a pixel is less than 0,
 * we set it to 0; if is greater than 255, we set it to 255. This mechanism for
 * handling arithmetic overflow and underflow is known as clamping or saturating
 * arithmetic.
 * - Performance requirement. All methods should take time proportional to the
 * product of the number of pixels in the image and the number of elements in
 * the kernel.
 *
 * NOTE:
 * Kernel filters are widely used for image processing in applications such as
 * Photoshop or GIMP. They are also used in convolutional neural networks to
 * extract features from an image and in digital cameras to remove camera shake.
 *
 **************************************************************************** */

public class KernelFilter {

    private static Picture applyKernel(Picture picture, int[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        int kernelSize = kernel.length;
        int kernelHalf = (kernelSize - 1) / 2;
        Picture result = new Picture(width, height);
        int RGB = 0;
        int outRGB = 0;
        int r = 0;
        int outR = 0;
        int g = 0;
        int outG = 0;
        int b = 0;
        int outB = 0;
        int x = 0;
        int y = 0;

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                outR = 0;
                outG = 0;
                outB = 0;
                for (int m = 0; m < kernelSize; m++) {
                    x = (width + (column - kernelHalf + m)) % width;
                    for (int n = 0; n < kernelSize; n++) {
                        y = (height + (row - kernelHalf + n)) % height;
                        RGB = picture.getRGB(x, y);
                        r = (RGB >> 16) & 0xFF;
                        g = (RGB >> 8) & 0xFF;
                        b = (RGB >> 0) & 0xFF;
                        outR += kernel[m][n] * r;
                        outG += kernel[m][n] * g;
                        outB += kernel[m][n] * b;
                    }
                }
                if (outR < 0) outR = 0;
                else if (outR > 255) outR = 255;
                if (outG < 0) outG = 0;
                else if (outG > 255) outG = 255;
                if (outB < 0) outB = 0;
                else if (outB > 255) outB = 255;

                outRGB = (outR << 16) + (outG << 8) + outB;
                result.setRGB(column, row, outRGB);
            }
        }
        return result;
    }

    private static Picture applyKernel(Picture picture, double[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        int kernelSize = kernel.length;
        int kernelHalf = (kernelSize - 1) / 2;
        Picture result = new Picture(width, height);
        int RGB;
        int outRGB = 0;
        int r;
        double outR = 0;
        int g;
        double outG = 0;
        int b;
        double outB = 0;
        int x = 0;
        int y = 0;

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                outR = 0;
                outG = 0;
                outB = 0;
                for (int m = 0; m < kernelSize; m++) {
                    x = (width + (column - kernelHalf + m)) % width;
                    for (int n = 0; n < kernelSize; n++) {
                        y = (height + (row - kernelHalf + n)) % height;
                        RGB = picture.getRGB(x, y);
                        r = (RGB >> 16) & 0xFF;
                        g = (RGB >> 8) & 0xFF;
                        b = (RGB >> 0) & 0xFF;
                        outR += kernel[m][n] * r;
                        outG += kernel[m][n] * g;
                        outB += kernel[m][n] * b;
                    }
                }
                outR = Math.round(outR);
                outG = Math.round(outG);
                outB = Math.round(outB);
                if (outR < 0) outR = 0;
                else if (outR > 255) outR = 255;
                if (outG < 0) outG = 0;
                else if (outG > 255) outG = 255;
                if (outB < 0) outB = 0;
                else if (outB > 255) outB = 255;

                outRGB = ((int) outR << 16) + ((int) outG << 8) + (int) outB;
                result.setRGB(column, row, outRGB);
            }
        }
        return result;
    }

    public static Picture gaussian(Picture picture) {
        /* Returns a new picture that applies a Gaussian blur filter to the
        given picture.
        */
        double[][] gaussianBlurKernel = new double[][] {
                { 1.0 / 16, 1.0 / 8, 1.0 / 16 },
                { 1.0 / 8, 1.0 / 4, 1.0 / 8 },
                { 1.0 / 16, 1.0 / 8, 1.0 / 16 }
        };
        return applyKernel(picture, gaussianBlurKernel);
    }


    public static Picture sharpen(Picture picture) {
        /* Returns a new picture that applies a sharpen filter to the
        given picture.
        */
        int[][] sharpenKernel = new int[][] {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 }
        };
        return applyKernel(picture, sharpenKernel);
    }


    public static Picture laplacian(Picture picture) {
        /* Returns a new picture that applies a Laplacian filter to the
        given picture.
        */
        int[][] laplacianKernel = new int[][] {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };
        return applyKernel(picture, laplacianKernel);
    }


    public static Picture emboss(Picture picture) {
        /* Returns a new picture that applies an emboss filter to the
        given picture.
        */
        int[][] embossKernel = new int[][] {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };
        return applyKernel(picture, embossKernel);
    }


    public static Picture motionBlur(Picture picture) {
        /* Returns a new picture that applies a motion blur filter to the
        given picture.
        */
        double[][] motionBlurKernel = new double[][] {
                { 1.0 / 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1.0 / 9, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1.0 / 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1.0 / 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1.0 / 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1.0 / 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1.0 / 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1.0 / 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1.0 / 9 }
        };
        return applyKernel(picture, motionBlurKernel);
    }


    public static void main(String[] args) {
        Picture image = new Picture(args[0]);
        image.show();
        Picture gBlurred = gaussian(image);
        Picture sharpened = sharpen(image);
        Picture laplacian = laplacian(image);
        Picture embossed = emboss(image);
        Picture mBlurred = motionBlur(image);
        gBlurred.show();
        sharpened.show();
        laplacian.show();
        embossed.show();
        mBlurred.show();
    }
}
