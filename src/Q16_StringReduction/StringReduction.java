package Q16_StringReduction;

/**
 * Have the function StringReduction(str) take the str parameter being passed and return the smallest number you can
 * get through the following reduction method. The method is: Only the letters a, b, and c will be given in str and you
 * must take two different adjacent characters and replace it with the third. For example "ac" can be replaced with
 * "b" but "aa" cannot be replaced with anything. This method is done repeatedly until the string cannot be further
 * reduced, and the length of the resulting string is to be outputted. For example: if str is "cab", "ca" can be
 * reduced to "b" and you get "bb" (you can also reduce it to "cc"). The reduction is done so the output should be 2.
 * If str is "bcab", "bc" reduces to "a", so you have "aab", then "ab" reduces to "c", and the final string "ac" is
 * reduced to "b" so the output should be 1.
 *
 */

public class StringReduction {
    public static int stringReduction(String str) {
        int countA = 0, countB = 0, countC = 0;

        // Count occurrences of 'a', 'b', and 'c'
        for (char ch : str.toCharArray()) {
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;
        }

        // If all characters are the same, return the length (no reductions possible)
        if ((countA == 0 && countB == 0) ||
                (countA == 0 && countC == 0) ||
                (countB == 0 && countC == 0)) {
            return str.length();
        }

        // If all counts are either even or odd, the smallest possible length is 2
        if ((countA % 2 == countB % 2) && (countB % 2 == countC % 2)) {
            return 2;
        }

        // Otherwise, the smallest possible length is 1
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(stringReduction("cab"));   // Output: 2
        System.out.println(stringReduction("bcab"));  // Output: 1
        System.out.println(stringReduction("aaa"));   // Output: 3
        System.out.println(stringReduction("abcabc")); // Output: 2
    }
}


//    Explanation of Code
//        Step 1: Count Character Frequencies
//        We count occurrences of 'a', 'b', and 'c' using three variables: countA, countB, countC.

//        Step 2: Check Edge Cases
//        If the string contains only one type of character, reductions cannot be performed, so return the original length.

//        Step 3: Determine Minimum Length
//        If all counts are either even or odd, the minimum possible length is 2.
//        Otherwise, the minimum possible length is 1.