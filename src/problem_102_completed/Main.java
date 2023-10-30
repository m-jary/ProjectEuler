package problem_102_completed;
/*Triangle Containment
Three distinct points are plotted at random on a Cartesian plane, for which -1000 <= x, y <= 1000, such that a
triangle is formed.
Consider the following two triangles:
        A(-340,495), B(-153,-910), C(835,-947)
        X(-175,41), Y(-421,-714), Z(574,-645)
It can be verified that triangle ABC contains the origin, whereas triangle XYZ does not.
Using triangles.txt (right click and 'Save Link/Target As...'), a 27K text file containing the co-ordinates of one
thousand "random" triangles, find the number of triangles for which the interior contains the origin.
NOTE: The first two examples in the file represent the triangles in the example given above.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }

    static boolean containsOrigin(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        double A = area(x1, y1, x2, y2, x3, y3);
        double A1 = area(x, y, x2, y2, x3, y3);
        double A2 = area(x, y, x1, y1, x3, y3);
        double A3 = area(x, y, x1, y1, x2, y2);
        return (A == A1 + A2 + A3);
    }

    public static void main(String[] args) throws FileNotFoundException {

        File triangles = new File("triangles.txt");
        Scanner reader = new Scanner(triangles);
        int[] coordinates;
        int x = 0;
        int y = 0;
        int counter = 0;

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] numbers = line.split(",");

            coordinates = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                coordinates[i] = Integer.parseInt(numbers[i]);
            }

            if (containsOrigin(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5], x, y)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
