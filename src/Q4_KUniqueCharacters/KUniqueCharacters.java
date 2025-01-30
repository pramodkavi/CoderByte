package Q4_KUniqueCharacters;

import java.util.Arrays;

public class KUniqueCharacters {
    public static String kUniqueCharacters(String str) {
        int k = Character.getNumericValue(str.charAt(0));
        String s = str.substring(1);

        int[] charCount = new int[128];
        System.out.println(Arrays.toString(charCount));
        int left = 0, right = 0, uniqueCount = 0;
        String longestSubstring = "";

        while (right < s.length()) {
            if (charCount[s.charAt(right)] == 0) {
                uniqueCount++;
            }
            charCount[s.charAt(right)]++;

            while (uniqueCount > k) {
                charCount[s.charAt(left)]--;
                if (charCount[s.charAt(left)] == 0) {
                    uniqueCount--;
                }
                left++;
            }

            if (uniqueCount == k && (right - left + 1) > longestSubstring.length()) {
                longestSubstring = s.substring(left, right + 1);
            }

            right++;
        }

        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(kUniqueCharacters("3aabacbebebe")); // Output: "cbebebe"
        System.out.println(kUniqueCharacters("2aabbcbbbadef")); // Output: "bbcbbb"
    }
}
