/**
 * Calculation supplier functions for Project 3
 *
 * @author Rory Hackney
 * @version 1/23/2023
 */
public class SineCalc {
    /**
     * Calculates the approximate area of the sine curve graph, using numRects defined by user
     *
     * @param  numRects  int, number of rectangles to use, defined by user; must be in range 1-500
     * @return  area  the approximate area of the sine curve graph, should be double, close to 2
     */
    public static double calcArea(int numRects) {
        if (numRects < 1 || numRects > 500) {
            throw new IllegalArgumentException("numRects must be 1-500");
        }
        double rectWidth = Math.PI / numRects;
        double area = 0;
        for (double midPoint = rectWidth / 2.0; midPoint < rectWidth * numRects; midPoint += rectWidth) {
            double rectHeight = Math.sin(midPoint);
            area += rectWidth * rectHeight;
        }
        return area;
    }
    
    /**
     * Calculates the y value for a given x value in radians on a sine graph
     *
     * @param  x  x value (double) on a cartesian coordinate graph
     * @return    y value (double) on a graph
     */
    public static double calcYFromX(double x) {
        return Math.sin(x);
    }
    
    
    /**
     * Converts x cartesian coordinates in radians to graphic x position in pixels
     * eg 3.14 --> 314 --> 628, formula = x * 100 * 2
     * 
     * @param  xRadians  x coordinate on a sine graph in radians
     * @return    x position on a graphics DrawingPanel in pixels
     */
    public static int cartesianXToGraphicX(double xRadians) {
        return (int)Math.round(xRadians * 100 * 2);
    }

    /**
     * Converts y cartesian coordinates in radians to graphic y position in pixels
     * eg 0.5 --> -0.5 --> -50 --> 50, formula = -y * 100 + 100
     * 
     * @param  yRadians  y coordinate on a sine graph in radians
     * @return    y position on a graphics DrawingPanel in pixels
     */
    public static int cartesianYToGraphicY(double yRadians) {
       return (int)((-(yRadians) * 100) + 100) * 2;
    }
}
