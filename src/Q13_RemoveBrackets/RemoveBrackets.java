package Q13_RemoveBrackets;

// For this challenge you will determine how to create evenly matched brackets.have the function RemoveBrackets(str)
// take the str string parameter being passed, which will contain only the characters "(" and ")", and determine the
// minimum number of brackets that need to be removed to create a string of correctly matched brackets. For example:
// if str is "(()))" then your program should return the number 1. The answer could potentially be 0, and there will
// always be at least one set of matching brackets in the string.

public class RemoveBrackets {

    public static int removeBrackets(String str) {
        int openCount = 0; // To track unmatched opening brackets '('
        int closeCount = 0; // To track unmatched closing brackets ')'

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                openCount++; // Count the number of '('
            } else if (ch == ')') {
                if (openCount > 0) {
                    openCount--; // Match a '(' with a ')'
                } else {
                    closeCount++; // No '(' to match, so this ')' is unmatched
                }
            }
        }

        // Total removals required = unmatched '(' + unmatched ')'
        return openCount + closeCount;
    }

    public static void main(String[] args) {
        System.out.println(removeBrackets("(()))"));   // Output: 1
        System.out.println(removeBrackets("((())"));   // Output: 1
        System.out.println(removeBrackets("()"));      // Output: 0
        System.out.println(removeBrackets("))((("));   // Output: 4
    }
}
