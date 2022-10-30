import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a coordinate point: ");
        String point1 = scan.nextLine();
        int comma1 = point1.indexOf(",");

        String sX1 = point1.substring(1, comma1);
        int x1 = Integer.parseInt(sX1);
        String sY1 = point1.substring(comma1 + 2, point1.length() - 1);
        int y1 = Integer.parseInt(sY1);

        System.out.print("Enter a coordinate point: ");
        String point2 = scan.nextLine();
        int comma2 = point2.indexOf(",");

        String sX2 = point2.substring(1, comma2);
        int x2 = Integer.parseInt(sX2);
        String sY2 = point2.substring(comma2 + 2, point2.length() - 1);
        int y2 = Integer.parseInt(sY2);

        if (x1==x2){
            System.out.println("\nThe points are on a vertical line: x=" + x1);
        }else {
            LinearEquation lin = new LinearEquation(x1, y1, x2, y2);
            System.out.println("\nThe two points are: " + point1 + " and " + point2);
            System.out.println("The equation of this line is: " + lin.equation());
            System.out.println("The slope is: " + lin.slope());
            System.out.println("The y-intercept of the line is: " + lin.yIntercept());
            System.out.println("The distance between the two points is: " + lin.distance());

            System.out.print("\nEnter a value for x: ");
            double userNum = scan.nextDouble();
            System.out.println("\nThe point on the line is: " + lin.coordinateForX(userNum));
        }
    }
}
