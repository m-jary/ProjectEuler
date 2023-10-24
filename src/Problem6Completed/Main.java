package Problem6Completed;
/*Sum Square Difference
The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... + 10^2 = 385.
The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)^2 = 55^2 = 3025.
Hence, the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
3025 - 385 = 2640. Find the difference between the sum of the squares of the first one hundred natural numbers and
the square of the sum.*/

public class Main {
    public static void main(String[] args) {

        int sumOfSquares = 0;
        int squareOfSum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += (int) Math.pow(i, 2);
        }
        System.out.println(sumOfSquares);

        for (int i = 1; i <= 100; i++) {
            squareOfSum += i;
        }
        squareOfSum = (int) Math.pow(squareOfSum, 2);
        System.out.println(squareOfSum);

        System.out.println(squareOfSum - sumOfSquares);
    }
}
