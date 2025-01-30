package Q17_PrimeMover;
/**
 * Have the function PrimeMover(num) return the numth prime number. The range will be from 1 to 10^4.
 * For example: if num is 16 the output should be 53 as 53 is the 16th prime number.
 *
 */

public class PrimeMover {
    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) return false; // Numbers < 2 are not prime
        for (int i = 2; i * i <= num; i++) { // Only check up to sqrt(num)
            if (num % i == 0) return false; // If divisible, not prime
        }
        return true;
    }

    // Function to find the nth prime number
    public static int primeMover(int num) {
        int count = 0; // Count of prime numbers found
        int candidate = 1; // Start checking from 2

        while (count < num) { // Loop until we find the num-th prime
            candidate++; // Increment candidate number
            if (isPrime(candidate)) {
                count++; // Increment count if it's prime
            }
        }

        return candidate; // Return the num-th prime number
    }

    public static void main(String[] args) {
        System.out.println(primeMover(16)); // Output: 53
        System.out.println(primeMover(5));  // Output: 11
        System.out.println(primeMover(1));  // Output: 2
        System.out.println(primeMover(100)); // Output: 541
    }
}
