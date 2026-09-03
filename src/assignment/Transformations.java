package assignment;
/**
 *
 * CS314H Programming Assignment 1 - Java image processing
 *
 * Included is the Invert effect from the assignment.  Use this as an
 * example when writing the rest of your transformations.  For
 * convenience, you should place all of your transformations in this file.
 *
 * You can compile everything that is needed with
 * javac -d bin src/assignment/*.java
 *
 * You can run the program with
 * java -cp bin assignment.JIP
 *
 * Please note that the above commands assume that you are in the prog1
 * directory.
 */

import java.util.ArrayList;

class Invert extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int col = 0; col < width; col++) {
            for (int y = 0; y < height; y++) {
            pixels[y][col] = ~pixels[y][col];
            }
        }
        return pixels;
    }
}

class NoRed extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Set red value to 0 while preserving green and blue values.
                pixels[row][col] = makePixel(0, getGreen(pixels[row][col]), getBlue(pixels[row][col]));
            }
        }
        return pixels;
    }
}

class NoGreen extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Set green value to 0 while preserving red and blue values.
                pixels[row][col] = makePixel(getRed(pixels[row][col]), 0, getBlue(pixels[row][col]));
            }
        }
        return pixels;
    }
}

class NoBlue extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Set blue value to 0 while preserving red and green values.
                pixels[row][col] = makePixel(getRed(pixels[row][col]), getGreen(pixels[row][col]), 0);
            }
        }
        return pixels;
    }
}

class RedOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Set green and blue values to 0 while preserving red value.
                pixels[row][col] = makePixel(getRed(pixels[row][col]), 0, 0);
            }
        }
        return pixels;
    }
}

class GreenOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Set red and blue values to 0 while preserving green value.
                pixels[row][col] = makePixel(0, getGreen(pixels[row][col]), 0);
            }
        }
        return pixels;
    }
}

class BlueOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Set red and green values to 0 while preserving blue value.
                pixels[row][col] = makePixel(0, 0, getBlue(pixels[row][col]));
            }
        }
        return pixels;
    }
}

class BlackAndWhite extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each pixel.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                // Average red, green, and blue values to get B/W value
                int averageColor = (
                    getRed(pixels[row][col]) +
                    getGreen(pixels[row][col]) + 
                    getBlue(pixels[row][col])
                ) / 3;
                // Create new pixel with all RGB values set to the average.
                pixels[row][col] = makePixel(averageColor, averageColor, averageColor);
            }
        }
        return pixels;
    }
}

class VerticalReflect extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through each row.
        for (int row = 0; row < pixels.length; row++) {
            // Loop through first half of row.
            // Swap each pixel with the pixel on the opposite end.
            for (int col = 0; col < pixels[row].length / 2; col++) {
                int oppositeCol = pixels[row].length - 1 - col;
                int tempPixel = pixels[row][col];
                pixels[row][col] = pixels[row][oppositeCol];
                pixels[row][oppositeCol] = tempPixel;
            }
        }
        return pixels;
    }
}

class HorizontalReflect extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Loop through first half of each row.
        // Replace each row with the row on the opposite end of the grid.
        for (int row = 0; row < pixels.length / 2; row++) {
            int oppositeRow = pixels.length - 1 - row;
            int[] tempRow = pixels[row];
            pixels[row] = pixels[oppositeRow];
            pixels[oppositeRow] = tempRow;
        }
        return pixels;
    }
}

class Grow extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Create larger 2D array with double length, but no width yet.
        int[][] grownPixels = new int[pixels.length * 2][];
        // Loop through each row of original array.
        for (int row = 0; row < pixels.length; row++) {
            // Create two new rows, both twice the width of the original.
            grownPixels[row * 2] = new int[pixels[row].length * 2];
            grownPixels[row * 2 + 1] = new int[pixels[row].length * 2];
            // Loop through each pixel in original row.
            for (int col = 0; col < pixels[row].length; col++) {
                int pixel = pixels[row][col];
                // Copy pixel to four new pixels in the block.
                grownPixels[row * 2][col * 2] = pixel;
                grownPixels[row * 2 + 1][col * 2] = pixel;
                grownPixels[row * 2][col * 2 + 1] = pixel;
                grownPixels[row * 2 + 1][col * 2 + 1] = pixel;
            }
        }
        return grownPixels;
    }
}

class Shrink extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Cut image height in half.
        int shrunkHeight = pixels.length / 2;
        // Create smaller 2D array with half height, but no width.
        int[][] shrunkPixels = new int[shrunkHeight][];
        for (int y = 0; y < shrunkHeight; y++) {
            // If jagged, use the smaller of the two rows to determine width. Create new row with this width.
            int shrunkWidth = Math.min(
                pixels[y * 2].length,
                pixels[y * 2 + 1].length
            ) / 2;
            shrunkPixels[y] = new int[shrunkWidth];
            for (int col = 0; col < shrunkWidth; col++) {
                // Collect RGB values from block of pixels and average them.
                int redAverage = (
                    getRed(pixels[y * 2][col * 2]) +
                    getRed(pixels[y * 2 + 1][col * 2]) +
                    getRed(pixels[y * 2][col * 2 + 1]) +
                    getRed(pixels[y * 2 + 1][col * 2 + 1])
                ) / 4;

                int greenAverage = (
                    getGreen(pixels[y * 2][col * 2]) +
                    getGreen(pixels[y * 2 + 1][col * 2]) +
                    getGreen(pixels[y * 2][col * 2 + 1]) +
                    getGreen(pixels[y * 2 + 1][col * 2 + 1])
                ) / 4;

                int blueAverage = (
                    getBlue(pixels[y * 2][col * 2]) +
                    getBlue(pixels[y * 2 + 1][col * 2]) +
                    getBlue(pixels[y * 2][col * 2 + 1]) +
                    getBlue(pixels[y * 2 + 1][col * 2 + 1])
                ) / 4;
                // Apply average values to the new pixel.
                shrunkPixels[y][col] = makePixel(redAverage, greenAverage, blueAverage);
            }
        }
        return shrunkPixels;
    }
}

class Threshold extends ImageEffect {
    public Threshold() {
        // Create empty ArrayList of ImageEffectParam objects.
        params = new ArrayList<ImageEffectParam>();
        // Add new ImageEffectOaram object to params.
        // The object includes name, description, and default/min/max value.
        params.add(new ImageEffectParam("Threshold",
                                       "Enter threshold value [0-255] inclusive.",
                                       127, 0, 255));
    }

    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int thresholdValue = 127;
        // If there is a parameter, use its value as the threshold.
        // Otherwise, preserve the default value of 127.
        if (params != null && !params.isEmpty()) {
            thresholdValue = params.get(0).getValue();
        }
        // Loop through each pixel. 
        // Check if each color's value is less than the threshold.
        // If so, set it to 0. Else, set it to 255.
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                int red = getRed(pixels[row][col]);
                int green = getGreen(pixels[row][col]);
                int blue = getBlue(pixels[row][col]);

                int newRed;
                if (red < thresholdValue) {
                    newRed = 0;
                } else {
                    newRed = 255;
                }

                int newGreen;
                if (green < thresholdValue) {
                    newGreen = 0;
                } else {
                    newGreen = 255;
                }

                int newBlue;
                if (blue < thresholdValue) {
                    newBlue = 0;
                } else {
                    newBlue = 255;
                }

                // Create a new pixel with the threshold values.
                pixels[row][col] = makePixel(newRed, newGreen, newBlue);
            }
        }
        return pixels;
    }
}

class Dummy extends ImageEffect {

    public Dummy() {
        super();
        params = new ArrayList<ImageEffectParam>();
        params.add(new ImageEffectParam("ParamName",
                                           "Description of param.",
                                           10, 0, 1000));
    }

    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Use params here.
        return pixels;
    }
}
