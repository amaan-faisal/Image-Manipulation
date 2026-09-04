package assignment;

import org.junit.jupiter.api.Test;

import static assignment.ImageEffect.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TransformationsTest {
    public final static int WHITE = makePixel(255, 255, 255);
    public final static int BLACK = makePixel(0, 0, 0);
    @Test
    public void testInvert() {

        int[][] pixels = {
                { WHITE, BLACK, WHITE },
                { BLACK, WHITE, BLACK },
                { WHITE, BLACK, WHITE }
        };

        int[][] expected = {
                { BLACK, WHITE, BLACK },
                { WHITE, BLACK, WHITE },
                { BLACK, WHITE, BLACK }
        };

        ImageEffect invertEffect = new Invert();

        int[][] actual = invertEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testNoRed() {
        final int RED = makePixel(255, 0, 0);
        ImageEffect noRedFilter = new NoRed(); 
        int[][] inputPixels = {
            {BLACK, RED, RED},
            {RED, BLACK, RED},
            {BLACK, BLACK, BLACK}
        };
        int[][] expectedPixels = {
            {BLACK, BLACK, BLACK},
            {BLACK, BLACK, BLACK},
            {BLACK, BLACK, BLACK}
        };
        int[][] actual = noRedFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test 
    public void testNoBlue() {
        final int BLUE = makePixel(0, 0, 255);
        ImageEffect noBlueFilter = new NoBlue(); 
        int[][] inputPixels = {
            {BLUE, BLUE, BLACK},
            {BLACK, BLUE, BLACK},
            {BLACK, BLACK, BLUE}
        };
        int[][] expectedPixels = {
            {BLACK, BLACK, BLACK},
            {BLACK, BLACK, BLACK},
            {BLACK, BLACK, BLACK}
        };
        int[][] actual = noBlueFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testNoGreen(){
        final int GREEN = makePixel(0, 255, 0);
        ImageEffect noGreenFilter = new NoGreen(); 
        int[][] inputPixels = {
            {GREEN, BLACK, GREEN},
            {BLACK, GREEN, BLACK},
            {GREEN, BLACK, GREEN}
        };
        int[][] expectedPixels = {
            {BLACK, BLACK, BLACK},
            {BLACK, BLACK, BLACK},
            {BLACK, BLACK, BLACK}
        };
        int[][] actual = noGreenFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
}
