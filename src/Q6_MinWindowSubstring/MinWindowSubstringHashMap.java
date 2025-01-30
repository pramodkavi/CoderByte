package Q6_MinWindowSubstring;

import java.util.HashMap;

public class MinWindowSubstringHashMap {
    public static String minWindow(String s, String t) {
        // Store frequency of characters in t
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, minStart = 0, minLen = Integer.MAX_VALUE, required = t.length();
        int formed = 0;
        HashMap<Character, Integer> windowMap = new HashMap<>(); // Store frequency of characters in current window

        // Expand the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            windowMap.put(rc, windowMap.getOrDefault(rc, 0) + 1);

            // If character in window matches the required frequency in t
            if (targetMap.containsKey(rc) && windowMap.get(rc) <= targetMap.get(rc)) {
                formed++;
            }

            // Try to shrink the window from the left while all required characters are found
            while (formed == required) {
                // Update minimum window size and start position
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove the leftmost character from the window
                char lc = s.charAt(left);
                windowMap.put(lc, windowMap.get(lc) - 1);
                if (targetMap.containsKey(lc) && windowMap.get(lc) < targetMap.get(lc)) {
                    formed--;
                }
                left++; // Move the left pointer forward
            }
        }

        // Return the minimum window substring or an empty string if not found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
    }
}
