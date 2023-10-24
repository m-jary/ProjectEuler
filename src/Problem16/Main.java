package Problem16;
/*2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of the number
2^1000?*/

public class Main {
    public static void main(String[] args) {

        long number = (long) Math.pow(2, 15);
        System.out.println(number);

        long remainder;
        long sum = 0;
        while (number > 0) {
            remainder = number % 10;
            sum += remainder;
            number /= 10;
        }
        System.out.println(sum);
    }
}
