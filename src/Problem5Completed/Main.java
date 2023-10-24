package Problem5Completed;
/*Smallest Multiple
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible (divisible with no remainder) by all the numbers from 1
 to 20?*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }

        long smallestPosNumb = 0;
        int checker = 0;
        for (long i = 1; i < 1000000000; i++) {
            for (Integer number : numbers) {
                if (i % number == 0) {
                    checker++;
                }

            }
            if (checker == numbers.size()) {
                smallestPosNumb = i;
                break;
            } else {
                checker = 0;
            }
        }
        System.out.println(smallestPosNumb);
    }
}
