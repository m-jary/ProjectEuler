package Problem_20_Completed;
/*Factorial Digit Sum
n! means n * (n - 1) * ... * 3 * 2 * 1.
For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800, and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 +
 8 + 0 + 0 = 27.
Find the sum of the digits in the number 100!.*/

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            BigInteger currentNumber = BigInteger.valueOf(i);
            factorial = factorial.multiply(currentNumber);
        }
        String number = factorial.toString();
        System.out.println(number);

        int sum = 0;
        for (int j = 0; j < number.length(); j++) {
            int digit = Character.getNumericValue(number.charAt(j));
            sum += digit;
        }
        System.out.println(sum);
    }
}
