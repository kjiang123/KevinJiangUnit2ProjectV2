public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

 public LinearEquation(int x1, int y1, int x2, int y2){
     this.x1 = x1;
     this.y1 = y1;
     this.x2 = x2;
     this.y2 = y2;
 }
    public double distance() {
        int xDistance = Math.abs(x2-x1);
        int yDistance = Math.abs(y2-y1);
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return roundedToHundredth(distance);
    }
    public double yIntercept() {
        return y1-slope()*x1;
    }
    public double slope() {
        double slope = ((double)y2-y1)/(x2-x1);
        return roundedToHundredth(slope);
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation(){
        int top = y2 - y1;
        int bottom = x2 - x1;
        String yIntercept = String.valueOf(yIntercept());
        String slope = top + "/" + bottom + "x ";

        //whole number slope
        if(((double)top/bottom)%1 ==0){
            slope = top/bottom + "x ";
            if(top/bottom == 1){
                slope = "x "; //slope = 1
            }else if (top/bottom == -1){
                slope = "-x "; //slope = -1
            }else if (top/bottom == 0){
                slope = ""; //slope = 0
            }
        }

        //if slope is not a whole number
        else if (bottom < 0){
            bottom = Math.abs(bottom);
            slope = "-"+top + "/" + bottom + "x "; //transfers the bottom negative sign to the top
            if (top < 0){
                top = Math.abs(top);
                slope = top + "/" + bottom + "x "; //if top and bottom are negative then both become positive
            }
        }

        //giving y intercept a sign when there is a slope
        if (yIntercept() > 0 && (double)top/bottom != 0){
            yIntercept = "+ " + yIntercept; //positive y intercept
        }
        else if (yIntercept() < 0 && (double)top/bottom != 0){
            yIntercept = yIntercept.substring(0,1) + " "+ yIntercept.substring(1); // negative y intercept
        }else if (yIntercept() < 0 && top/bottom == 0) {
            yIntercept = String.valueOf(yIntercept()); //y intercept when no slope
        }else if(yIntercept() == 0){
            yIntercept = ""; //no y intercept
        }
        return "y = " + slope + yIntercept;
    }
    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        double yValue = roundedToHundredth(slope()*xValue+yIntercept());
        return "(" + xValue +", " + yValue + ")";
    }


    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound*100.0)/100.0;
    }


    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo() {
        return "The two points are: "+"("+x1+", "+y1+") and ("+x2+", "+y2+")\nThe equation of the line between these points is: "+equation()+"\nThe slope of this line is: "+slope()+"\nThe y-intercept of the line is: "+yIntercept()+"\nThe distance between the two points is: "+distance();
    }
}

