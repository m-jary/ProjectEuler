package Problem1;
/*Multiples of 3 or 5
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> multiples = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                multiples.add(i);
            }
        }
        System.out.println(multiples);

        int sum = 0;
        for (Integer multiple : multiples) {
            sum += multiple;
        }
        System.out.println(sum);
    }
}