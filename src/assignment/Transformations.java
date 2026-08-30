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

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = ~pixels[y][x];
            }
        }
        return pixels;
    }
}

class NoRed extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = makePixel(0, getGreen(pixels[y][x]), getBlue(pixels[y][x]));
            }
        }
        return pixels;
    }
}

class NoGreen extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = makePixel(getRed(pixels[y][x]), 0, getBlue(pixels[y][x]));
            }
        }
        return pixels;
    }
}

class NoBlue extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = makePixel(getRed(pixels[y][x]), getGreen(pixels[y][x]), 0);
            }
        }
        return pixels;
    }
}

class RedOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = makePixel(getRed(pixels[y][x]), 0, 0);
            }
        }
        return pixels;
    }
}

class GreenOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = makePixel(0, getGreen(pixels[y][x]), 0);
            }
        }
        return pixels;
    }
}

class BlueOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = makePixel(0, 0, getBlue(pixels[y][x]));
            }
        }
        return pixels;
    }
}

class BlackAndWhite extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int averageColor = (getRed(pixels[y][x]) + getGreen(pixels[y][x]) + getBlue(pixels[y][x])) / 3;
                pixels[y][x] = makePixel(averageColor, averageColor, averageColor);
            }
        }
        return pixels;
    }
}

class VerticalReflect extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width / 2; x++) {
            for (int y = 0; y < height; y++) {
                int tempPixel = pixels[y][x];
                pixels[y][x] = pixels[y][width - 1 - x];
                pixels[y][width - 1 - x] = tempPixel;
            }
        }
        return pixels;
    }
}

class HorizontalReflect extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height / 2; y++) {
                int tempPixel = pixels[y][x];
                pixels[y][x] = pixels[height - 1 - y][x];
                pixels[height - 1 - y][x] = tempPixel;
            }
        }
        return pixels;
    }
}

class Grow extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        int[][] grownPixels = new int[height * 2][width * 2];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grownPixels[y * 2][x * 2] = pixels[y][x];
                grownPixels[y * 2 + 1][x * 2] = pixels[y][x];
                grownPixels[y * 2][x * 2 + 1] = pixels[y][x];
                grownPixels[y * 2 + 1][x * 2 + 1] = pixels[y][x];
            }
        }
        return grownPixels;
    }
}

class Shrink extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int shrunkWidth = pixels[0].length / 2;
        int shrunkHeight = pixels.length / 2;

        int[][] shrunkPixels = new int[shrunkHeight][shrunkWidth];

        for (int x = 0; x < shrunkWidth; x++) {
            for (int y = 0; y < shrunkHeight; y++) {
                int redAverage = (
                    getRed(pixels[y * 2][x * 2]) +
                    getRed(pixels[y * 2 + 1][x * 2]) +
                    getRed(pixels[y * 2][x * 2 + 1]) +
                    getRed(pixels[y * 2 + 1][x * 2 + 1])
                ) / 4;

                int greenAverage = (
                    getGreen(pixels[y * 2][x * 2]) +
                    getGreen(pixels[y * 2 + 1][x * 2]) +
                    getGreen(pixels[y * 2][x * 2 + 1]) +
                    getGreen(pixels[y * 2 + 1][x * 2 + 1])
                ) / 4;

                int blueAverage = (
                    getBlue(pixels[y * 2][x * 2]) +
                    getBlue(pixels[y * 2 + 1][x * 2]) +
                    getBlue(pixels[y * 2][x * 2 + 1]) +
                    getBlue(pixels[y * 2 + 1][x * 2 + 1])
                ) / 4;

                shrunkPixels[y][x] = makePixel(redAverage, greenAverage, blueAverage);
            }
        }
         return shrunkPixels;
    }
}

class Threshold extends ImageEffect {
    public Threshold() {
        params = new ArrayList<ImageEffectParam>();
        params.add(new ImageEffectParam("Threshold",
                                       "Enter threshold value [0-255] inclusive.",
                                       127, 0, 255));
    }

    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        int thresholdValue = 127;
        if (params != null && !params.isEmpty()) {
            thresholdValue = params.get(0).getValue();
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = getRed(pixels[y][x]);
                int green = getGreen(pixels[y][x]);
                int blue = getBlue(pixels[y][x]);

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

                pixels[y][x] = makePixel(newRed, newGreen, newBlue);
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
