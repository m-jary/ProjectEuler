package Problem7;
/*10001st Prime
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6 th prime is 13. What is the
10,001st prime number?*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int flag;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (int i = 0; i < 105000; i++) {
            if (i == 1 || i == 0) {
                continue;
            }
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
        System.out.println(primeNumbers);
        System.out.println(primeNumbers.size());
        System.out.println(primeNumbers.get(10000));
    }
}
