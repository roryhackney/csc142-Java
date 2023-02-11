import java.awt.Graphics;
import java.awt.Color;

/**
 * Drawing supplier code for Project 3
 *
 * @author Rory Hackney
 * @version 1/23/2023
 */

public class SineDraw {
    //width: PI, height: 2 (-1 through 1), * 100 for whole pixels, * 2 to make image larger
    private static final DrawingPanel drawPan = new DrawingPanel(628, 200); //canvas
    private static final Graphics graphics = drawPan.getGraphics(); //pen
    
    /**
     * Draws rectangles to calculate area of sine curve
     *
     * @param  numRects  number of rectangles to be drawn, chosen by user; must be int 1-500
     */
    public static void drawRects(int numRects) {
        if (numRects < 1 || numRects > 500) {
            throw new IllegalArgumentException("Number of rectangles must be 1-500");
        }
        graphics.setColor(Color.GRAY);
        double rectWidth = Math.PI / numRects;
        double rectHeight;
        for (double xPos = 0; xPos < Math.PI; xPos += rectWidth) {
            rectHeight = Math.sin(xPos + rectWidth / 2);
            graphics.drawRect(SineCalc.cartesianXToGraphicX(xPos),
                            SineCalc.cartesianYToGraphicY(rectHeight),
                            SineCalc.cartesianXToGraphicX(rectWidth),
                            200 - SineCalc.cartesianYToGraphicY(rectHeight));
        }
    }
    
    /**
     * Draws the sine curve in range 0 <= x <= PI, 0 - 628px
     */
    //draws the sin(x) graph curve from 0,0 to PI,0
    public static void drawCurve() {
        graphics.setColor(Color.GREEN);
        for (double cartX = 0.0; cartX < Math.PI * 2; cartX += 0.01) {
            graphics.drawRect(SineCalc.cartesianXToGraphicX(cartX),
                            SineCalc.cartesianYToGraphicY(Math.sin(cartX)), 1, 1);
        }
    }
    
    /**
     * Clears the canvas by drawing a white rectangle.
     */
    public static void clearCanvas() {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 628, 200);
    }
}