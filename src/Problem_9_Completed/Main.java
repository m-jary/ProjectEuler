package Problem_9_Completed;
/*Special Pythagorean Triplet
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2. For example, 3^2 +
4^2 = 9 + 16 = 25 = 5^2. There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the
product abc.*/

public class Main {
    public static void main(String[] args) {

        for (int c = 1; c < 1000; c++) {
            for (int b = 1; b < c; b++) {
                for (int a = 1; a < b; a++) {
                    if (a * a + b * b == c * c && a + b + c == 1000) {
                        System.out.println(a * b * c);
                    }
                }
            }
        }
    }
}
