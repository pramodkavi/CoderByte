package Q14StringPeriods;

public class StringPeriods {
    public static String findLongestRepeatingSubstring(String str) {
        int len = str.length();

        // Iterate through all possible substring lengths
        for (int subLen = len / 2; subLen >= 1; subLen--) {
            if (len % subLen == 0) { // Check if substring can evenly divide the string
                String subStr = str.substring(0, subLen);
                int repeatCount = len / subLen;

                // Construct a new string by repeating the substring
                String repeatedString = subStr.repeat(repeatCount);

                // If repeating the substring forms the original string, return it
                if (repeatedString.equals(str)) {
                    return subStr;
                }
            }
        }
        return "-1"; // No repeating substring found
    }

    public static void main(String[] args) {
        System.out.println(findLongestRepeatingSubstring("abcababcababcab")); // Output: "abcab"
//        System.out.println(findLongestRepeatingSubstring("abababababab"));   // Output: "ababab"
//        System.out.println(findLongestRepeatingSubstring("abcxabc"));       // Output: "-1"
    }
}
