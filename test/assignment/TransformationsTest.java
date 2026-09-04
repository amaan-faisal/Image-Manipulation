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
    public final static int GRAY_LIGHT = makePixel(127, 127, 127);
    public final static int GRAY_DARK = makePixel(42, 42, 42);

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

    // Tests reflection with odd length rows.
    @Test
    public void testVerticalReflectOdd() {
        ImageEffect verticalReflectEffect = new VerticalReflect();
        int[][] inputPixels = {
            {GRAY, GREEN, BLUE},
            {BLACK, WHITE, RED}
        };
        int[][] expectedPixels = {
            {BLUE, GREEN, GRAY},
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

    // Tests both jagged arrays and reflection with an even length row.
    // (See row index 2 in inputPixels.)
    @Test
    public void testVerticalReflectJagged() {
        ImageEffect verticalReflectEffect = new VerticalReflect();
        int[][] inputPixels = {
            {RED, GREEN},
            {GRAY, WHITE, BLUE},
            {GREEN, RED, BLUE, WHITE}
        };
        int[][] expectedPixels = {
            {GREEN, RED},
            {BLUE, WHITE, GRAY},
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

    // Tests horizontal reflect with an odd number of rows.
    @Test
    public void testHorizontalReflectOdd() {
        ImageEffect horizontalReflectEffect = new HorizontalReflect();
        int[][] inputPixels = {
            {GRAY, GREEN},
            {BLACK, WHITE},
            {BLUE, RED},
            {GREEN, BLACK},
            {WHITE, BLUE}
        };
        int[][] expectedPixels = {
            {WHITE, BLUE},
            {GREEN, BLACK},
            {BLUE, RED},
            {BLACK, WHITE},
            {GRAY, GREEN}
        };
        int[][] actual = horizontalReflectEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Tests reflection with jagged rows and an even number of rows.
    @Test
    public void testHorizontalReflectJagged() {
        ImageEffect horizontalReflectEffect = new HorizontalReflect();
        int[][] inputPixels = {
            {RED, GREEN},
            {BLACK, WHITE, BLUE},
            {GRAY},
            {BLUE, RED, WHITE, BLACK}
        };
        int[][] expectedPixels = {
            {BLUE, RED, WHITE, BLACK},
            {GRAY},
            {BLACK, WHITE, BLUE},
            {RED, GREEN}
        };
        int[][] actual = horizontalReflectEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < inputPixels.length; i++) {
            for (int j = 0; j < inputPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Simplest test case where input array is a 2x2.
    @Test
    public void testGrowEven() {
        ImageEffect growEffect = new Grow();
        int[][] inputPixels = {
            {RED, GREEN},
            {BLUE, WHITE}
        };
        int[][] expectedPixels = {
            {RED, RED, GREEN, GREEN},
            {RED, RED, GREEN, GREEN},
            {BLUE, BLUE, WHITE, WHITE},
            {BLUE, BLUE, WHITE, WHITE}
        };
        int[][] actual = growEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }
    
    // Input array has odd dimensions.
    @Test
    public void testGrowOdd() {
        ImageEffect growEffect = new Grow();
        int[][] inputPixels = {
            {RED, GREEN, BLUE, BLACK, WHITE},
            {GRAY, WHITE, BLACK, RED, GREEN},
            {BLUE, BLACK, RED, GREEN, GRAY}
        };
        int[][] expectedPixels = {
            {RED, RED, GREEN, GREEN, BLUE, BLUE, BLACK, BLACK, WHITE, WHITE},
            {RED, RED, GREEN, GREEN, BLUE, BLUE, BLACK, BLACK, WHITE, WHITE},
            {GRAY, GRAY, WHITE, WHITE, BLACK, BLACK, RED, RED, GREEN, GREEN},
            {GRAY, GRAY, WHITE, WHITE, BLACK, BLACK, RED, RED, GREEN, GREEN},
            {BLUE, BLUE, BLACK, BLACK, RED, RED, GREEN, GREEN, GRAY, GRAY},
            {BLUE, BLUE, BLACK, BLACK, RED, RED, GREEN, GREEN, GRAY, GRAY}
        };
        int[][] actual = growEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Input array has jagged rows.
    @Test
    public void testGrowJaggedRows() {
        ImageEffect growEffect = new Grow();
        int[][] inputPixels = {
            {RED},
            {GREEN, GRAY, BLUE},
            {WHITE, BLACK, RED, BLUE, GRAY}
        };
        int[][] expectedPixels = {
            {RED, RED},
            {RED, RED},
            {GREEN, GREEN, GRAY, GRAY, BLUE, BLUE},
            {GREEN, GREEN, GRAY, GRAY, BLUE, BLUE},
            {WHITE, WHITE, BLACK, BLACK, RED, RED, BLUE, BLUE, GRAY, GRAY},
            {WHITE, WHITE, BLACK, BLACK, RED, RED, BLUE, BLUE, GRAY, GRAY}
        };
        int[][] actual = growEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Simple test for even dimension, 2x2 input array.
    @Test
    public void testShrinkEven() {
        ImageEffect shrinkEffect = new Shrink();
        int[][] inputPixels = {
            {RED, GREEN, BLUE, WHITE},
            {BLUE, WHITE, RED, GREEN},
            {BLACK, GRAY, WHITE, RED},
            {GRAY, BLACK, GREEN, BLUE}
        };
        int[][] expectedPixels = {
            {GRAY_LIGHT, GRAY_LIGHT},
            {GRAY_DARK, GRAY_LIGHT}
        };
        int[][] actual = shrinkEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Tests odd dimension input array.
    // Discards last row and column.
    @Test
    public void testShrinkOdd() {
        ImageEffect shrinkEffect = new Shrink();
        int[][] inputPixels = {
            {RED, RED, GREEN, GREEN, BLUE},
            {RED, RED, GREEN, GREEN, BLACK},
            {BLUE, BLUE, WHITE, WHITE, RED},
            {BLUE, BLUE, WHITE, WHITE, GREEN},
            {GRAY, GRAY, GRAY, GRAY, WHITE}
        };
        int[][] expectedPixels = {
            {RED, GREEN},
            {BLUE, WHITE}
        };
        int[][] actual = shrinkEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Tests jagged arrays.
    // Uses the smaller row length.
    @Test
    public void testShrinkJaggedRows() {
        ImageEffect shrinkEffect = new Shrink();
        int[][] inputPixels = {
            {RED, GREEN, BLUE, WHITE, GRAY},
            {BLUE, WHITE, RED},
            {BLACK, GRAY, WHITE, RED},
            {GRAY, BLACK}
        };
        int[][] expectedPixels = {
            {GRAY_LIGHT},
            {GRAY_DARK}
        };
        int[][] actual = shrinkEffect.apply(inputPixels, new ArrayList<>());
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Tests the default threshold of 127.
    @Test
    public void testThresholdDefault() {
        ImageEffect thresholdEffect = new Threshold();
        int[][] inputPixels = {
            {makePixel(126, 127, 128), WHITE},
            {BLACK, makePixel(127, 127, 127)}
        };
        int[][] expectedPixels = {
            {makePixel(0, 255, 255), WHITE},
            {BLACK, WHITE}
        };
        int[][] actual = thresholdEffect.apply(inputPixels, null);
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Tests my custom threshold (199).
    @Test
    public void testThresholdCustom() {
        ImageEffect thresholdEffect = new Threshold();
        ArrayList<ImageEffectParam> params = new ArrayList<>();
        params.add(new ImageEffectParam("Threshold", "", 127, 0, 255));
        params.get(0).setValue(199);
        int[][] inputPixels = {
            {makePixel(199, 200, 201), makePixel(0, 255, 200)}
        };
        int[][] expectedPixels = {
            {WHITE, makePixel(0, 255, 255)}
        };
        int[][] actual = thresholdEffect.apply(inputPixels, params);
        for (int i = 0; i < expectedPixels.length; i++) {
            for (int j = 0; j < expectedPixels[i].length; j++) {
                assertEquals(getRed(expectedPixels[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expectedPixels[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expectedPixels[i][j]), getBlue(actual[i][j]));
            }
        }
    }

    // Tests threshold values not in range [0,255].
    @Test
    public void testThresholdInvalid() {
        ImageEffect thresholdEffect = new Threshold();
        ArrayList<ImageEffectParam> params = new ArrayList<>();
        params.add(new ImageEffectParam("Threshold", "", 127, 0, 255));
        
        params.get(0).setValue(-1);
        // Threshold too low, defaults to 127.
        int[][] inputPixels = {
            {makePixel(0, 127, 255)}
        };
        int[][] actualTooLow = thresholdEffect.apply(inputPixels, params);
        assertEquals(makePixel(0, 255, 255), actualTooLow[0][0]);

        inputPixels[0][0] = makePixel(0, 127, 255);
        params.get(0).setValue(256);
        // Threshold too high, defaults to 127.
        int[][] actualTooHigh = thresholdEffect.apply(inputPixels, params);
        assertEquals(makePixel(0, 255, 255), actualTooHigh[0][0]);
    }
}