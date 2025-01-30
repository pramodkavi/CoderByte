package Q6_MinWindowSubstring;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] targetCount = new int[128];
        int[] windowCount = new int[128];

        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int left = 0, right = 0, minStart = 0, minLen = Integer.MAX_VALUE, required = t.length(), formed = 0;

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (targetCount[rc] > 0) {
                windowCount[rc]++;
                if (windowCount[rc] <= targetCount[rc]) {
                    formed++;
                }
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char lc = s.charAt(left);
                if (targetCount[lc] > 0) {
                    windowCount[lc]--;
                    if (windowCount[lc] < targetCount[lc]) {
                        formed--;
                    }
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
    }
}
