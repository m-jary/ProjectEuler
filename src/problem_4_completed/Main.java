package problem_4_completed;
/*Largest Palindrome Product
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers
is 9009 = 91 * 99.
Find the largest palindrome made from the product of two 3-digit numbers.*/

public class Main {

    public static boolean isPalindrome(String palindrome) {
        boolean isPalindrome = true;
        for (int c = 0; c < palindrome.length(); c++) {
            if (palindrome.charAt(c) != palindrome.charAt(palindrome.length() - 1 - c)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
    public static void main(String[] args) {

        int product;
        int biggestPalindrome = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                product = i * j;
                String numberToCheck = Integer.toString(product);
                if (isPalindrome(numberToCheck) && product > biggestPalindrome) {
                    biggestPalindrome = product;
                    /*System.out.println("Current biggest palindrome: " + biggestPalindrome);*/
                }
            }
        }
        System.out.println("Biggest palindrome: " + biggestPalindrome);
    }
}
