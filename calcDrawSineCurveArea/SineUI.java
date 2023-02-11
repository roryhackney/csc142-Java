import java.util.Scanner;

/**
 * Main program (client code), user communication/input and displays for Project 3
 *
 * @author Rory Hackney
 * @version 1/23/2023
 */

public class SineUI {
    private static final int menuWidth = 46;
    
    /**
     * Runs program, getting user choices, calling calculations, and displaying results
     */   
    public static void main(String[] args) {
        
        if (3 > 2) System.out.print("no");
        
        System.out.print('\u000c');
        Scanner scanKbd = new Scanner(System.in);
        
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            choice = getInRangeInt(scanKbd, 0, 4);
            switch (choice) {
                case 1:
                    System.out.println("What is the value (double) for x in radians? ");
                    System.out.printf("Y is %.4f\n", SineCalc.calcYFromX(getDouble(scanKbd)));
                    continueClear(scanKbd);
                    break;
                case 2:
                    System.out.println("How many rectangles should be used to calculate the area? ");
                    int numRects = getInRangeInt(scanKbd, 1, 501);
                    double area = SineCalc.calcArea(numRects);
                    System.out.printf("The estimated area using %d rectangles is: %.4f\n",
                                    numRects, area);
                    continueClear(scanKbd);
                    break;
                case 3:
                    System.out.println("How many rectangles should be drawn on the graph? ");
                    int numRectsDrawn = getInRangeInt(scanKbd, 1, 501);
                    SineDraw.drawRects(numRectsDrawn);
                    SineDraw.drawCurve();
                    continueClear(scanKbd);
                    SineDraw.clearCanvas();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Not a valid choice");
            }
        }
        scanKbd.close();
    }
    
    /**
     * Finishes end of action and clears screen
     * @param  scanKeyboard  Scanner object to clear input buffer
     */
    public static void continueClear(Scanner scanKeyboard) {
        System.out.print("Press <Enter> to continue.");
        scanKeyboard.nextLine();
        scanKeyboard.nextLine();
        System.out.print('\u000c');
    }
    
    /**
     * Displays menu banner and choices
     */
    public static void displayMenu(){
        //banner
        String dashLine = "";
        for (int dash = 0; dash < menuWidth; dash++) {
            dashLine += '-';
        }
        String title = "Sine Wave Menu";
        int titleWidth = (menuWidth - title.length()) / 2 + title.length();
        
        System.out.println(dashLine); 
        System.out.printf("%" + titleWidth + "s\n", title);
        System.out.println(dashLine);
        
        //menu
        System.out.println();
        System.out.println("1.  Find y value for specified radians x");
        System.out.println("2.  Estimate area for 0 <= x <= PI");
        System.out.println("3.  Draw curve with area estimation rectangles");
        System.out.println();
        System.out.println("0.  EXIT the program");
        System.out.println();
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Takes input: int in range start <= x < end. Validates input and displays error messages
     *
     * @param  scanKeyboard  Scanner object, for gathering input
     * @param  start  integer, small end of valid range for input
     * @param  end  integer, large end of valid range for input
     * @return  num  validated integer in range start <= num < end
     */
    public static int getInRangeInt(Scanner scanKeyboard, int start, int end) {
        int num = start - 1;
        boolean hasTried = false;
        while (num < start || num >= end) {
            if(hasTried) {
                System.out.print("Not in range. Try again: ");
            }
            hasTried = true;
            while (!scanKeyboard.hasNextInt()) {
                scanKeyboard.nextLine();
                System.out.print("Not a number. Try again: ");
            }
            num = scanKeyboard.nextInt();
        }
        return num;
    }
    
    /**
     * Takes input: double. Validates data type and displays error messages
     *
     * @param  scanKeyboard  Scanner object, for gathering input
     * @return  dbl  a valid number of type double, any range
     */
    public static double getDouble(Scanner scanKeyboard) {
        double dbl = 0;
        if (scanKeyboard.hasNextDouble()) {
            dbl = scanKeyboard.nextDouble();
        } else {
            while (!scanKeyboard.hasNextDouble()) {
                System.out.print("Not a double. Try again: ");
                scanKeyboard.nextLine();
            }
            dbl = scanKeyboard.nextDouble();
        }
        return dbl;
    }
}
