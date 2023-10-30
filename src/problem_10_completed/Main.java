package problem_10_completed;
/*Summation of Primes
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int flag;
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        long sum = 0;

        for (int i = 2; i < 2000000; i++) {
            flag = 1;

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                primeNumbers.add(i);
            }
        }

        for (Integer primeNumber : primeNumbers) {
            sum += primeNumber;
        }
        System.out.println(sum);
    }
}