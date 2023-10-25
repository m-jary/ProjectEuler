package Problem_25_Completed;
/*1000-digit Fibonacci Number
The Fibonacci sequence is defined by the recurrence relation:
F_n = F_{n - 1} + F_{n - 2}, where F_1 = 1 and F_2 = 1.
Hence, the first 12 terms will be:
        F_1 = 1
        F_2 = 1
        F_3 = 2
        F_4 = 3
        F_5 = 5
        F_6 = 8
        F_7 = 13
        F_8 = 21
        F_9 = 34
        F_10 = 55
        F_11 = 89
        F_12 = 144
The 12th term, F_12, is the first term to contain three digits.
What is the index of the first term in the Fibonacci sequence to contain 1000 digits?*/

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        BigInteger number1 = BigInteger.ONE;
        BigInteger number2 = BigInteger.ONE;
        BigInteger number3 = BigInteger.ZERO;
        int indexCounter = 2;
        boolean has1000Digits = false;

        while (!has1000Digits) {
            indexCounter++;
            number3 = number1.add(number2);
            number1 = number2;
            number2 = number3;
            String check = number3.toString();

            if (check.length() == 1000) {
                has1000Digits = true;
            }
        }
        System.out.println("F_" + indexCounter + " is the first term to contain 1000 digits.");
        System.out.println("F_" + indexCounter + ": " + number3);
    }
}
