package Problem_14_Completed;
/*Longest Collatz Sequence
The following iterative sequence is defined for the set of positive integers:
n -> n/2 (n is even)
n -> 3n + 1 (n is odd)
Using the rule above and starting with 13, we generate the following sequence:
13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1.
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been
proved yet (Collatz Problem), it is thought that all starting numbers finish at 1. Which starting number, under one
million, produces the longest chain? Once the chain starts the terms are allowed to go above one million.*/

public class Main {

    public static int getNumberOfTerms(Integer n) {
        long number = n;
        int terms = 0;
        int numberOfTerms;

        while (number >= 1) {
            if (number % 2 == 0) {
                terms++;
                number /= 2;
            } else if (number == 1 && terms != 0) {
                break;
            } else {
                terms++;
                number = 3 * number + 1;
            }
        }
        if (number == 1) {
            terms++;
        }
        numberOfTerms = terms;
        return numberOfTerms;
    }

    public static void main(String[] args) {

        int currentTerms;
        int maxTerms = 0;
        int biggestNumber = 0;

        for (int i = 2; i < 1000000; i++) {
            currentTerms = getNumberOfTerms(i);
            if (currentTerms > maxTerms) {
                maxTerms = currentTerms;
                biggestNumber = i;
            }
        }
        System.out.println(biggestNumber);
        System.out.println(maxTerms);
    }
}