package Problem_16_Completed;
/*Power Digit Sum
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of the number
2^1000?*/

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        BigInteger number = BigInteger.TWO.pow(1000);
        System.out.println(number);

        BigInteger remainder;
        BigInteger sum = BigInteger.ZERO;
        while (number.compareTo(BigInteger.ZERO) > 0) {
            remainder = number.remainder(BigInteger.TEN);
            sum = sum.add(remainder);
            number = number.divide(BigInteger.TEN);
        }
        System.out.println(sum);
    }
}
