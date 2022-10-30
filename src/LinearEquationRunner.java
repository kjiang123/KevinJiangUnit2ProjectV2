import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //finding the index of the comma
        System.out.print("Enter a coordinate point: ");
        String point1 = scan.nextLine();
        int comma1 = point1.indexOf(",");

        //getting the individual values for x1 and y1
        String sX1 = point1.substring(1, comma1);
        int x1 = Integer.parseInt(sX1);
        String sY1 = point1.substring(comma1 + 2, point1.length() - 1);
        int y1 = Integer.parseInt(sY1);

        //finding the index of the comma
        System.out.print("Enter a coordinate point: ");
        String point2 = scan.nextLine();
        int comma2 = point2.indexOf(",");

        //getting the individual values of x2 and y2
        String sX2 = point2.substring(1, comma2);
        int x2 = Integer.parseInt(sX2);
        String sY2 = point2.substring(comma2 + 2, point2.length() - 1);
        int y2 = Integer.parseInt(sY2);

        if (x1==x2){ // checks if points are on a vertical line
            System.out.println("\nThe points are on a vertical line: x=" + x1);
        }else {
            LinearEquation lin = new LinearEquation(x1, y1, x2, y2);
            System.out.println("\n"+lin.lineInfo());
            System.out.print("\nEnter a value for x: ");
            double userNum = scan.nextDouble();
            System.out.println("\nThe point on the line is: " + lin.coordinateForX(userNum));
        }
    }
}
