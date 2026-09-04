package assignment;

import org.junit.jupiter.api.Test;

import static assignment.ImageEffect.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TransformationsTest {
    public final static int WHITE = makePixel(255, 255, 255);
    public final static int BLACK = makePixel(0, 0, 0);
    public final static int RED = makePixel(255, 0, 0);
    public final static int GREEN = makePixel(0, 255, 0);
    public final static int BLUE = makePixel(0, 0, 255);
    public final static int GRAY = makePixel(85, 85, 85);

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
    public void testNoGreen(){
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
 
    @Test 
    public void testNoBlue() {
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
    public void testRedOnly() {
        ImageEffect redOnlyFilter = new RedOnly(); 
        int[][] inputPixels = {
            {BLACK, RED, GREEN},
            {BLUE, WHITE, RED},
            {BLUE, BLACK, GREEN}
        };
        int[][] expectedPixels = {
            {BLACK, RED, BLACK},
            {BLACK, RED, RED},
            {BLACK, BLACK, BLACK}
        };
        int[][] actual = redOnlyFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testGreenOnly() {
        ImageEffect greenOnlyFilter = new GreenOnly(); 
        int[][] inputPixels = {
            {BLACK, RED, GREEN},
            {BLUE, WHITE, GREEN},
            {BLUE, BLACK, RED}
        };
        int[][] expectedPixels = {
            {BLACK, BLACK, GREEN},
            {BLACK, GREEN, GREEN},
            {BLACK, BLACK, BLACK}
        };
        int[][] actual = greenOnlyFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }
    
    @Test
    public void testBlueOnly() {
        ImageEffect blueOnlyFilter = new BlueOnly(); 
        int[][] inputPixels = {
            {BLACK, RED, GREEN},
            {BLUE, WHITE, GREEN},
            {BLUE, BLACK, RED}
        };
        int[][] expectedPixels = {
            {BLACK, BLACK, BLACK},
            {BLUE, BLUE, BLACK},
            {BLUE, BLACK, BLACK}
        };
        int[][] actual = blueOnlyFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    @Test
    public void testBlackAndWhite() {
        ImageEffect blackAndWhiteFilter = new BlackAndWhite(); 
        int[][] inputPixels = {
            {BLACK, RED, GREEN},
            {BLUE, WHITE, GREEN},
            {BLUE, BLACK, RED}
        };
        int[][] expectedPixels = {
            {BLACK, GRAY, GRAY},
            {GRAY, WHITE, GRAY},
            {GRAY, BLACK, GRAY}
        };
        int[][] actual = blackAndWhiteFilter.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    //tests reflection with odd length rows
    @Test
    public void testVerticalReflectOdd() {
        ImageEffect verticalReflectEffect = new VerticalReflect();
        int[][] inputPixels = {
            {RED, GREEN, BLUE},
            {BLACK, WHITE, RED}
        };
        int[][] expectedPixels = {
            {BLUE, GREEN, RED},
            {RED, WHITE, BLACK}
        };
        int[][] actual = verticalReflectEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // tests both jagged arrays and reflection with an even length row 
    // (see row index 2 in inputPixels)
    @Test
    public void testVerticalReflectJagged() {
        ImageEffect verticalReflectEffect = new VerticalReflect();
        int[][] inputPixels = {
            {RED, GREEN},
            {BLACK, WHITE, BLUE},
            {GREEN, RED, BLUE, WHITE}
        };
        int[][] expectedPixels = {
            {GREEN, RED},
            {BLUE, WHITE, BLACK},
            {WHITE, BLUE, RED, GREEN}
        };
        int[][] actual = verticalReflectEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }
}
