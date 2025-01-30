package Q15_RunLength;
//Have the function RunLength(str) take the str parameter being passed and return a compressed version of the string
//using the Run-length encoding algorithm. This algorithm works by taking the occurrence of each repeating character
//and outputting that number along with a single character of the repeating sequence.
//For example: "wwwggopp" would return 3w2g1o2p. The string will not contain any numbers, punctuation, or symbols.

public class RunLengthEncoding {
    public static String runLength(String str) {
        if (str == null || str.isEmpty()) {
            return ""; // Edge case: Empty input
        }

        StringBuilder result = new StringBuilder(); // To store the compressed result
        int count = 1; // Counter for consecutive characters

        // Iterate through the string
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++; // Increment count for repeating character
            } else {
                result.append(count).append(str.charAt(i - 1)); // Append count and character
                count = 1; // Reset count for new character
            }
        }

        // Append the last counted character
        result.append(count).append(str.charAt(str.length() - 1));

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLength("wwwggopp")); // Output: "3w2g1o2p"
        System.out.println(runLength("aabbcde"));  // Output: "2a2b1c1d1e"
        System.out.println(runLength("abcd"));     // Output: "1a1b1c1d"
        System.out.println(runLength("aaa"));      // Output: "3a"
    }
}
