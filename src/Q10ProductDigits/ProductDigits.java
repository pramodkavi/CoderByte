package Q10ProductDigits;

//For this challenge you will be determining the least amount of digits needed to produce a number.
// have the function ProductDigits(num) take the num parameter being passed which will be a positive integer,
// and determine the least amount of digits you need to multiply to produce it. For example: if num is 24 then
// you can multiply 8 by 3 which produces 24, so your program should return 2 because there is a total of only
// 2 digits that are needed. Another example: if num is 90, you can multiply 10 * 9, so in this case your program
// should output 3 because you cannot reach 90 without using a total of 3 digits in your multiplication.

public class ProductDigits {
    public static int productDigits(int num) {
        int minDigits = Integer.MAX_VALUE; // Initialize with max value

        // Iterate through possible factors up to sqrt(num)
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // Check if i is a factor
                int factor1 = i;
                int factor2 = num / i;

                // Count digits in both factors
                int digitCount = countDigits(factor1) + countDigits(factor2);

                // Update minimum digits needed
                minDigits = Math.min(minDigits, digitCount);
            }
        }
        return minDigits;
    }

    // Helper function to count digits in a number
    private static int countDigits(int n) {
        System.out.println("/////"+n);
        return String.valueOf(n).length();
    }

    public static void main(String[] args) {
        // Test cases
//        System.out.println(productDigits(24));  // Output: 2 (8 * 3)
//        System.out.println(productDigits(90));  // Output: 3 (10 * 9)
        System.out.println(productDigits(100)); // Output: 2 (10 * 10)
//        System.out.println(productDigits(7));   // Output: 2 (7 * 1)
    }
}


//Explanation
//        for (int i = 1; i <= Math.sqrt(num); i++)
//        We iterate up to √num to reduce unnecessary checks (since i * (num / i) = num).
//        num % i == 0
//        Ensures i is a valid factor.
//        countDigits(factor1) + countDigits(factor2)
//        Computes the total digit count of the factor pair.
//        minDigits = Math.min(minDigits, digitCount);
//        Tracks the smallest digit count found.