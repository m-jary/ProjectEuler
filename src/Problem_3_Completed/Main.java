package Problem_3_Completed;
/*Largest Prime Factor
The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143?*/

public class Main {
    public static void main(String[] args) {

        long n = 600_851_475_143L;
        while (n % 2 == 0) {
            System.out.println(2 + " ");
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.println(i + " ");
                n /= i;
            }
        }

        if (n > 2) {
            System.out.println(n);
        }
    }
}
